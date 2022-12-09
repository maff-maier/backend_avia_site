package com.back.end.repository;


import org.springframework.data.repository.CrudRepository;

import com.back.end.entity.OrdersEntity;

public interface OrdersRepository extends CrudRepository<OrdersEntity, Long>{
}
