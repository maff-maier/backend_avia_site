package com.back.end.service;

import java.util.List;

import com.back.end.entity.Route;
import com.back.end.exceptions.RouteAlreadyExistException;

public interface RouteService {
    public Route addRoute(Route trip) throws RouteAlreadyExistException;
    
    public List<Route> getAll();
}
