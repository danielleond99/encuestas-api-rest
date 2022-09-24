package com.encuestasapirest.users.serviceImpl;

import com.encuestasapirest.users.dao.IUserDao;
import com.encuestasapirest.users.entity.UserEntity;
import com.encuestasapirest.users.service.IUserService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserDao userDao;

    public UserServiceImpl(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<UserEntity> findAll() {
        return (List<UserEntity>) userDao.findAll();
    }

}
