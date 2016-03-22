package com.nyctalcorp.webstore.service;

/**
 * Created by Giacinto on 22/03/2016.
 */


import com.nyctalcorp.webstore.domain.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
}
