package com.notificaClima.App.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.notificaClima.App.entities.AddressEntity;
import com.notificaClima.App.services.ViaCepApiService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CepApiController {
    @Autowired
    ViaCepApiService viaCepApiService;
    
    @GetMapping("/cep/{cepNumber}")
    public AddressEntity getAddress(@PathVariable String cepNumber) {
        return viaCepApiService.searchAddressWithCep(cepNumber);
    }
}
