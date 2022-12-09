package com.back.end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.back.end.entity.UserEntity;
import com.back.end.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<?> signUp(@RequestBody UserEntity user){
        try{
            return ResponseEntity.ok(service.sign(user));
        } catch(Exception e){
            return ResponseEntity.badRequest().body("Problem: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getOneUser(@RequestParam Long id){
        try{
            return ResponseEntity.ok(service.getOneUser(id));
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.ok(service.getAll());
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
