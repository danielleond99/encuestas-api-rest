package com.encuestasapirest.strategy.controller;

import com.encuestasapirest.strategy.entity.StrategyEntity;
import com.encuestasapirest.strategy.service.IStrategyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("strategies")
public class StrategiesController {

    private final IStrategyService strategyService;

    public StrategiesController(IStrategyService strategyService) {
        this.strategyService = strategyService;
    }

    @GetMapping
    public List<StrategyEntity> findAll(){
        return strategyService.findAll();
    }
}
