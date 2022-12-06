package com.back.end.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int routeId;

    @ManyToOne
    private Plane planeId;

    private String departure;
    private String arrival;
    private String timestamp;
    private String routeCost;
    private String qtyCount;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private List<Orders> ordersCount = new ArrayList<Orders>();

    public Route() {
    }
    
    public Plane getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Plane plane) {
        this.planeId = plane;
    }

    public String getRouteCost() {
        return routeCost;
    }

    public void setRouteCost(String routeCost) {
        this.routeCost = routeCost;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
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

    public String getQtyCount() {
        return qtyCount;
    }

    public void setQtyCount(String qtyCount) {
        this.qtyCount = qtyCount;
    }

    public List<Orders> getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(List<Orders> ordersCount) {
        this.ordersCount = ordersCount;
    }

}
