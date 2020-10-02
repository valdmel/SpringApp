package com.example.springApp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_CUSTOMERS")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
}