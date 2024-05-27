package com.estoquespig.App.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estoquespig.App.dto.ResourceDTO;
import com.estoquespig.App.entities.ResourceEntity;
import com.estoquespig.App.repository.ResourceRepository;


@Service
public class ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;

    public List <ResourceDTO> listAll() {
        List<ResourceEntity> resources = resourceRepository.findAll();
        return resources.stream().map(ResourceDTO::new).toList();
    }

    public void insert(ResourceDTO resourceDTO) {
        ResourceEntity resourceEntity = new ResourceEntity(resourceDTO);
        resourceRepository.save(resourceEntity);
    }

    public ResourceDTO edit(ResourceDTO resourceDTO) {
        ResourceEntity resourceEntity = new ResourceEntity(resourceDTO);
        return new ResourceDTO(resourceRepository.save(resourceEntity));
    }

    public void delete(Long id) {
        ResourceEntity resourceEntity = resourceRepository.findById(id).get();
        resourceRepository.delete(resourceEntity);
    }

    public ResourceDTO searchById(Long id) {
        return new ResourceDTO(resourceRepository.findById(id).get());
    }
}
