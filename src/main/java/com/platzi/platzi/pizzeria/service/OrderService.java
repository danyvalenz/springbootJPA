package com.platzi.platzi.pizzeria.service;

import com.platzi.platzi.pizzeria.persistence.entity.OrderEntity;
import com.platzi.platzi.pizzeria.persistence.projection.OrderSummary;
import com.platzi.platzi.pizzeria.persistence.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> getAll(){

        return orderRepository.findAll();
    }


    public List<OrderEntity> findByMethod(List<String> methods)
    {
        return this.orderRepository.findAllByMethodIn(methods);
    }

    public OrderSummary findSummary(Integer idOrder)
    {
        return this.orderRepository.findSummary(idOrder);
    }
}
