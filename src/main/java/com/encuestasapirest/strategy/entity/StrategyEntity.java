package com.encuestasapirest.strategy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "estrategias")
public class StrategyEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Column(name = "tipo",unique = true, nullable = false)
    @NotEmpty
    @Size(min = 1, max = 255)
    private String type;

    @Getter
    @Setter
    @Column(name = "descripcion",nullable = false)
    @NotEmpty
    @Size(min = 1, max = 255)
    private String description;

}
