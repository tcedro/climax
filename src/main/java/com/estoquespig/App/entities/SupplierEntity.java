package com.estoquespig.App.entities;

import org.springframework.beans.BeanUtils;

import com.estoquespig.App.dto.SupplierDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_SUPPLIER")
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameSupplier;
    
    @Column(nullable = false)
    private String cellphone;
    
    @Column(unique = true)
    private String cpfCnpj;
    
    @Column(unique = true)
    private String email;

    public SupplierEntity(SupplierDTO suplierDTO) {
        BeanUtils.copyProperties(suplierDTO, this);
    }
}
