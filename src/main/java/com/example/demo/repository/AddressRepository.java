package com.example.demo.repository;

import com.example.demo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByCity(String city);
}
