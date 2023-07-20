package com.platzi.platzi.pizzeria.web.controller;

import com.platzi.platzi.pizzeria.persistence.entity.CostumerEntity;
import com.platzi.platzi.pizzeria.service.CostumerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CostumerService costumerService;

    public CustomerController(CostumerService costumerService) {
        this.costumerService = costumerService;
    }


    @GetMapping("/phone/{phone}")
    public ResponseEntity<CostumerEntity> getCostumer(@PathVariable("phone") String phone)
    {
        return ResponseEntity.ok(this.costumerService.obtenerCustomer(phone));
    }
}
