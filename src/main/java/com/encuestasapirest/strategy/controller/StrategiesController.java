package com.encuestasapirest.strategy.controller;

import com.encuestasapirest.strategy.entity.StrategyEntity;
import com.encuestasapirest.strategy.service.IStrategyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{id}")
    public StrategyEntity findById(@PathVariable Long id){
        return strategyService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StrategyEntity save(@RequestBody StrategyEntity strategy){
        return strategyService.save(strategy);
    }

    @PutMapping("{id}")
    public StrategyEntity update(@PathVariable Long id, @RequestBody StrategyEntity strategy){
        return strategyService.update(id, strategy);
    }

    @DeleteMapping("{id}")
    public StrategyEntity delete(@PathVariable Long id){
        return strategyService.delete(id);
    }
}
