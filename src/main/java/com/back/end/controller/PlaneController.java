package com.back.end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.end.entity.PlaneEntity;
import com.back.end.service.PlaneService;

@RestController
@RequestMapping("/planes")
public class PlaneController {
    
    @Autowired
    private PlaneService service;

    @PostMapping
    public ResponseEntity<?> addNew(@RequestBody PlaneEntity plane){
        try {
            return ResponseEntity.ok(service.addPlane(plane));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Problem: " + e.getMessage());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.ok(service.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getCause());
        }
    }
}
