package com.estoquespig.App.dto;

import org.springframework.beans.BeanUtils;

import com.estoquespig.App.entities.UserEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String name;
    private String login;
    private String password;
    public UserDTO() {
    }
    public  UserDTO(UserEntity u) {
        BeanUtils.copyProperties(u, this);
    }
}
