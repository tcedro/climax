package com.estoquespig.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estoquespig.App.entities.ResourceEntity;
@Deprecated
public interface ResourceRepository extends JpaRepository<ResourceEntity, Long> {
}
