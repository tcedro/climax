package com.notificaClima.App.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
    public Address() {
    }
    public Address(String cep, String logradouro, String complemento, String bairro, String localidade, String uf,
            String ibge, String gia, String ddd, String siafi) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.ibge = ibge;
        this.gia = gia;
        this.ddd = ddd;
        this.siafi = siafi;
    }
    @Override
    public String toString() {
        return "Address [cep=" + cep + ", logradouro=" + logradouro + ", complemento=" + complemento + ", bairro="
                + bairro + ", localidade=" + localidade + ", uf=" + uf + ", ibge=" + ibge + ", gia=" + gia + ", ddd="
                + ddd + ", siafi=" + siafi + "]";
    }
}
