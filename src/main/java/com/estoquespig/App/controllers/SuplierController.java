package com.estoquespig.App.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estoquespig.App.dto.SuplierDTO;
import com.estoquespig.App.dto.WarningEmailDTO;
import com.estoquespig.App.services.SuplierService;

@RestController
@CrossOrigin
@RequestMapping("/suplier")
public class SuplierController {
    @Autowired SuplierService suplierService;
    
    @GetMapping("/{id}")
    public SuplierDTO findById(@PathVariable Long id) {   
        return suplierService.searchById(id);
    }

    @GetMapping("/notify:{id}")
    public String notify(@PathVariable Long id, @RequestBody WarningEmailDTO warningEmailDTO) {
       return suplierService.notifierEmailSuplier(id, warningEmailDTO);
    }

    @GetMapping
    public List<SuplierDTO> listAll() {
        return suplierService.listAll();
    }

    @PostMapping
    public void insert(@RequestBody SuplierDTO suplierDTO){
        suplierService.save(suplierDTO);
    }

    @PutMapping
    public SuplierDTO edit(@RequestBody SuplierDTO suplierDTO) {
        return suplierService.edit(suplierDTO);
    }
}
