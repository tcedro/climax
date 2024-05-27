package com.estoquespig.App.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String from;

    public String sendText(String topic, String text, String to) {
        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            
            simpleMailMessage.setFrom(from);
            simpleMailMessage.setTo(to);
            simpleMailMessage.setSubject(topic);
            simpleMailMessage.setText(text);
            
            javaMailSender.send(simpleMailMessage);
            
            return "Email send with success!";

        } catch(Exception e) { return "Error: Email not send w/ success."; }
    }
}