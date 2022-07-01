package com.path.service;

import com.path.model.Customer;
import com.path.repository.CustomersRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomersRepository customerRepository;

    public CustomerService(CustomersRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
