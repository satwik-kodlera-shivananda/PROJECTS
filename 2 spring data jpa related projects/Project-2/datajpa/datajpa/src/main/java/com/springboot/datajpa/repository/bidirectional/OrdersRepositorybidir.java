package com.springboot.datajpa.repository.bidirectional;

import com.springboot.datajpa.model.bidirectionalmapping.Ordersbidir;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepositorybidir extends JpaRepository<Ordersbidir, Long> {
    Ordersbidir findByOrderTrackingNumber(String orderTrackingNumber);

}
