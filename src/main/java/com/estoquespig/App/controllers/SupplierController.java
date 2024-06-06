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

import com.estoquespig.App.dto.SupplierDTO;
import com.estoquespig.App.dto.WarningEmailDTO;
import com.estoquespig.App.services.SupplierService;

@RestController
@CrossOrigin
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired SupplierService suplierService;
    
    @GetMapping("/{id}")
    public SupplierDTO findById(@PathVariable Long id) {   
        return suplierService.searchById(id);
    }

    @GetMapping("/notify:{id}")
    public String notify(@RequestBody WarningEmailDTO warningEmailDTO) {
       return suplierService.notifierEmailSuplier(warningEmailDTO);
    }

    @GetMapping
    public List<SupplierDTO> listAll() {
        return suplierService.listAll();
    }

    @PostMapping
    public void insert(@RequestBody SupplierDTO suplierDTO){
        suplierService.save(suplierDTO);
    }

    @PutMapping
    public SupplierDTO edit(@RequestBody SupplierDTO suplierDTO) {
        return suplierService.edit(suplierDTO);
    }
}
