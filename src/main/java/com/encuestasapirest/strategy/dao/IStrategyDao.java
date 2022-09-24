package com.encuestasapirest.strategy.dao;

import com.encuestasapirest.strategy.entity.StrategyEntity;
import org.springframework.data.repository.CrudRepository;

public interface IStrategyDao extends CrudRepository<StrategyEntity, Long> {
}
