package com.back.end.service;

import java.util.List;

import com.back.end.entity.User;
import com.back.end.exceptions.UserAlreadyExistException;
import com.back.end.exceptions.UserNotExistException;
import com.back.end.model.UserModel;


public interface UserService {
    public User addUser(User user) throws UserAlreadyExistException;

    public UserModel getUserById(int id) throws UserNotExistException;

    public List<User> getAll();

    public Integer delete(int id);
}
