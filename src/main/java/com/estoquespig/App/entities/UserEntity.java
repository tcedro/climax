package com.estoquespig.App.entities;

import org.springframework.beans.BeanUtils;

import com.estoquespig.App.dto.UserDTO;
import com.estoquespig.App.utils.EncoderPassword;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name="TB_USER")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, unique = true)
    private String login;
    
    @Column(nullable = false)
    private String password;
    
    public UserEntity() {
    }
    public UserEntity(String name, String login, String pass) {
        this.name = name;
        this.login = login;
        this.password = EncoderPassword.toMD5(pass);
    }
    public UserEntity(UserDTO u) {
        BeanUtils.copyProperties(u, this);
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", login=" + login + ", pass=" + password + "]";
    }
}

