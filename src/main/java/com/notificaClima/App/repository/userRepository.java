package com.notificaClima.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notificaClima.App.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
}