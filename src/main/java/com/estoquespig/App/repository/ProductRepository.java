package com.estoquespig.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estoquespig.App.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{ 
}
