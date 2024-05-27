package com.estoquespig.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estoquespig.App.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
}