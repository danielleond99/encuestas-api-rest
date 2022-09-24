package com.encuestasapirest.users.service;

import com.encuestasapirest.users.entity.UserEntity;

import java.util.List;

public interface IUserService {

    List<UserEntity> findAll();
}
