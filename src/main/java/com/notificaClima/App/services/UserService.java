package com.notificaClima.App.services;

import org.springframework.stereotype.Service;

import com.notificaClima.App.models.User;

@Service
public class UserService {
    public User getNewUser() {
        return new User("Thiago Cedro", "tcedro67@gmail.com", "123");
    }
}
