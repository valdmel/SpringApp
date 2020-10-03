package com.example.springApp.entity;

import com.example.springApp.domain.Birthplace;
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
    private Integer age;
    private String gender;
    private String nationality;

    @OneToOne(cascade = CascadeType.ALL)
    private BirthplaceEntity birthplace;
}