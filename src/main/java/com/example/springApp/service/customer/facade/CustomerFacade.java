package com.example.springApp.service.customer.facade;

import com.example.springApp.domain.Customer;
import com.example.springApp.dto.CustomerDTO;
import com.example.springApp.entity.CustomerEntity;
import com.example.springApp.mapper.CustomerMapper;
import com.example.springApp.service.customer.CustomerService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerFacade {

    @Autowired
    private CustomerService customerService;

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = Mappers.getMapper(CustomerMapper.class).mapCustomerDTOToCustomer(customerDTO);

        return Mappers.getMapper(CustomerMapper.class).mapCustomerToCustomerDTO(customerService.createCustomer(customer));
    }

    public CustomerDTO findCustomerById(Long id) {
        return Mappers.getMapper(CustomerMapper.class).mapCustomerToCustomerDTO(customerService.findCustomerById(id));
    }

    public List<CustomerDTO> findAllCustomers() {
        return Mappers.getMapper(CustomerMapper.class).mapCustomersToCustomersDTO(customerService.findAllCustomers());
    }

    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        Customer customer = Mappers.getMapper(CustomerMapper.class).mapCustomerDTOToCustomer(customerDTO);

        return Mappers.getMapper(CustomerMapper.class).mapCustomerToCustomerDTO(customerService.updateCustomer(customer));
    }

    public List<CustomerDTO> deleteCustomerById(Long id) {
        return Mappers.getMapper(CustomerMapper.class).mapCustomersToCustomersDTO(customerService.deleteCustomerById(id));
    }

    public List<CustomerDTO> deleteCustomer(CustomerDTO customerDTO) {
        Customer customer = Mappers.getMapper(CustomerMapper.class).mapCustomerDTOToCustomer(customerDTO);

        return Mappers.getMapper(CustomerMapper.class).mapCustomersToCustomersDTO(customerService.deleteCustomer(customer));
    }
}
