package pl.akazoo.CharityApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

public void sendMessage(String to, String subject, String text){
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("akazooproductions@gmail.com");
    message.setTo(to);
    message.setSubject(subject);
    message.setText(text);
    javaMailSender.send(message);
}
}