package com.back.end.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="routes")
public class RouteEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String departure;
    private String arrival;
    private String timestamp;
    private String routeCost;
    private String qtyCount;

    @ManyToOne
    @JoinColumn(name="plane_id")
    //@JsonIgnore
    private PlaneEntity planeId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    
    private List<OrdersEntity> orders;

    public RouteEntity() {
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

    public PlaneEntity getPlaneId() {
        return planeId;
    }

    public void setPlaneId(PlaneEntity planeId) {
        this.planeId = planeId;
    }

    public List<OrdersEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdersEntity> orders) {
        this.orders = orders;
    }
}
