package com.encuestasapirest.strategy.controller;

import com.encuestasapirest.strategy.entity.StrategyEntity;
import com.encuestasapirest.strategy.service.IStrategyService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("strategies")
public class StrategiesController {

    private final IStrategyService strategyService;

    public StrategiesController(IStrategyService strategyService) {
        this.strategyService = strategyService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return strategyService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return strategyService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody StrategyEntity strategy, BindingResult validationResult){
        return strategyService.save(strategy, validationResult);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody StrategyEntity strategy, BindingResult validationResult){
        return strategyService.update(id, strategy, validationResult);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return strategyService.delete(id);
    }
}
