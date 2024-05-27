package com.estoquespig.App.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estoquespig.App.dto.UserDTO;
import com.estoquespig.App.entities.UserEntity;
import com.estoquespig.App.repository.UserRepository;

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
        String text = "Parabens " + user.getName() + ", você acabou de se registrar em nosso site.";
        emailService.sendText("New Account", text, user.getLogin());
        userRepository.save(userEntity);
    }
    public UserDTO edit(UserDTO user) {
        UserEntity userEntity = new UserEntity(user);
        String text = user.getName() + ", você acabou de editar seu perfil no nosso site.";
        emailService.sendText("Edit Account", text, user.getLogin());
        return new UserDTO(userRepository.save(userEntity));
    }
    public void delete(Long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        String text = userEntity.getName() + ", seu perfil foi deletado em nosso site.";
        emailService.sendText("New Account", text, userEntity.getLogin());
        userRepository.delete(userEntity);
    }
    public UserDTO searchById(Long id) {
        return new UserDTO(userRepository.findById(id).get());
    }
}
