package com.notificaClima.App.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notificaClima.App.dto.UserDTO;
import com.notificaClima.App.entities.UserEntity;
import com.notificaClima.App.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private EmailService emailService;
    
    @Autowired
    private UserRepository userRepository;
    public List<UserDTO> listAll() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(UserDTO::new).toList();
    }
    public void insert(UserDTO user) {
        UserEntity userEntity = new UserEntity(user);
        userRepository.save(userEntity);
    }
    public UserDTO edit(UserDTO user) {
        UserEntity userEntity = new UserEntity(user);
        return new UserDTO(userRepository.save(userEntity));
    }
    public void delete(Long id) {
        UserEntity userEntity = userRepository.getReferenceById(id);
        userRepository.delete(userEntity);
    }
    public UserDTO searchById(Long id) {
        return new UserDTO(userRepository.findById(id).get());
    }
    public String sendText() {
        return emailService.sendText("Nota da Prova", "Sua nota de PO foi 17/20", "maria.kos@sga.pucminas.br");
    }
  
}
