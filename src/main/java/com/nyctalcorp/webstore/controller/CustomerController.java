package com.nyctalcorp.webstore.controller;

import com.nyctalcorp.webstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Giacinto on 22/03/2016.
 */
@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers")
    public String list(Model model)
    {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }
}
