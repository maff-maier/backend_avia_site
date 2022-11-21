package com.back.end.service;

import java.util.List;

import com.back.end.model.Trip;

public interface ITripService {
    public Trip addTrip(Trip trip);
    
    public List<Trip> getAll();
}
