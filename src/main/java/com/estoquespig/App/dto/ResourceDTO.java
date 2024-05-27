package com.estoquespig.App.dto;

import org.springframework.beans.BeanUtils;

import com.estoquespig.App.entities.ResourceEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ResourceDTO {
    private Long id;
    private String name;
    private String key;

    public ResourceDTO (ResourceEntity r) {
        BeanUtils.copyProperties(r, this);
    }
}
