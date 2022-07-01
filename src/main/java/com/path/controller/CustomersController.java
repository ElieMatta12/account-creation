package com.path.controller;

import com.path.model.Customer;
import com.path.service.CustomerService;
import com.path.service.TransactionService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomersController {

    private final CustomerService customerService;

    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    private List<Customer> getCustomers() {
        return customerService.getCustomers();
    }
}
