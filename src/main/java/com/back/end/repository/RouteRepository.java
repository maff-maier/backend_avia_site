package com.back.end.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.back.end.entity.RouteEntity;

public interface RouteRepository extends CrudRepository<RouteEntity, Long>{
    RouteEntity findByDeparture(String departure);

    RouteEntity findByArrival(String arrival);

    RouteEntity findByTimestamp(String timestamp);

    List<RouteEntity> findAllByArrival(String arrival);
}
