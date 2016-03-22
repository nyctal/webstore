package com.nyctalcorp.webstore.domain.repository;
/**
 * Created by Giacinto on 22/03/2016.
 */
import com.nyctalcorp.webstore.domain.Customer;
import java.util.List;

public interface CustomerRepository {
    List<Customer> getAllCustomers();
}
