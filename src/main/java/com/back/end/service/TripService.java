package com.back.end.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.end.model.Trip;
import com.back.end.repository.TripRepository;

@Service
public class TripService implements ITripService{

    @Autowired
    private TripRepository repository;

    @Override
    public Trip addTrip(Trip trip) {
        return repository.save(trip);
    }

    @Override
    public List<Trip> getAll() {
        return repository.findAll();
    }
    
}
