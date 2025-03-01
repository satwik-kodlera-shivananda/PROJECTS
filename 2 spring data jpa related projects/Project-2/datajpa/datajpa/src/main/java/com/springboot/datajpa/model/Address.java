package com.springboot.datajpa.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "street")
    private String street;
    @Column(name ="city")
    private String city;
    @Column(name ="state")
    private String state;
    @Column(name ="country")
    private String country;
    @Column(name ="zipCode")
    private String zipCode;
}
