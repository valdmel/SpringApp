package com.example.springApp.service;

import java.util.List;
import com.example.springApp.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springApp.model.Customer;
import com.example.springApp.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    
    @Override
    public Customer findCustomerById(Long id) {
        if (customerRepository.existsById(id)) {
            return customerRepository.findById(id).get();
        }

        throw new CustomerNotFoundException(id);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        customerRepository.save(customer);
        
        return customerRepository.findById(customer.getId()).get();
    }
    
    @Override
    public List<Customer> deleteCustomerById(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);

            return customerRepository.findAll();
        }

        throw new CustomerNotFoundException(id);
    }

    @Override
    public List<Customer> deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
        
        return customerRepository.findAll();
    }
}
