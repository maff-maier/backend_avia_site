package com.back.end.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.end.entity.OrdersEntity;
import com.back.end.entity.RouteEntity;
import com.back.end.entity.UserEntity;
import com.back.end.model.Orders;
import com.back.end.repository.OrdersRepository;
import com.back.end.repository.RouteRepository;
import com.back.end.repository.UserRepository;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository repo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RouteRepository routeRepo;

    public Orders addOrder(OrdersEntity order, Long userId, Long routeId) {
        UserEntity user = userRepo.findById(userId).get();
        RouteEntity route = routeRepo.findById(routeId).get();

        if (user == null || route == null) {
            return null;
        }

        order.setUserId(user);
        order.setRouteId(route);
        return Orders.toOrders(repo.save(order));
    }

    public List<Orders> findAll() {
        Iterable<OrdersEntity> fa = repo.findAll();

        List<OrdersEntity> stream = StreamSupport.stream(fa.spliterator(), false)
        .map(ord -> {
            OrdersEntity n = new OrdersEntity();
            BeanUtils.copyProperties(ord, n);
            return n;
        }).collect(Collectors.toList());

        return stream.stream().map(Orders::toOrders).toList();
    }

    public Long delete(Long id){
        repo.deleteById(id);
        return id;
    }

}
