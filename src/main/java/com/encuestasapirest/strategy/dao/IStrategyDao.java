package com.encuestasapirest.strategy.dao;

import com.encuestasapirest.strategy.entity.StrategyEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface IStrategyDao extends CrudRepository<StrategyEntity, Long> {

    StrategyEntity findByType(String type);

    @Modifying
    @Query("update StrategyEntity s set s.type = ?1, s.description = ?2 where s.id = ?3")
    @Transactional
    void update(String type, String description, Long id);
}
