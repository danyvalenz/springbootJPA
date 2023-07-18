package com.platzi.platzi.pizzeria.persistence.repository;

import com.platzi.platzi.pizzeria.persistence.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends ListCrudRepository<OrderEntity,Integer> {

    List<OrderEntity> findAllByMethodIn(List<String> methods);
}
