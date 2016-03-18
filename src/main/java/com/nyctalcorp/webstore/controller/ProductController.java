package com.nyctalcorp.webstore.controller;

/**
 * Created by Giacinto on 18/03/2016.
 */
import com.nyctalcorp.webstore.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/products")
    public String list(Model model) {
        model.addAttribute("products", productRepository.getAllProducts());
        return "products";
    }
}
