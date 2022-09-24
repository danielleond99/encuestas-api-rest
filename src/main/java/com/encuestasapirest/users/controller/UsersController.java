package com.encuestasapirest.users.controller;

import com.encuestasapirest.users.entity.UserEntity;
import com.encuestasapirest.users.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {

    private final IUserService userService;

    public UsersController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    @GetMapping("test")
    public String test(){
        return "OK";
    }
}
