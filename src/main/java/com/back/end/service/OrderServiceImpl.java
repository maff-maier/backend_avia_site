package com.back.end.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.end.entity.Orders;
import com.back.end.entity.Route;
import com.back.end.entity.User;
import com.back.end.exceptions.WrongOrderParamException;
import com.back.end.repository.OrderRepository;
import com.back.end.repository.RouteRepository;
import com.back.end.repository.UserRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository oRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RouteRepository routeRepo;

    @Override
    public Orders addOrd(Orders order, int userId, int routeId) throws WrongOrderParamException {
        User user = userRepo.findById(userId).get();
        Route route = routeRepo.findById(routeId).get();

        if(user == null || route == null){
            throw new WrongOrderParamException("There is no user or route");
        }
        
        order.setUserId(user);
        order.setRoute(route);
        
        return oRepo.save(order);
    }

    @Override
    public List<Orders> getAll() {
        return oRepo.findAll();
    }
    
}
