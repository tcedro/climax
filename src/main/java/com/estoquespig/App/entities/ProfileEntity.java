package com.estoquespig.App.entities;

import org.springframework.beans.BeanUtils;

import com.estoquespig.App.dto.ProfileDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "TB_PROFILE")
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;

    public ProfileEntity(ProfileDTO p) {
        BeanUtils.copyProperties(p, this);
    }
}
