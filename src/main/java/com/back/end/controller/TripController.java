package com.back.end.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.end.model.Trip;
import com.back.end.service.TripService;

@RestController
@RequestMapping("/trip")
public class TripController {
    
    @Autowired
    private TripService tripService;

    @PostMapping("/add")
    public String add(@RequestBody Trip trip){
        tripService.addTrip(trip);
        return "Trip was added successfully";
    }

    @GetMapping("/getAll")
    public List<Trip> getAll(){
        return tripService.getAll();
    }
}
