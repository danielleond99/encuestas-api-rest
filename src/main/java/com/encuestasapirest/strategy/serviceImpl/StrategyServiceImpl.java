package com.encuestasapirest.strategy.serviceImpl;

import com.encuestasapirest.strategy.dao.IStrategyDao;
import com.encuestasapirest.strategy.entity.StrategyEntity;
import com.encuestasapirest.strategy.service.IStrategyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrategyServiceImpl implements IStrategyService {

    private final IStrategyDao strategyDao;

    public StrategyServiceImpl(IStrategyDao strategyDao) {
        this.strategyDao = strategyDao;
    }

    @Override
    public List<StrategyEntity> findAll() {
        return (List<StrategyEntity>) strategyDao.findAll();
    }

    @Override
    public StrategyEntity findById(Long id) {
        return strategyDao.findById(id).orElse(null);
    }

}
