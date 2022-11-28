package com.back.end.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.end.entity.User;
import com.back.end.exceptions.UserAlreadyExistException;
import com.back.end.exceptions.UserNotExistException;
import com.back.end.model.UserModel;
import com.back.end.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    public User addUser(User user) throws UserAlreadyExistException {
        if(repository.findByNumber(user.getNumber()) != null){

            throw new UserAlreadyExistException("User with this number already exists.");
        }
        
        return repository.save(user);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }


    @Override
    public UserModel getUserById(int id) throws UserNotExistException {
        User user = repository.findById(id).get();  

        if(user == null) {
            throw new UserNotExistException("User does not exist");
        }

        return UserModel.toModel(user);
            
    }

    @Override
    public Integer delete(int id) {
        repository.deleteById(id);
        return id;
    }
    
}
