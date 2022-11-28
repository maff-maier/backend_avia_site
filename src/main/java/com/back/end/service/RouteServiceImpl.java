package com.back.end.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.end.entity.Route;
import com.back.end.exceptions.RouteAlreadyExistException;
import com.back.end.repository.RouteRepository;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository repository;

    @Override
    public Route addRoute(Route route) throws RouteAlreadyExistException {
        if (repository.findByArrival(route.getArrival()) != null
                && repository.findByDeparture(route.getDeparture()) != null
                && repository.findByDeparture(route.getTimestamp()) != null) {

            throw new RouteAlreadyExistException("Route already exists");
        }

        return repository.save(route);
    }

    @Override
    public List<Route> getAll() {
        return repository.findAll();
    }

}
