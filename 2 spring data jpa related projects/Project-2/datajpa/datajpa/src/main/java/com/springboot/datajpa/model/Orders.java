package com.springboot.datajpa.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="oders")
@Data
public class Orders {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@Column(name="order_tracking_number")
private String orderTrackingNumber;

@Column(name="total_quantity")
private int totalQuantity;

@Column(name="total_price")
private BigDecimal totalPrice;

@Column(name="status")
private String status;

@Column(name="date_created")
@CreationTimestamp
private LocalDateTime dateCreated;

@Column(name="last_updated")
@UpdateTimestamp
private LocalDateTime lastUpdated;


@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="billing_address_id", referencedColumnName = "id")
private Address billingAddress;;
}
