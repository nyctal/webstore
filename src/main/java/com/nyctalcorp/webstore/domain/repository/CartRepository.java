package com.nyctalcorp.webstore.domain.repository;

import com.nyctalcorp.webstore.domain.Cart;

/**
 * Created by Giacinto on 10/06/2016.
 */
public interface CartRepository {
    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);
}
