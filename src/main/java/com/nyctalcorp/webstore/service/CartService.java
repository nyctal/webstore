package com.nyctalcorp.webstore.service;

/**
 * Created by Giacinto on 10/06/2016.
 */
import com.nyctalcorp.webstore.domain.Cart;

public interface CartService {
    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);
}
