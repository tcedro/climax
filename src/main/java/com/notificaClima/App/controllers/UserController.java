package com.notificaClima.App.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.notificaClima.App.dto.UserDTO;
import com.notificaClima.App.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public void insert(@RequestBody UserDTO userDTO) {
        userService.insert(userDTO);
    }

    @GetMapping("/{id}")
    public UserDTO searchById(@PathVariable Long id) {
        return userService.searchById(id);
    }
    
    @GetMapping
    public java.util.List <UserDTO> listAll() {
        return userService.listAll();
    }

    @PutMapping
    public UserDTO edit(UserDTO userDTO) {
        return userService.edit(userDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }




    // @GetMapping(value = "/sendemail")
    // public String sendText() {
    //     return userService.sendText();
    //     // return "hello word";
    // }
    
}
