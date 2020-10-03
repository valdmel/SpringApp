package com.example.springApp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_CUSTOMERS_BIRTHPLACE")
public class BirthplaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;
    private String city;
}