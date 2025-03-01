package com.springboot.datajpa.repository;

import com.springboot.datajpa.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    Orders findByOrderTrackingNumber(String orderTrackingNumber);

}
