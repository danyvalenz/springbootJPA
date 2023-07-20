package com.platzi.platzi.pizzeria.service;

import com.platzi.platzi.pizzeria.persistence.entity.Dto.UpdatePizzaPriceDTO;
import com.platzi.platzi.pizzeria.persistence.entity.PizzaEntity;
import com.platzi.platzi.pizzeria.persistence.repository.PizzaPaginSortingRepository;
import com.platzi.platzi.pizzeria.persistence.repository.PizzaRepository;
import com.platzi.platzi.pizzeria.service.exception.EmailApiException;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PizzaService {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final PizzaRepository pizzaRepository;
    private final PizzaPaginSortingRepository pizzaPaginSortingRepository;

    public PizzaService(NamedParameterJdbcTemplate namedParameterJdbcTemplate, PizzaRepository pizzaRepository, PizzaPaginSortingRepository pizzaPaginSortingRepository) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.pizzaRepository = pizzaRepository;
        this.pizzaPaginSortingRepository = pizzaPaginSortingRepository;
    }


    public List<PizzaEntity> getAll(){
        return this.namedParameterJdbcTemplate.query("SELECT * FROM pizza where available = true", new BeanPropertyRowMapper<>(PizzaEntity.class));
    }

    public List<PizzaEntity> getAllbyRepository(){
        return pizzaRepository.findAll();
    }


    public PizzaEntity getbyId(Integer id){
        return pizzaRepository.findById(id).orElse(new PizzaEntity());
    }

    public PizzaEntity guardar(PizzaEntity pizzaEntity){
        return this.pizzaRepository.save(pizzaEntity);
    }

    public boolean existePizza(Integer idPizza){

        return this.pizzaRepository.existsById(idPizza);
    }

    public PizzaEntity updatePizza(PizzaEntity pizzaEntity){

        if(existePizza(pizzaEntity.getIdPizza())){
            return this.pizzaRepository.save(pizzaEntity);
        }else {
            return new PizzaEntity();
        }
    }


    public List<PizzaEntity> availablePizza(){
        return this.pizzaRepository.findAllByAvailableTrueOrderByPriceDesc();
    }

    public List<PizzaEntity> findByName( String name)
    {
        boolean disponible = false;
        return this.pizzaRepository.findAllByAvailableAndNameContainingIgnoreCase(disponible, name);
    }

    public Page<PizzaEntity> pageAndSorting(Integer page, Integer elements)
    {
        Pageable pageRequest = PageRequest.of(page,elements);
        return this.pizzaPaginSortingRepository.findAll(pageRequest);
    }

    public Page<PizzaEntity> pagingAndSortingbyid(Integer page, Integer elements)
    {
        Pageable pageableRequest = PageRequest.of(page,elements);
        return this.pizzaPaginSortingRepository.findAllByOrderByIdPizzaDesc(pageableRequest);
    }


    @Transactional(noRollbackFor = EmailApiException.class)
    public void updatePricePizza(UpdatePizzaPriceDTO dto)
    {
        if(existePizza(dto.getPizzaId()))
        {
            this.pizzaRepository.updatePrice(dto);
            this.enviarEmail();
        }
    }

    public Void enviarEmail()
    {
        throw new EmailApiException();
    }
}
