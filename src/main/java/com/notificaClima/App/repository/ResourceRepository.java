package com.notificaClima.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notificaClima.App.entities.ResourceEntity;

public interface ResourceRepository extends JpaRepository<ResourceEntity, Long> {
}
