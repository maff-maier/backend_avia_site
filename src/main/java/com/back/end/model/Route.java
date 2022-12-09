package com.back.end.model;

import java.util.List;
import java.util.stream.Collectors;

import com.back.end.entity.RouteEntity;

public class Route {

    private Long id;
    private String departure;
    private String arrival;
    private String timestamp;
    private String routeCost;
    private String qtyCount;

    private Plane planeId;
    private List<Orders> orders;

    public static Route toRoute(RouteEntity entity){
        Route route = new Route();

        route.setId(entity.getId());
        route.setArrival(entity.getArrival());
        route.setDeparture(entity.getDeparture());
        route.setTimestamp(entity.getTimestamp());
        route.setRouteCost(entity.getRouteCost());
        route.setQtyCount(entity.getQtyCount());

        route.setPlaneId(Plane.toPlane(entity.getPlaneId()));

        
        route.setOrders(entity.getOrders() != null 
        ? entity.getOrders().stream().map(Orders::toOrders).collect(Collectors.toList())
        : null);

        return route;
    }

    public Route() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getRouteCost() {
        return routeCost;
    }

    public void setRouteCost(String routeCost) {
        this.routeCost = routeCost;
    }

    public String getQtyCount() {
        return qtyCount;
    }

    public void setQtyCount(String qtyCount) {
        this.qtyCount = qtyCount;
    }

    public Plane getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Plane planeId) {
        this.planeId = planeId;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

}
