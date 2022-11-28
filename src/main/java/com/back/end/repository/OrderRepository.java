package com.back.end.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.end.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
    
}
