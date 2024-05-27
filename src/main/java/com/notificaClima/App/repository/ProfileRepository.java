package com.notificaClima.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notificaClima.App.entities.ProfileEntity;

public interface ProfileRepository extends JpaRepository <ProfileEntity, Long>{
}
