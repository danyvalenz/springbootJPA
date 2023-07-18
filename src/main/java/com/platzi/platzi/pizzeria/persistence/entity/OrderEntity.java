package com.platzi.platzi.pizzeria.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pizza_order")
@Getter
@Setter
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    private Integer idOrder;

    @Column(name = "id_costumer", length = 15,nullable = false)
    private String idCostumer;

    @Column(nullable = false,columnDefinition = "timestamp")
    private LocalDateTime date;

    @Column(columnDefinition = "Decimal(6,2)",nullable = false)
    private Double total;

    @Column(length = 1)
    private String method;

    @Column(length = 200,name = "additional_notes")
    private String additionalNotes;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_costumer", referencedColumnName = "id_costumer",insertable = false,updatable = false)
    @JsonIgnore
    private CostumerEntity costumer;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderItemEntity> items;
}
