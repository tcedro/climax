package com.estoquespig.App.dto;

import org.springframework.beans.BeanUtils;

import com.estoquespig.App.entities.SuplierEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SuplierDTO {
    private int id;
    private String nameSuplier;
    private String cellphone;
    private String cpfCnpj;
    private String email;

    public SuplierDTO(SuplierEntity suplierEntity) {
        BeanUtils.copyProperties(suplierEntity, this);
    }
}
