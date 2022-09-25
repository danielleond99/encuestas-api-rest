package com.encuestasapirest.strategy.serviceImpl;

import com.encuestasapirest.app.utils.Utils;
import com.encuestasapirest.strategy.dao.IStrategyDao;
import com.encuestasapirest.strategy.entity.StrategyEntity;
import com.encuestasapirest.strategy.service.IStrategyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class StrategyServiceImpl implements IStrategyService {

    private final IStrategyDao strategyDao;

    public StrategyServiceImpl(IStrategyDao strategyDao) {
        this.strategyDao = strategyDao;
    }

    @Override
    public ResponseEntity<?> findAll() {

        try {
            return new ResponseEntity<>(
                    (List<StrategyEntity>) strategyDao.findAll(),
                    HttpStatus.OK);
        }catch (Exception e){
            return Utils.returnInternalError(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> findById(Long id) {

        StrategyEntity strategy;

        try {

            strategy = strategyDao.findById(id).orElse(null);

            if(strategy == null)
                return new ResponseEntity<>(
                        "Strategy with ID: ".concat(id.toString().concat(" does not exist")),
                        HttpStatus.NOT_FOUND);

            return new ResponseEntity<>(strategy, HttpStatus.OK);
        }catch (Exception e){
            return Utils.returnInternalError(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> save(StrategyEntity strategy, BindingResult validationResult) {

        try {

            Map<String, Object> response = new HashMap<>();

            if(validationResult.hasErrors()){
                List<String> errors = validationResult.getFieldErrors()
                        .stream()
                        .map(err -> "The field " + err.getField() + " " + err.getDefaultMessage())
                        .collect(Collectors.toList());
                response.put("errors", errors);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

            StrategyEntity existsStrategy = strategyDao.findByType(strategy.getType());

            if(existsStrategy != null)
                return new ResponseEntity<>(
                        "Strategy with type: '".concat(strategy.getType().concat("' already exists")),
                        HttpStatus.BAD_REQUEST
                );

            return new ResponseEntity<>(
                    strategyDao.save(strategy),
                    HttpStatus.CREATED);

        }catch (Exception e){
            return Utils.returnInternalError(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> update(Long id, StrategyEntity strategy, BindingResult validationResult) {

        try {

            Map<String, Object> response = new HashMap<>();

            if(validationResult.hasErrors()){
                List<String> errors = validationResult.getFieldErrors()
                        .stream()
                        .map(err -> "The field " + err.getField() + " " + err.getDefaultMessage())
                        .collect(Collectors.toList());
                response.put("errors", errors);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

            StrategyEntity existsStrategy = strategyDao.findById(id).orElse(null);

            if(existsStrategy == null)
                return new ResponseEntity<>(
                        "Strategy with ID: ".concat(id.toString().concat(" does not exist")),
                        HttpStatus.BAD_REQUEST
                );

            existsStrategy = strategyDao.findByType(strategy.getType());

            if(existsStrategy != null && !Objects.equals(existsStrategy.getId(), id))
                return new ResponseEntity<>(
                        "Strategy with type: '".concat(strategy.getType().concat("' already exists")),
                        HttpStatus.BAD_REQUEST
                );

            strategyDao.update(strategy.getType(),strategy.getDescription(),id);
            strategy.setId(id);

            return new ResponseEntity<>(
                    strategy,
                    HttpStatus.OK);

        }catch (Exception e){
            return Utils.returnInternalError(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> delete(Long id) {

        try {

            StrategyEntity existsStrategy = strategyDao.findById(id).orElse(null);

            if(existsStrategy == null)
                return new ResponseEntity<>(
                        "Strategy with ID: ".concat(id.toString().concat(" does not exist")),
                        HttpStatus.NOT_FOUND
                );

            strategyDao.delete(existsStrategy);

            return new ResponseEntity<>(
                    existsStrategy,
                    HttpStatus.OK);

        }catch (Exception e){
            return Utils.returnInternalError(e.getMessage());
        }
    }

}
