package com.estoquespig.App.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estoquespig.App.dto.ProductDTO;
import com.estoquespig.App.services.ProductService;

@RestController
@RequestMapping(name = "/product")
@CrossOrigin
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<ProductDTO> listAll() {
        return productService.listAll();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ProductDTO findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PutMapping
    public ProductDTO edit(@RequestBody ProductDTO productDTO) {
        return productService.edit(productDTO);
    } 
}
