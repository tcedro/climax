package com.estoquespig.App.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estoquespig.App.dto.ResourceDTO;
import com.estoquespig.App.services.ResourceService;

@RestController
@RequestMapping(value = "/resource")
@CrossOrigin
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @GetMapping
    public List<ResourceDTO> listAll() {
        return resourceService.listAll();
    }

    @PostMapping
    public void insert(@RequestBody ResourceDTO resourceDTO) {
        resourceService.insert(resourceDTO);
    }

    @PutMapping
    public ResourceDTO edit(@RequestBody ResourceDTO resourceDTO) {
        return resourceService.edit(resourceDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        resourceService.delete(id);
        return ResponseEntity.ok().build();
    }
}
