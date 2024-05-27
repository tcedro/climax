package com.estoquespig.App.dto;

import org.springframework.beans.BeanUtils;

import com.estoquespig.App.entities.ProfileEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDTO {
    private Long id;
    private String description;
    public ProfileDTO (ProfileEntity p) {
        BeanUtils.copyProperties(p, this);
    }
}
