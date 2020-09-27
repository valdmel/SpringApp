package com.example.springApp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.springApp.model.Customer;

@Service
public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer findCustomerById(Long Id);
    List<Customer> findAllCustomers();
    Customer updateCustomer(Customer customer);
    List<Customer> deleteCustomerById(Long id);
    List<Customer> deleteCustomer(Customer customer);
}