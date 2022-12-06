package com.back.end.service;

import java.util.List;

import com.back.end.entity.Plane;

public interface PlaneService {

    public Plane addPlane(Plane pl);

    public List<Plane> getAll();
}
