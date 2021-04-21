package com.example.springApp.service.customer;

import java.util.List;
import java.util.Optional;
import com.example.springApp.domain.Customer;
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
    public Customer createCustomer(Customer customer) {
        final Optional<CustomerEntity> customerEntityByFirstName = customerRepository.findCustomerByFirstName(customer.getFirstName());

        if (customerEntityByFirstName.isPresent()) {
            return Mappers.getMapper(CustomerMapper.class).mapCustomerEntityToCustomer(customerEntityByFirstName.get());
        }

        CustomerEntity customerEntity = Mappers.getMapper(CustomerMapper.class).mapCustomerToCustomerEntity(customer);

        return Mappers.getMapper(CustomerMapper.class).mapCustomerEntityToCustomer(customerRepository.save(customerEntity));
    }
    
    @Override
    public Customer findCustomerById(Long id) {
        if (customerRepository.existsById(id)) {
            return Mappers.getMapper(CustomerMapper.class).mapCustomerEntityToCustomer(customerRepository.findById(id).get());
        }

        throw new CustomerNotFoundException(id);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return Mappers.getMapper(CustomerMapper.class).mapCustomerEntitiesToCustomers(customerRepository.findAll());
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        final Optional<CustomerEntity> customerEntityByFirstName = customerRepository.findCustomerByFirstName(customer.getFirstName());

        if (customerEntityByFirstName.isPresent()) {
            CustomerEntity customerEntity = Mappers.getMapper(CustomerMapper.class).mapCustomerToCustomerEntity(customer);

            return Mappers.getMapper(CustomerMapper.class).mapCustomerEntityToCustomer(customerRepository.save(customerEntity));
        }

        throw new CustomerNotFoundException(customer.getFirstName(), customer.getLastName());
    }
    
    @Override
    public List<Customer> deleteCustomerById(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);

            return Mappers.getMapper(CustomerMapper.class).mapCustomerEntitiesToCustomers(customerRepository.findAll());
        }

        throw new CustomerNotFoundException(id);
    }

    @Override
    public List<Customer> deleteCustomer(Customer customer) {
        CustomerEntity customerEntity = Mappers.getMapper(CustomerMapper.class).mapCustomerToCustomerEntity(customer);

        customerRepository.delete(customerEntity);
        
        return Mappers.getMapper(CustomerMapper.class).mapCustomerEntitiesToCustomers(customerRepository.findAll());
    }
}
