package com.back.end.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.end.entity.Plane;
import com.back.end.repository.PlaneRepo;

@Service
public class PlaneServiceImpl implements PlaneService {
    
    @Autowired
    private PlaneRepo repo;

    @Override
    public Plane addPlane(Plane pl) {
        return repo.save(pl);
    }

    @Override
    public List<Plane> getAll() {
        return repo.findAll();
    }

    
}
