package com.example.springApp.service.customer.facade;

import com.example.springApp.dto.CustomerDTO;
import com.example.springApp.entity.CustomerEntity;
import com.example.springApp.mapper.CustomerMapper;
import com.example.springApp.service.customer.CustomerService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerFacade {

    @Autowired
    private CustomerService customerService;

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = Mappers.getMapper(CustomerMapper.class).toCustomerEntity(customerDTO);

        return customerService.createCustomer(customerEntity);
    }

    public CustomerDTO findCustomerById(Long id) {
        return customerService.findCustomerById(id);
    }

    public List<CustomerDTO> findAllCustomers() {
        return customerService.findAllCustomers();
    }

    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = Mappers.getMapper(CustomerMapper.class).toCustomerEntity(customerDTO);

        return customerService.updateCustomer(customerEntity);
    }

    public List<CustomerDTO> deleteCustomerById(Long id) {
        return customerService.deleteCustomerById(id);
    }

    public List<CustomerDTO> deleteCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = Mappers.getMapper(CustomerMapper.class).toCustomerEntity(customerDTO);

        return customerService.deleteCustomer(customerEntity);
    }
}
