package com.nyctalcorp.webstore.service;

/**
 * Created by Giacinto on 22/03/2016.
 */


import com.nyctalcorp.webstore.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(String productID);
    List<Product> getProductsByCategory(String category);
    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
    List <Product> getProductsByManufacturer(String manufacturer);

    List<Product> getProductsByPriceFilter(BigDecimal low, BigDecimal high);

    Set<Product> filterProducts(BigDecimal lowPrice, BigDecimal highPrice, String manufacturer, String category);
    void addProduct(Product product);
}
