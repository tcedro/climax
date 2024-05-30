package com.estoquespig.App.dto;

import org.springframework.beans.BeanUtils;

import com.estoquespig.App.entities.ProductEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String productName;
    private String description;
    private String expirationDate;
    private double salePrice;

    public ProductDTO(ProductEntity p) {
        BeanUtils.copyProperties(p, this);
    }
}
