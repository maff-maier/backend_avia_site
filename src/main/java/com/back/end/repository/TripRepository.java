package com.back.end.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.end.model.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {
    
}
