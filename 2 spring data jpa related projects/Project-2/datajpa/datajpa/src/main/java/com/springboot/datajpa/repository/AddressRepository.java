package com.springboot.datajpa.repository;

import com.springboot.datajpa.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
