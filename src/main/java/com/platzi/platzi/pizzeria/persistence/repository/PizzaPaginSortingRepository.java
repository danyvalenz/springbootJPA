package com.platzi.platzi.pizzeria.persistence.repository;

import com.platzi.platzi.pizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaPaginSortingRepository extends ListPagingAndSortingRepository<PizzaEntity,Integer> {

    Page<PizzaEntity> findAllByOrderByIdPizzaDesc(Pageable pages);
}
