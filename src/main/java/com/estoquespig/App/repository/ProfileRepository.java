package com.estoquespig.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estoquespig.App.entities.ProfileEntity;

public interface ProfileRepository extends JpaRepository <ProfileEntity, Long>{
}
