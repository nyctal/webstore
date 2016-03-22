package com.nyctalcorp.webstore.service.impl;

import com.nyctalcorp.webstore.domain.Customer;
import com.nyctalcorp.webstore.domain.repository.CustomerRepository;
import com.nyctalcorp.webstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Giacinto on 22/03/2016.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }
}
