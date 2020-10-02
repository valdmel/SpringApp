package com.example.springApp.mapper;

import com.example.springApp.domain.Customer;
import com.example.springApp.dto.CustomerDTO;
import com.example.springApp.entity.CustomerEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO mapCustomerToCustomerDTO(Customer customer);
    List<CustomerDTO> mapCustomersToCustomersDTO(List<Customer> customer);
    CustomerEntity mapCustomerToCustomerEntity(Customer customer);
    Customer mapCustomerDTOToCustomer(CustomerDTO customerDTO);
    Customer mapCustomerEntityToCustomer(CustomerEntity customerEntity);
    List<Customer> mapCustomerEntitiesToCustomers(List<CustomerEntity> customerEntities);
}
