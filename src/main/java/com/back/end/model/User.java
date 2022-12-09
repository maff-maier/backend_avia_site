package com.back.end.model;

import java.util.List;
import java.util.stream.Collectors;

import com.back.end.entity.UserEntity;

public class User {

    private Long id;
    private String number;
    private List<Orders> orders;


    public User() {
    }

    public static User toModel(UserEntity user){
        User model = new User();

        model.setId(user.getId());
        model.setNumber(user.getNumber());
        model.setOrders(user.getOrders().stream().map(Orders::toOrders).collect(Collectors.toList()));
        
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

}
