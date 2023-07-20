package com.platzi.platzi.pizzeria.persistence.entity.Dto;

import lombok.Data;

@Data
public class UpdatePizzaPriceDTO {
    private Integer pizzaId;
    private Double newPrice;
}
