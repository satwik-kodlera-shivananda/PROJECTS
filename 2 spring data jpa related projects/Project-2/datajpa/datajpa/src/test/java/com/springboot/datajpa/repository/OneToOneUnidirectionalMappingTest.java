package com.springboot.datajpa.repository;

import com.springboot.datajpa.model.Address;
import com.springboot.datajpa.model.Orders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootTest
public class OneToOneUnidirectionalMappingTest {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private AddressRepository addressRepository;


    @Test
    public void saveorderMethod(){

        Orders order = new Orders();
        order.setOrderTrackingNumber("12345");
        order.setTotalQuantity(10);
        order.setStatus("In Process");
        order.setTotalPrice(new BigDecimal(1000));

        Address address = new Address();
        address.setCity("Chennai");
        address.setCountry("India");
        address.setState("Tamil Nadu");
        address.setStreet("Chennai");
        address.setZipCode("600000");

        order.setBillingAddress(address);
        ordersRepository.save(order);
    }

    @Test
    public void updateorderMethod(){

        Orders order = ordersRepository.findById(1L).get();
        order.setStatus("DELIVERED");
        order.getBillingAddress().setCity("SHIMOGA");
        ordersRepository.save(order);
    }


    @Test
    public void deleteorderMethod(){
        ordersRepository.deleteById(1L);
    }

    @Test
    public void getorderMethod(){
        Orders byId = ordersRepository.findById(2L).get();
        System.out.println(byId);
    }
}
