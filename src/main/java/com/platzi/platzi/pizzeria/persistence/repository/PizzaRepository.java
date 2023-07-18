package com.platzi.platzi.pizzeria.persistence.repository;

import com.platzi.platzi.pizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity,Integer> {

    List<PizzaEntity> findAllByAvailableTrueOrderByPriceDesc();

    List<PizzaEntity> findAllByAvailableAndNameContainingIgnoreCase(boolean disponible,String name);
}
