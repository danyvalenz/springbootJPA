package com.platzi.platzi.pizzeria.web.controller;

import com.platzi.platzi.pizzeria.persistence.entity.Dto.Method;
import com.platzi.platzi.pizzeria.persistence.entity.OrderEntity;
import com.platzi.platzi.pizzeria.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/allOrdenes")
    public ResponseEntity<List<OrderEntity>> getAll(){

        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("/methods")
    public ResponseEntity<List<OrderEntity>> getAllMethods(@RequestBody List<String> method)
    {
        return ResponseEntity.ok(this.orderService.findByMethod(method));
    }
}
