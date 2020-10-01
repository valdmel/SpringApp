package com.example.springApp.service.customer;

import java.util.List;
import com.example.springApp.dto.CustomerDTO;
import com.example.springApp.entity.CustomerEntity;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    CustomerDTO createCustomer(CustomerEntity customerEntity);
    CustomerDTO findCustomerById(Long Id);
    List<CustomerDTO> findAllCustomers();
    CustomerDTO updateCustomer(CustomerEntity customerEntity);
    List<CustomerDTO> deleteCustomerById(Long id);
    List<CustomerDTO> deleteCustomer(CustomerEntity customerEntity);
}