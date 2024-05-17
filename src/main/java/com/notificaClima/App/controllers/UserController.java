package com.notificaClima.App.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.notificaClima.App.models.User;
import com.notificaClima.App.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;
    
    @GetMapping
    public User showUser() {
        return userService.getNewUser();
    }
}
