package com.notificaClima.App.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notificaClima.App.models.User;

@Service
public class UserService {
    @Autowired
    private EmailService emailService;
    public String insert(User user) {
        return "falta fazer.";
    }
    public String delete(User user) {
        return "falta fazer.";
    }
    public String sendText() {
        return emailService.sendText("Nota da Prova", "Sua nota de PO foi 17/20", "maria.kos@sga.pucminas.br");
    }
    public User searchById(Long id) {
        return null;
    }
}
