package com.example.springApp.service;

import com.example.springApp.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceFacade {

    @Autowired
    private CustomerService customerService;

    public Customer createCustomer(Customer customer) {
        return customerService.createCustomer(customer);
    }

    public Customer findCustomerById(Long id) {
        return customerService.findCustomerById(id);
    }

    public List<Customer> findAllCustomers() {
        return customerService.findAllCustomers();
    }

    public Customer updateCustomer(Customer customer) {
        return customerService.updateCustomer(customer);
    }

    public List<Customer> deleteCustomerById(Long id) {
        return customerService.deleteCustomerById(id);
    }

    public List<Customer> deleteCustomer(Customer customer) {
        return customerService.deleteCustomer(customer);
    }
}
