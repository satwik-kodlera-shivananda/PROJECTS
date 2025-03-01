package com.springboot.datajpa.repository;

import com.springboot.datajpa.model.Address;
import com.springboot.datajpa.model.OrderItem;
import com.springboot.datajpa.model.Orders;
import com.springboot.datajpa.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class OneToManyUnidirectional {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ProductRepository productRepository;


    @Test
    public void saveorderMethod(){

        Orders order = new Orders();
        order.setOrderTrackingNumber("12345");
        order.setTotalQuantity(10);
        order.setStatus("In Process");
        order.setTotalPrice(new BigDecimal(3998700));

        Address address = new Address();
        address.setCity("Chennai");
        address.setCountry("India");
        address.setState("Tamil Nadu");
        address.setStreet("Chennai");
        address.setZipCode("600000");

        order.setBillingAddress(address);

        Product p1=new Product();
        p1.setName("Laptop1");
        p1.setPrize(1000);

        Product p2=new Product();
        p2.setName("Laptop2");
        p2.setPrize(1000);

        Product p3=new Product();
        p3.setName("Laptop3");
        p3.setPrize(1000);


        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(p1);
        orderItem.setImageUrl("laptop.jpg");
        orderItem.setQuantity(1);
        orderItem.setPrice(BigDecimal.valueOf(2000));
        order.getOrderItems().add(orderItem);


        OrderItem orderItem2 = new OrderItem();
        orderItem2.setProduct(p2);
        orderItem2.setImageUrl("tv.jpg");
        orderItem2.setQuantity(3);
        orderItem2.setPrice(new BigDecimal(3000));
        order.getOrderItems().add(orderItem2);



        OrderItem orderItem3 = new OrderItem();
        orderItem3.setProduct(p3);
        orderItem3.setImageUrl("laptop.jpg");
        orderItem3.setPrice(new BigDecimal(3000));
        orderItem3.setQuantity(2);
        order.getOrderItems().add(orderItem3);


        ordersRepository.save(order);
    }



    @Test
    public void getorderMethod(){
        Orders byId = ordersRepository.findById(2L).get();
        System.out.println(byId);
    }

    @Test
    public void deleteorderMethod(){
        ordersRepository.deleteById(2L);
    }











}
