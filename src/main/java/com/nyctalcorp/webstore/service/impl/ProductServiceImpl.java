package com.nyctalcorp.webstore.service.impl;

/**
 * Created by Giacinto on 22/03/2016.
 */

import com.nyctalcorp.webstore.domain.Product;
import com.nyctalcorp.webstore.domain.repository.ProductRepository;
import com.nyctalcorp.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public Product getProductById(String productID) {
        return productRepository.getProductById(productID);
    }
    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.getProductsByCategory(category);
    }
    @Override
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        return productRepository.getProductsByFilter(filterParams);
    }
    @Override
    public List<Product> getProductsByManufacturer(String manufacturer) {
        return productRepository.getProductsByManufacturer(manufacturer);
    }
    @Override
    public List<Product> getProductsByPriceFilter(BigDecimal low, BigDecimal high) {
        return productRepository.getProductsByPriceFilter(low, high);
    }
    @Override
    public Set<Product> filterProducts(BigDecimal lowPrice, BigDecimal highPrice, String manufacturer, String category) {
        return productRepository.filterProducts(lowPrice, highPrice,
                manufacturer, category);
    }
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }
}
