package com.example.springApp.service.customer.facade;

import com.example.springApp.domain.Customer;
import com.example.springApp.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerFacade {

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
