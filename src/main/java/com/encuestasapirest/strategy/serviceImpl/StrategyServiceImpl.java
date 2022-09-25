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

    @Override
    public StrategyEntity save(StrategyEntity strategy) {
        return strategyDao.save(strategy);
    }

    @Override
    public StrategyEntity update(Long id, StrategyEntity strategy) {

        StrategyEntity existsStrategy = strategyDao.findById(id).orElse(null);

        if(existsStrategy != null)
            existsStrategy = strategy;

        assert existsStrategy != null;
        return strategyDao.save(existsStrategy);
    }

    @Override
    public StrategyEntity delete(Long id) {

        StrategyEntity existsStrategy = strategyDao.findById(id).orElse(null);

        if(existsStrategy != null)
            strategyDao.delete(existsStrategy);

        return existsStrategy;
    }

}
