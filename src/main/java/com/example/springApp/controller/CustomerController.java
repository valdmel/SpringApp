package com.example.springApp.controller;

import java.util.List;
import com.example.springApp.dto.CustomerDTO;
import com.example.springApp.service.customer.facade.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@Validated
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/api/v1/customers";

    @Autowired
    CustomerFacade customerFacade;
    
    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        return new ResponseEntity<>(customerFacade.createCustomer(customerDTO), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAllCustomers() {
        return new ResponseEntity<>(customerFacade.findAllCustomers(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findCustomerById(@PathVariable
                                                     @Min(value = 1, message = "Invalid id!") Long id) {
        return new ResponseEntity<>(customerFacade.findCustomerById(id), HttpStatus.FOUND);
    }
    
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        return new ResponseEntity<>(customerFacade.updateCustomer(customerDTO), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CustomerDTO>> deleteCustomerById(@PathVariable
                                                             @Min(value = 1, message = "Invalid id!") Long id) {
        return new ResponseEntity<>(customerFacade.deleteCustomerById(id), HttpStatus.OK);
    }
    
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CustomerDTO>> deleteCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        return new ResponseEntity<>(customerFacade.deleteCustomer(customerDTO), HttpStatus.OK);
    }
}