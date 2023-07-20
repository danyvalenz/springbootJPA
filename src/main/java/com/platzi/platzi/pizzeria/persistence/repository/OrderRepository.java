package com.platzi.platzi.pizzeria.persistence.repository;

import com.platzi.platzi.pizzeria.persistence.entity.OrderEntity;
import com.platzi.platzi.pizzeria.persistence.projection.OrderSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends ListCrudRepository<OrderEntity,Integer> {

    List<OrderEntity> findAllByMethodIn(List<String> methods);

    @Query(value = "SELECT po.id_order AS idOrder, cu.name AS costumerName, po.date AS orderDate, " +
            "po.total AS orderTotal, STRING_AGG(PI.name, ', ') AS pizzaNames " +
            "FROM pizza_order po " +
            "INNER JOIN costumer cu ON po.id_costumer = cu.id_costumer " +
            "INNER JOIN order_item oi ON po.id_order = oi.id_order " +
            "INNER JOIN pizza PI ON oi.id_pizza = PI.id_pizza " +
            "WHERE po.id_order = :id_order " +
            "GROUP BY po.id_order, cu.id_costumer, po.date, po.total", nativeQuery = true)
    OrderSummary findSummary(@Param("id_order") Integer idOrder);

}
