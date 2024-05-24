package com.notificaClima.App.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.notificaClima.App.models.User;
import com.notificaClima.App.services.UserService;
import com.notificaClima.App.utils.EmailRegexValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;
    
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public boolean save(
        @RequestParam(value = "login") String login,
        @RequestParam(value= "pass") String pass, @RequestParam(value= "name") String name) {
            if(EmailRegexValidator.validateEmail(login)) {
                userService.insert(new User(name, login, pass)); 
            
            } else { return false; }
        
        return true;
    }

    @GetMapping(value = "/sendemail")
    public String sendText() {
        return userService.sendText();
        // return "hello word";
    }
    
    @GetMapping(value = "/{id}")
    public User searchById(@PathVariable Long id) {
        return userService.searchById(id);
    }
}
