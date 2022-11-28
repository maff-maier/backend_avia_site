package com.back.end.service;

import java.util.List;

import com.back.end.entity.Orders;
import com.back.end.exceptions.WrongOrderParamException;

public interface OrderService {
    public Orders addOrd(Orders tk, int userId, int routeId) throws WrongOrderParamException;

    public List<Orders> getAll();
    
}
