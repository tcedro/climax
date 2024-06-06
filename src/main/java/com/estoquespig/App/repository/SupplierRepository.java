package com.estoquespig.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estoquespig.App.entities.SupplierEntity;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long>{
}
