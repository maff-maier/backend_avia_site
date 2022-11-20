package com.back.end.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.end.model.User;
import com.back.end.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    public User addUser(User user) {

        return repository.save(user);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }
    
}
