package com.back.end.model;

import com.back.end.entity.OrdersEntity;

public class Orders {

    private Long id;
    private String timestamp;
    private Boolean baggage;
    private String orderCost;

    private Long us;
    private Long rtId;

    

    public static Orders toOrders(OrdersEntity entity){
        Orders ord = new Orders();

        ord.setId(entity.getId());
        ord.setTimestamp(entity.getTimestamp());
        ord.setBaggage(entity.getBaggage());
        ord.setOrderCost(entity.getOrderCost());
        ord.setUs(entity.getUserId().getId());
        ord.setRtId(entity.getRouteId().getId());

        return ord;
    }

    public Orders() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getBaggage() {
        return baggage;
    }

    public void setBaggage(Boolean baggage) {
        this.baggage = baggage;
    }

    public String getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(String orderCost) {
        this.orderCost = orderCost;
    }

    public Long getUs() {
        return us;
    }

    public void setUs(Long us) {
        this.us = us;
    }

    public Long getRtId() {
        return rtId;
    }

    public void setRtId(Long rtId) {
        this.rtId = rtId;
    }

}
