package com.back.end.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.end.model.Ticket;
import com.back.end.repository.TicketRepository;

@Service
public class TicketService implements ITicketService {

    @Autowired
    private TicketRepository tRepository;

    @Override
    public Ticket addTick(Ticket tk) {
        return tRepository.save(tk);
    }

    @Override
    public List<Ticket> getAll() {
        return tRepository.findAll();
    }
    
}
