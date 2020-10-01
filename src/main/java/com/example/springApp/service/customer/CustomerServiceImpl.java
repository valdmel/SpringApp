package com.example.springApp.service.customer;

import java.util.List;
import com.example.springApp.dto.CustomerDTO;
import com.example.springApp.entity.CustomerEntity;
import com.example.springApp.exception.CustomerNotFoundException;
import com.example.springApp.mapper.CustomerMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springApp.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDTO createCustomer(CustomerEntity customerEntity) {
        return Mappers.getMapper(CustomerMapper.class).toCustomerDTO(customerRepository.save(customerEntity));
    }
    
    @Override
    public CustomerDTO findCustomerById(Long id) {
        if (customerRepository.existsById(id)) {
            return Mappers.getMapper(CustomerMapper.class).toCustomerDTO(customerRepository.findById(id).get());
        }

        throw new CustomerNotFoundException(id);
    }

    @Override
    public List<CustomerDTO> findAllCustomers() {
        return Mappers.getMapper(CustomerMapper.class).toCustomerDTOList(customerRepository.findAll());
    }

    @Override
    public CustomerDTO updateCustomer(CustomerEntity customerEntity) {
        customerRepository.save(customerEntity);
        
        return Mappers.getMapper(CustomerMapper.class).toCustomerDTO(customerRepository.findById(1L).get());
    }
    
    @Override
    public List<CustomerDTO> deleteCustomerById(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);

            return Mappers.getMapper(CustomerMapper.class).toCustomerDTOList(customerRepository.findAll());
        }

        throw new CustomerNotFoundException(id);
    }

    @Override
    public List<CustomerDTO> deleteCustomer(CustomerEntity customerEntity) {
        customerRepository.delete(customerEntity);
        
        return Mappers.getMapper(CustomerMapper.class).toCustomerDTOList(customerRepository.findAll());
    }
}
