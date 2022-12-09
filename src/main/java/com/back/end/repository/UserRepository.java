package com.back.end.repository;

import org.springframework.data.repository.CrudRepository;

import com.back.end.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long>{
    UserEntity findByNumber(String number);
}
