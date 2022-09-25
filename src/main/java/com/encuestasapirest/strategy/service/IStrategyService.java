package com.encuestasapirest.strategy.service;

import com.encuestasapirest.strategy.entity.StrategyEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface IStrategyService {

    ResponseEntity<?> findAll();

    ResponseEntity<?> findById(Long id);

    ResponseEntity<?> save(StrategyEntity strategy, BindingResult validationResult);

    ResponseEntity<?> update(Long id, StrategyEntity strategy, BindingResult validationResult);

    ResponseEntity<?> delete(Long id);
}
