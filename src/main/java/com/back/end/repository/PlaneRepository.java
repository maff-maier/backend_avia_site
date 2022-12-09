package com.back.end.repository;

import org.springframework.data.repository.CrudRepository;

import com.back.end.entity.PlaneEntity;

public interface PlaneRepository extends CrudRepository<PlaneEntity, Long> {
    PlaneEntity findBySideNumber(String num);
}
