package com.back.end.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.end.entity.Plane;

@Repository
public interface PlaneRepo extends JpaRepository<Plane, Integer> {
    
}
