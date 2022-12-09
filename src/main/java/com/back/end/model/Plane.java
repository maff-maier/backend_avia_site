package com.back.end.model;

import java.util.List;
import java.util.stream.Collectors;

import com.back.end.entity.PlaneEntity;

public class Plane {
    
    private Long id;
    private String model;
    private String sideNumber;

    private List<Long> routes;

    public static Plane toPlane(PlaneEntity plane){
        Plane model = new Plane();

        model.setId(plane.getId());
        model.setModel(plane.getModel());
        model.setSideNumber(plane.getSideNumber());
        model.setRoutes(
            plane.getRoutes()
                .stream()
                .map(one -> {
                    return one.getId();
                })
                .collect(Collectors.toList()));

        return model;
    }

    public Plane() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSideNumber() {
        return sideNumber;
    }

    public void setSideNumber(String sideNumber) {
        this.sideNumber = sideNumber;
    }

    public List<Long> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Long> routes) {
        this.routes = routes;
    }

    
}
