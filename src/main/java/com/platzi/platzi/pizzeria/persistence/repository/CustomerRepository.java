package com.platzi.platzi.pizzeria.persistence.repository;


import com.platzi.platzi.pizzeria.persistence.entity.CostumerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends ListCrudRepository<CostumerEntity,String> {

    @Query(value = "SELECT c FROM CostumerEntity c WHERE c.phoneNumber = :phone")
    CostumerEntity findByPhone(@Param("phone") String phone);
}
