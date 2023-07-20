package com.platzi.platzi.pizzeria.web.controller;

import com.platzi.platzi.pizzeria.persistence.entity.Dto.Method;
import com.platzi.platzi.pizzeria.persistence.entity.OrderEntity;
import com.platzi.platzi.pizzeria.persistence.projection.OrderSummary;
import com.platzi.platzi.pizzeria.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
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

    @GetMapping("/summary/{idOrder}")
    public ResponseEntity<OrderSummary> findSummary(@PathVariable("idOrder") Integer idOrder)
    {
        return ResponseEntity.ok(this.orderService.findSummary(idOrder));
    }
}
