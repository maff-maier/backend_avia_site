package com.back.end.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.end.model.Ticket;
import com.back.end.service.TicketService;


@RestController
@RequestMapping("/ticket")
public class TicketContoller {
    
    @Autowired
    private TicketService ticketService;

    @PostMapping("/add")
    public String add(@RequestBody Ticket tk){
        ticketService.addTick(tk);
        return "Ticket was added successsfully";
    }

    @GetMapping("/getAll")
    public List<Ticket> getAll(){
        return ticketService.getAll();
    }
}
