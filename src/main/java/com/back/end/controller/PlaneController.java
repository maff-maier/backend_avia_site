package com.back.end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.end.entity.Plane;
import com.back.end.service.PlaneService;

@RestController
@RequestMapping("/plane")
@CrossOrigin
public class PlaneController {

    @Autowired
    private PlaneService planeService;

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Plane plane){
        try {
            planeService.addPlane(plane);
            return ResponseEntity.ok("200");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
