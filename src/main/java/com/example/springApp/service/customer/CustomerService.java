package com.example.springApp.service.customer;

import java.util.List;
import com.example.springApp.domain.Customer;
import com.example.springApp.dto.CustomerDTO;
import com.example.springApp.entity.CustomerEntity;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer findCustomerById(Long Id);
    List<Customer> findAllCustomers();
    Customer updateCustomer(Customer customer);
    List<Customer> deleteCustomerById(Long id);
    List<Customer> deleteCustomer(Customer customer);
}