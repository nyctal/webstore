package com.nyctalcorp.webstore.domain.repository.impl;

import com.nyctalcorp.webstore.domain.Customer;
import com.nyctalcorp.webstore.domain.repository.CustomerRepository;
import com.nyctalcorp.webstore.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Giacinto on 22/03/2016.
 */
@Repository
public class InMemoryCustomerRepository implements CustomerRepository{
    private List<Customer> listOfCustomers = new ArrayList<Customer>();

    public InMemoryCustomerRepository() {
        Customer customer = new Customer("cust1", "Nome Prova");
        customer.setAddress("Via Prova");
        customer.setNoOfOrdersMade(true);
        listOfCustomers.add(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return listOfCustomers;
    }
}
