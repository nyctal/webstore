package com.nyctalcorp.webstore.service;

/**
 * Created by Giacinto on 22/03/2016.
 */
public interface OrderService {
    void processOrder(String productId, int count);
}
