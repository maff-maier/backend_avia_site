package com.back.end.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.end.entity.Route;
import com.back.end.service.RouteServiceImpl;

@RestController
@RequestMapping("/route")
@CrossOrigin
public class RouteController {
    
    @Autowired
    private RouteServiceImpl routeService;

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Route route){
        try {
            routeService.addRoute(route);
            return ResponseEntity.ok("route was added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        
    }

    @GetMapping
    public List<Route> getAll(){
        return routeService.getAll();
    }
}
