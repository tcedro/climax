package com.estoquespig.App.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estoquespig.App.dto.ProductDTO;
import com.estoquespig.App.entities.ProductEntity;
import com.estoquespig.App.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<ProductDTO> listAll() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return productEntities.stream().map(ProductDTO::new).toList();
    }

    public void insert(ProductDTO p) {
        productRepository.save(new ProductEntity(p));
    }

    public ProductDTO edit(ProductDTO p) {
        ProductEntity productEntity = new ProductEntity(p);
        return new ProductDTO(productRepository.save(productEntity));
    }

    public void delete(Long id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        productRepository.delete(productEntity);
    }

    public ProductDTO findById(Long id) {
        return new ProductDTO(productRepository.findById(id).get());
    }
}
