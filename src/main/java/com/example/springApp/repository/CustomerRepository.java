package com.example.springApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springApp.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}