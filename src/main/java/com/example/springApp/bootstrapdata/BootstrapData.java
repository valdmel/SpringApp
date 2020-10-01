package com.example.springApp.bootstrapdata;

import com.example.springApp.dto.CustomerDTO;
import com.example.springApp.mapper.CustomerMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.springApp.repository.CustomerRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading data...");

        CustomerDTO c1 = CustomerDTO.builder().firstName("Angus").lastName("Young").build();
        CustomerDTO c2 = CustomerDTO.builder().firstName("Malcolm").lastName("Young").build();
        CustomerDTO c3 = CustomerDTO.builder().firstName("Cliff").lastName("Williams").build();
        CustomerDTO c4 = CustomerDTO.builder().firstName("Phil").lastName("Rudd").build();
        CustomerDTO c5 = CustomerDTO.builder().firstName("Brian").lastName("Johnson").build();

        customerRepository.save(Mappers.getMapper(CustomerMapper.class).toCustomerEntity(c1));
        customerRepository.save(Mappers.getMapper(CustomerMapper.class).toCustomerEntity(c2));
        customerRepository.save(Mappers.getMapper(CustomerMapper.class).toCustomerEntity(c3));
        customerRepository.save(Mappers.getMapper(CustomerMapper.class).toCustomerEntity(c4));
        customerRepository.save(Mappers.getMapper(CustomerMapper.class).toCustomerEntity(c5));

        System.out.println("Number of customers: " + customerRepository.count());
    }
}
