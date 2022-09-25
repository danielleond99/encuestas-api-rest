package com.encuestasapirest.strategy.service;

import com.encuestasapirest.strategy.entity.StrategyEntity;

import java.util.List;

public interface IStrategyService {

    List<StrategyEntity> findAll();

    StrategyEntity findById(Long id);

    StrategyEntity save(StrategyEntity strategy);

    StrategyEntity update(Long id, StrategyEntity strategy);

    StrategyEntity delete(Long id);
}
