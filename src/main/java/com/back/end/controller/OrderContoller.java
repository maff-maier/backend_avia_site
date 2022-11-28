package com.back.end.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.back.end.entity.Orders;
import com.back.end.exceptions.WrongOrderParamException;
import com.back.end.service.OrderServiceImpl;


@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderContoller {
    
    @Autowired
    private OrderServiceImpl orderService;


    @PostMapping
    public ResponseEntity<String> add(@RequestBody Orders order, @RequestParam int userId, @RequestParam int routeId){

        try {
            orderService.addOrd(order, userId, routeId);
            return ResponseEntity.ok("oreder was added successfully");
        } catch (WrongOrderParamException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getAll")
    public List<Orders> getAll(){
        return orderService.getAll();
    }
}
