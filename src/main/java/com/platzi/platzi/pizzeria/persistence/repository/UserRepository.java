package com.platzi.platzi.pizzeria.persistence.repository;

import com.platzi.platzi.pizzeria.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,String> {

}
