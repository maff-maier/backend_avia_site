package com.back.end.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.end.entity.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {
    Route findByDeparture(String departure);

    Route findByArrival(String arrival);

    Route findByTimestamp(String timestamp);
}
