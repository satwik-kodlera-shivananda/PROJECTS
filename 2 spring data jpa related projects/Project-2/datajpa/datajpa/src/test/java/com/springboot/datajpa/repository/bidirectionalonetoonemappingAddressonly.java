package com.springboot.datajpa.repository;

import com.springboot.datajpa.model.bidirectionalmapping.Addressbidir;
import com.springboot.datajpa.model.bidirectionalmapping.Ordersbidir;
import com.springboot.datajpa.repository.bidirectional.AddressRepositorybidir;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class bidirectionalonetoonemappingAddressonly {

    @Autowired
    private AddressRepositorybidir addressRepository;

    @Test
    public void saveAddressMethod(){
        Addressbidir addressbidir = new Addressbidir();
        addressbidir.setCity("SHIMOGA");
        addressbidir.setCountry("India");
        addressbidir.setState("KARNATAKA");
        addressbidir.setStreet("KEERTHINAGARA");
        addressbidir.setZipCode("600000");

        Ordersbidir ordersbidir = new Ordersbidir();
        ordersbidir.setOrderTrackingNumber("12345");
        ordersbidir.setTotalQuantity(10);
        ordersbidir.setStatus("In Process");
        ordersbidir.setTotalPrice(new BigDecimal(1000));
        ordersbidir.setBillingAddressbidir(addressbidir);
        addressbidir.setOrder(ordersbidir);

        addressRepository.save(addressbidir);

    }

    @Test
    public void updateAddressMethod(){
        Addressbidir addressbidir = addressRepository.findById(1L).get();
        addressbidir.setStreet("VINOBHA NAGARA");
        addressbidir.getOrder().setStatus("DELIVERED TO NEW ADDRESS");
        addressRepository.save(addressbidir);
    }

    @Test
    public void deleteAddressMethod(){
      addressRepository.deleteById(1L);
    }


    @Test
    public void getAddressMethod(){
        Addressbidir byId = addressRepository.findById(2L).get();
        System.out.println(byId);
    }
}
