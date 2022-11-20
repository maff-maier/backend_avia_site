package com.back.end.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.end.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
}
