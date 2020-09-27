package com.example.springApp.bootstrapdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.springApp.model.Customer;
import com.example.springApp.repository.CustomerRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading data...");

        Customer c1 = Customer.builder().firstName("Angus").lastName("Young").build();
        Customer c2 = Customer.builder().firstName("Malcolm").lastName("Young").build();
        Customer c3 = Customer.builder().firstName("Cliff").lastName("Williams").build();
        Customer c4 = Customer.builder().firstName("Phil").lastName("Rudd").build();
        Customer c5 = Customer.builder().firstName("Brian").lastName("Johnson").build();

        customerRepository.save(c1);
        customerRepository.save(c2);
        customerRepository.save(c3);
        customerRepository.save(c4);
        customerRepository.save(c5);

        System.out.println("Number of customers: " + customerRepository.count());
    }
}
