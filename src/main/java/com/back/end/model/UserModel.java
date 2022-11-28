package com.back.end.model;

import com.back.end.entity.User;

public class UserModel {

    private int id;
    private String number;

    public static UserModel toModel(User user) {
        UserModel model = new UserModel();
        
        model.setId(user.getUserId());
        model.setNumber(user.getPass());
        
        return model;
    }

    public UserModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
