package com.example.springApp.bootstrapdata;

import com.example.springApp.domain.Birthplace;
import com.example.springApp.domain.Customer;
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

        Customer c1 = Mappers.getMapper(CustomerMapper.class).mapCustomerDTOToCustomer(
                CustomerDTO.builder().firstName("Angus").lastName("Young").age(65).gender("Male").nationality("Scottish Australian").birthplace(
                        new Birthplace("Scotland", "Glasgow")).build());
        Customer c2 = Mappers.getMapper(CustomerMapper.class).mapCustomerDTOToCustomer(
                CustomerDTO.builder().firstName("Malcolm").lastName("Young").age(64).gender("Male").nationality("Scottish Australian").birthplace(
                        new Birthplace("Scotland", "Glasgow")).build());
        Customer c3 = Mappers.getMapper(CustomerMapper.class).mapCustomerDTOToCustomer(
                CustomerDTO.builder().firstName("Cliff").lastName("Williams").age(70).gender("Male").nationality("British").birthplace(
                        new Birthplace("England", "Romford")).build());
        Customer c4 = Mappers.getMapper(CustomerMapper.class).mapCustomerDTOToCustomer(
                CustomerDTO.builder().firstName("Phil").lastName("Rudd").age(66).gender("Male").nationality("Australian").birthplace(
                        new Birthplace("Australia", "Melbourne")).build());
        Customer c5 = Mappers.getMapper(CustomerMapper.class).mapCustomerDTOToCustomer(
                CustomerDTO.builder().firstName("Brian").lastName("Johnson").age(72).gender("Male").nationality("British").birthplace(
                        new Birthplace("England", "Duston")).build());

        customerRepository.save(Mappers.getMapper(CustomerMapper.class).mapCustomerToCustomerEntity(c1));
        customerRepository.save(Mappers.getMapper(CustomerMapper.class).mapCustomerToCustomerEntity(c2));
        customerRepository.save(Mappers.getMapper(CustomerMapper.class).mapCustomerToCustomerEntity(c3));
        customerRepository.save(Mappers.getMapper(CustomerMapper.class).mapCustomerToCustomerEntity(c4));
        customerRepository.save(Mappers.getMapper(CustomerMapper.class).mapCustomerToCustomerEntity(c5));

        System.out.println("Number of customers: " + customerRepository.count());
    }
}
