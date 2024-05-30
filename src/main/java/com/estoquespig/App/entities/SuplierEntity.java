package com.estoquespig.App.entities;

import org.springframework.beans.BeanUtils;

import com.estoquespig.App.dto.SuplierDTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameSuplier;
    private String cellphone;
    private String cpfCnpj;
    private String email;

    public SuplierEntity(SuplierDTO suplierDTO) {
        BeanUtils.copyProperties(suplierDTO, this);
    }
}
