package com.back.end.service;

import java.util.List;

import com.back.end.model.User;


public interface UserService {
    public User addUser(User user);

    public List<User> getAll();
}
