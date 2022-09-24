package com.encuestasapirest.users.dao;

import com.encuestasapirest.users.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<UserEntity, Long> {
}
