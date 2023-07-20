package com.platzi.platzi.pizzeria.service;

import com.platzi.platzi.pizzeria.persistence.entity.CostumerEntity;
import com.platzi.platzi.pizzeria.persistence.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CostumerService {

    private final CustomerRepository customerRepository;

    public CostumerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public CostumerEntity obtenerCustomer(String phone)
    {
        return this.customerRepository.findByPhone(phone);
    }
}
