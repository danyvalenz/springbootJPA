package com.platzi.platzi.pizzeria.web.controller;


import com.platzi.platzi.pizzeria.persistence.entity.Dto.UpdatePizzaPriceDTO;
import com.platzi.platzi.pizzeria.persistence.entity.PizzaEntity;
import com.platzi.platzi.pizzeria.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PizzaController {

    private final PizzaService pizzaService;


    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<PizzaEntity>> getAll(){

        return ResponseEntity.ok(this.pizzaService.getAll());
    }

    @GetMapping("/allRepository")

    public ResponseEntity<List<PizzaEntity>> getAllByRepository(){

        return ResponseEntity.ok(this.pizzaService.getAllbyRepository());
    }

    @GetMapping("/pizzaid/{idPizza}")
    public ResponseEntity<PizzaEntity> getPizzabyId(@PathVariable("idPizza") Integer idPizza){

        return ResponseEntity.ok(this.pizzaService.getbyId(idPizza));
    }

    @PostMapping("/guardar")
    public ResponseEntity<PizzaEntity> guardarPizza(@RequestBody PizzaEntity pizzaEntity){

        return ResponseEntity.ok(this.pizzaService.guardar(pizzaEntity));
    }

    @PutMapping("/actualizar")
    public ResponseEntity actualizar(@RequestBody PizzaEntity pizzaEntity){

        return ResponseEntity.ok(this.pizzaService.updatePizza(pizzaEntity));
    }

    @GetMapping("/findAllby")
    public ResponseEntity<List<PizzaEntity>> findAllBy()
    {
        return ResponseEntity.ok(this.pizzaService.availablePizza());
    }

    @GetMapping("/findbyName/{name}")
    public ResponseEntity<List<PizzaEntity>> findByName(@PathVariable("name") String name)
    {
        return ResponseEntity.ok(this.pizzaService.findByName(name));
    }

    @GetMapping("/paging")
    public ResponseEntity<Page<PizzaEntity>> paginandsorting(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer elements)
    {
        return ResponseEntity.ok(this.pizzaService.pageAndSorting(page,elements));
    }

    @GetMapping("/paginandsortingOrderBy")
    public ResponseEntity<Page<PizzaEntity>> paginandsortingOrderBy(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer elements)
    {
        return ResponseEntity.ok(this.pizzaService.pageAndSorting(page,elements));
    }

    @PutMapping("/price")
    public ResponseEntity updatePricePizza(@RequestBody UpdatePizzaPriceDTO dto)
    {
        this.pizzaService.updatePricePizza(dto);
        return ResponseEntity.ok().build();
    }
}
