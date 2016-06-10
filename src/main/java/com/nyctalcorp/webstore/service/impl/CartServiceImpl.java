package com.nyctalcorp.webstore.service.impl;

/**
 * Created by Giacinto on 10/06/2016.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nyctalcorp.webstore.domain.Cart;
import com.nyctalcorp.webstore.domain.repository.CartRepository;
import com.nyctalcorp.webstore.service.CartService;
@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;
    public Cart create(Cart cart) {
        return cartRepository.create(cart);
    }
    public Cart read(String cartId) {
        return cartRepository.read(cartId);
    }
    public void update(String cartId, Cart cart) {
        cartRepository.update(cartId, cart);
    }
    public void delete(String cartId) {
        cartRepository.delete(cartId);
    }
}
