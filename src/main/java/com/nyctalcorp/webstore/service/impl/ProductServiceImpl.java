package com.nyctalcorp.webstore.service.impl;

/**
 * Created by Giacinto on 22/03/2016.
 */

import com.nyctalcorp.webstore.domain.Product;
import com.nyctalcorp.webstore.domain.repository.ProductRepository;
import com.nyctalcorp.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }
}
