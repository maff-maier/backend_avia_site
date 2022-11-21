package com.back.end.service;

import java.util.List;

import com.back.end.model.Ticket;

public interface ITicketService {
    public Ticket addTick(Ticket tk);

    public List<Ticket> getAll();
    
}
