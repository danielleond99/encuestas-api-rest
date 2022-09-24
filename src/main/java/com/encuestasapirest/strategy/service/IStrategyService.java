package com.encuestasapirest.strategy.service;

import com.encuestasapirest.strategy.entity.StrategyEntity;

import java.util.List;

public interface IStrategyService {

    List<StrategyEntity> findAll();

    StrategyEntity findById(Long id);
}
