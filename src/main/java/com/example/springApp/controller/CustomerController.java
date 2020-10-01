package com.example.springApp.controller;

import java.util.List;
import com.example.springApp.service.customer.facade.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springApp.domain.Customer;
import org.springframework.http.HttpStatus;
import javax.validation.constraints.Min;

@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/api/v1/customers";

    @Autowired
    CustomerFacade customerServiceFacade;
    
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerServiceFacade.createCustomer(customer), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Customer>> findAllCustomers() {
        return new ResponseEntity<>(customerServiceFacade.findAllCustomers(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable
                                                     @Min(value = 1, message = "Invalid id!") Long id) {
        return new ResponseEntity<>(customerServiceFacade.findCustomerById(id), HttpStatus.FOUND);
    }
    
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerServiceFacade.updateCustomer(customer), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Customer>> deleteCustomerById(@PathVariable
                                                             @Min(value = 1, message = "Invalid id!") Long id) {
        return new ResponseEntity<>(customerServiceFacade.deleteCustomerById(id), HttpStatus.OK);
    }
    
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Customer>> deleteCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerServiceFacade.deleteCustomer(customer), HttpStatus.OK);
    }
}