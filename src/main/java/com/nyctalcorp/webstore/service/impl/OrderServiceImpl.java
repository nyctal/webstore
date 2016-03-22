package com.nyctalcorp.webstore.service.impl;

/**
 * Created by Giacinto on 22/03/2016.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nyctalcorp.webstore.domain.Product;
import com.nyctalcorp.webstore.domain.repository.ProductRepository;
import com.nyctalcorp.webstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void processOrder(String productId, int quantity) {
        Product productById = productRepository.getProductById(productId);
        if(productById.getUnitsInStock() < quantity){
            throw new IllegalArgumentException("Out of Stock. Available Units in stock" + productById.getUnitsInStock());
        }
        productById.setUnitsInStock(productById.getUnitsInStock() - quantity);
    }
}
