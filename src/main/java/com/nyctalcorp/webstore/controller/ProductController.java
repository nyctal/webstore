package com.nyctalcorp.webstore.controller;

/**
 * Created by Giacinto on 18/03/2016.
 */
import com.nyctalcorp.webstore.domain.Product;
import com.nyctalcorp.webstore.exception.NoProductsFoundUnderCategoryException;
import com.nyctalcorp.webstore.exception.ProductNotFoundException;
import com.nyctalcorp.webstore.service.ProductService;
import com.nyctalcorp.webstore.validator.ProductValidator;
import com.nyctalcorp.webstore.validator.UnitsInStockValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductValidator productValidator;

    @RequestMapping
    public String list(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }
    @RequestMapping("/all")
    public String allProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }
/*    @RequestMapping("/{category}")
    public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
        model.addAttribute("products", productService.getProductsByCategory(productCategory));
        return "products";
    }*/
    @RequestMapping("/{category}")
    public String getProductsByCategory(Model model, @PathVariable("category") String category) {
        List<Product> products = productService.getProductsByCategory(category);
        if (products == null || products.isEmpty()) {
            throw new NoProductsFoundUnderCategoryException();
        }
        model.addAttribute("products", products);
        return "products";
    }
    @RequestMapping("/filter/{ByCriteria}")
    public String getProductsByFilter(@MatrixVariable(pathVar="ByCriteria") Map<String,List<String>> filterParams, Model model) {
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "products";
    }
    @RequestMapping("/product")
    public String getProductById(@RequestParam("id") String productId, Model model) {
        model.addAttribute("product", productService.getProductById(productId));
        return "product";
    }
    @RequestMapping("/{category}/{price}")
    public  String filterProducts(Model model,
                                  @PathVariable("category") String category,
                                  @MatrixVariable(pathVar="price") Map<String,List<String>> priceRange,
                                  @RequestParam("manufacturer") String manufacturer) {

        // Probably shouldn't just take whatever the user gives us....
        BigDecimal lowPrice = new BigDecimal(priceRange.get("low").get(0));
        BigDecimal highPrice = new BigDecimal(priceRange.get("high").get(0));

        model.addAttribute("products", productService.filterProducts(lowPrice, highPrice, manufacturer, category));

        return "products";
    }
/*    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(Model model) {
        Product newProduct = new Product();
        model.addAttribute("newProduct", newProduct);
        return "addProduct";
    }*/
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
        return "addProduct";
}

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product productToBeAdded, BindingResult result, HttpServletRequest request) {
        if(result.hasErrors()) {
            return "addProduct";
        }
        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }
        MultipartFile productImage = productToBeAdded.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        if (productImage!=null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(rootDirectory+"resources\\images\\"+productToBeAdded.getProductId() + ".png"));
            } catch (Exception e) {
                throw new RuntimeException("Product Image saving failed",e);
            }
        }
        MultipartFile productManual = productToBeAdded.getProductManual();
        if (productManual!=null && !productManual.isEmpty()) {
            try {
                productManual.transferTo(new File(rootDirectory+"resources\\pdf\\"+productToBeAdded.getProductId() + ".pdf"));
            } catch (Exception e) {
                throw new RuntimeException("Product Manual saving failed",e);
            }
        }
        productService.addProduct(productToBeAdded);
        return "redirect:/products";
    }
    @RequestMapping("/invalidPromoCode")
    public String invalidPromoCode() {
        return "invalidPromoCode";
    }
    @InitBinder
    public void initialiseBinder(WebDataBinder binder) {

        binder.setDisallowedFields("unitsInOrder", "discontinued");
        binder.setValidator(productValidator);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleError(HttpServletRequest req,ProductNotFoundException exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("invalidProductId", exception.getProductId());
        mav.addObject("exception", exception);
        mav.addObject("url",req.getRequestURL()+"?"+req.getQueryString());
        mav.setViewName("productNotFound");
        return mav;
    }
}
