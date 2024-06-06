package com.estoquespig.App.dto;

import org.springframework.beans.BeanUtils;

import com.estoquespig.App.entities.SupplierEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SupplierDTO {
    private int id;
    private String nameSuplier;
    private String cellphone;
    private String cpfCnpj;
    private String email;

    public SupplierDTO(SupplierEntity suplierEntity) {
        BeanUtils.copyProperties(suplierEntity, this);
    }
}
