package com.example.springApp.controller;

import java.util.List;
import com.example.springApp.dto.CustomerDTO;
import com.example.springApp.service.customer.facade.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.springApp.domain.Customer;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@Validated
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/api/v1/customers";

    @Autowired
    CustomerFacade customerServiceFacade;
    
    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        return new ResponseEntity<>(customerServiceFacade.createCustomer(customerDTO), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAllCustomers() {
        return new ResponseEntity<>(customerServiceFacade.findAllCustomers(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findCustomerById(@PathVariable
                                                     @Min(value = 1, message = "Invalid id!") Long id) {
        return new ResponseEntity<>(customerServiceFacade.findCustomerById(id), HttpStatus.FOUND);
    }
    
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        return new ResponseEntity<>(customerServiceFacade.updateCustomer(customerDTO), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CustomerDTO>> deleteCustomerById(@PathVariable
                                                             @Min(value = 1, message = "Invalid id!") Long id) {
        return new ResponseEntity<>(customerServiceFacade.deleteCustomerById(id), HttpStatus.OK);
    }
    
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CustomerDTO>> deleteCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        return new ResponseEntity<>(customerServiceFacade.deleteCustomer(customerDTO), HttpStatus.OK);
    }
}