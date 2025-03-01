package com.springboot.datajpa.model.bidirectionalmapping;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "address")
@Data

public class Addressbidir {
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @ToString.Exclude
    private Ordersbidir order;
}
