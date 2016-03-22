package com.nyctalcorp.webstore.service;

import com.nyctalcorp.webstore.domain.Customer;

import java.util.List;

/**
 * Created by Giacinto on 22/03/2016.
 */
public interface CustomerService {
    List<Customer> getAllCustomers();
}
