package com.back.end.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.end.entity.UserEntity;
import com.back.end.model.User;
import com.back.end.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    
    public User sign(UserEntity user) throws Exception{
        if(repo.findByNumber(user.getNumber()) != null){
            throw new Exception("Some error");
        } 
        return User.toModel(repo.save(user));
    }

    public User getOneUser(Long id) throws Exception{

        UserEntity user = repo.findById(id).get();

        if(user == null){
            throw new Exception("No user with this ID");
        }

        return User.toModel(user);
    }

    public List<User> getAll(){
        Iterable<UserEntity> pa = repo.findAll();

        List<UserEntity> stream = StreamSupport.stream(pa.spliterator(), false)
                                                .map(plane -> {
                                                    UserEntity pl = new UserEntity();
                                                    BeanUtils.copyProperties(plane, pl);
                                                    return pl;
                                                }).collect(Collectors.toList());
        return stream.stream().map(User::toModel).collect(Collectors.toList());
    }

}
