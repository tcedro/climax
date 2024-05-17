package com.notificaClima.App.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.notificaClima.App.models.Address;
import com.notificaClima.App.services.ViaCepApiService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class CepApiController {
    @Autowired
    ViaCepApiService viaCepApiService;
    @GetMapping("/cep")
    public Address getAddress() {
        return viaCepApiService.searchCep("30535-555");
    }
}
