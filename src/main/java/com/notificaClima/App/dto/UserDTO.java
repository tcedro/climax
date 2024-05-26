package com.notificaClima.App.dto;

import org.springframework.beans.BeanUtils;

import com.notificaClima.App.entities.UserEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String name;
    private String login;
    private String password;
    public  UserDTO(UserEntity u) {
        BeanUtils.copyProperties(u, this);
    }
}
