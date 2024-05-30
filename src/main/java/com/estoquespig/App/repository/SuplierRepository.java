package com.estoquespig.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estoquespig.App.entities.SuplierEntity;

public interface SuplierRepository extends JpaRepository<SuplierEntity, Long>{
}
