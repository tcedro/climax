package com.estoquespig.App.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.estoquespig.App.dto.SupplierDTO;
import com.estoquespig.App.dto.WarningEmailDTO;
import com.estoquespig.App.entities.SupplierEntity;
import com.estoquespig.App.repository.SupplierRepository;

public class SupplierService {
    @Autowired
    EmailService emailService;
    
    @Autowired
    SupplierRepository suplierRepository;

    public String notifierEmailSuplier(WarningEmailDTO warningEmailDTO) {
        return emailService.warningEmailMensage(warningEmailDTO);
    }

    @Transactional(readOnly = true)   
    public SupplierDTO searchById(Long id) {
        SupplierEntity suplierEntity = suplierRepository.findById(id).get();
        return new SupplierDTO(suplierEntity);
    }

    @Transactional(readOnly = true)   
    public List<SupplierDTO>listAll() {
        List<SupplierEntity> suplierEntities = suplierRepository.findAll();
        return suplierEntities.stream().map(SupplierDTO::new).toList();
    }

    public SupplierDTO edit(SupplierDTO suplierDTO) {
        SupplierEntity suplierEntity = new SupplierEntity(suplierDTO);
        return new SupplierDTO(suplierRepository.save(suplierEntity));
    }

    public void delete(Long id) {
        SupplierEntity suplierEntity = suplierRepository.findById(id).get();
        suplierRepository.delete(suplierEntity);
    }

    public void save(SupplierDTO suplierDTO) {
        SupplierEntity suplierEntity = new SupplierEntity(suplierDTO);
        suplierRepository.save(suplierEntity);
    }
    
}
