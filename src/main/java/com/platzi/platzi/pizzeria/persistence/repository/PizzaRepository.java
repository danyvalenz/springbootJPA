package com.platzi.platzi.pizzeria.persistence.repository;

import com.platzi.platzi.pizzeria.persistence.entity.Dto.UpdatePizzaPriceDTO;
import com.platzi.platzi.pizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity,Integer> {

    List<PizzaEntity> findAllByAvailableTrueOrderByPriceDesc();

    List<PizzaEntity> findAllByAvailableAndNameContainingIgnoreCase(boolean disponible,String name);

    @Query(value = " UPDATE pizza " +
            " SET price = :#{#newPricePizza.newPrice} " +
            " WHERE id_pizza = :#{#newPricePizza.pizzaId} ", nativeQuery = true)
    @Modifying
    void updatePrice(@Param("newPricePizza") UpdatePizzaPriceDTO updatePizzaPriceDTO);
}
