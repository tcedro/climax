package com.estoquespig.App.entities;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;

import com.estoquespig.App.dto.SuplierDTO;

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
@Table(name = "TB_SUPLIER")
public class SuplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameSuplier;
    @Column(nullable = false)
    private String cellphone;
    @Column(unique = true)
    private String cpfCnpj;
    @Column(unique = true)
    private String email;

    public SuplierEntity(SuplierDTO suplierDTO) {
        BeanUtils.copyProperties(suplierDTO, this);
    }
}
