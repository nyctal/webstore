package com.nyctalcorp.webstore.domain.repository;

/**
 * Created by Giacinto on 18/03/2016.
 */
import com.nyctalcorp.webstore.domain.Product;
import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts();
}
