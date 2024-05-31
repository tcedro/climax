package com.estoquespig.App.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.estoquespig.App.dto.SuplierDTO;
import com.estoquespig.App.dto.WarningEmailDTO;
import com.estoquespig.App.entities.SuplierEntity;
import com.estoquespig.App.repository.SuplierRepository;

public class SuplierService {
    @Autowired
    EmailService emailService;
    
    @Autowired
    SuplierRepository suplierRepository;

    public String notifierEmailSuplier(WarningEmailDTO warningEmailDTO) {
        return emailService.warningEmailMensage(warningEmailDTO);
    }

    @Transactional(readOnly = true)   
    public SuplierDTO searchById(Long id) {
        SuplierEntity suplierEntity = suplierRepository.findById(id).get();
        return new SuplierDTO(suplierEntity);
    }

    @Transactional(readOnly = true)   
    public List<SuplierDTO>listAll() {
        List<SuplierEntity> suplierEntities = suplierRepository.findAll();
        return suplierEntities.stream().map(SuplierDTO::new).toList();
    }

    public SuplierDTO edit(SuplierDTO suplierDTO) {
        SuplierEntity suplierEntity = new SuplierEntity(suplierDTO);
        return new SuplierDTO(suplierRepository.save(suplierEntity));
    }

    public void delete(Long id) {
        SuplierEntity suplierEntity = suplierRepository.findById(id).get();
        suplierRepository.delete(suplierEntity);
    }

    public void save(SuplierDTO suplierDTO) {
        SuplierEntity suplierEntity = new SuplierEntity(suplierDTO);
        suplierRepository.save(suplierEntity);
    }
    
}
