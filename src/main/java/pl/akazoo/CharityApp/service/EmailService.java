package pl.akazoo.CharityApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import pl.akazoo.CharityApp.domain.helpers.Helpers;
import pl.akazoo.CharityApp.domain.dto.ContactMessage;
import pl.akazoo.CharityApp.domain.model.User;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmailService {

    @Value("${charity.app.company.email}")
    private String companyMail;
    private final JavaMailSender javaMailSender;
    private final Helpers helpers;

    public void sendContactMessage(ContactMessage contactMessage) {
        SimpleMailMessage message = new SimpleMailMessage();
        List<String> mailContent = helpers.getMailContent("contactMail");
        message.setFrom(companyMail);
        message.setTo(companyMail);
        String subject = mailContent.get(0);
        message.setSubject(subject);
        String readyContactMessage = buildContactMessage(contactMessage, mailContent);
        message.setText(readyContactMessage);
        javaMailSender.send(message);
        sendConfirmationContact(contactMessage.getResponseMail(), mailContent.get(3), readyContactMessage);
    }

    private void sendConfirmationContact(String sendTo, String subject, String mailText) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(companyMail);
        message.setTo(sendTo);
        message.setSubject(subject);
        message.setText(mailText);
        javaMailSender.send(message);
    }

    private String buildContactMessage(ContactMessage contactMessage, List<String> mailContent) {
        return mailContent.get(1) + " " + contactMessage.getFirstName() + " :\n"
                + contactMessage.getText() + "\n"
                + mailContent.get(2) + " " + contactMessage.getResponseMail();
    }

    private String buildActivationMessage(User user, List<String> mailContent) {
        return mailContent.get(1) + "\n\n"
                + "http://localhost:8080/tokens/activation/" + user.getActivationToken() + "\n\n" +
                mailContent.get(2) + "\n" +
                mailContent.get(3) + "\n" +
                mailContent.get(4) + "\n" +
                mailContent.get(5);
    }

    public void sendActivationToken(User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        List<String> mailContent = helpers.getMailContent("activationMessage");
        message.setFrom(companyMail);
        message.setTo(user.getEmail());
        message.setSubject(mailContent.get(0));
        message.setText(buildActivationMessage(user,mailContent));
        javaMailSender.send(message);
    }

    public String buildForgottenPassMessage(User user, List<String> mailContent) {
        return mailContent.get(1) + "\n\n"
                + "http://localhost:8080/tokens/resetPassword/" + user.getResetPasswordToken() + "\n\n" +
                mailContent.get(2) + "\n" +
                mailContent.get(3) + "\n" + mailContent.get(4);
    }

    public void sendForgottenPassMessage(User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        List<String> mailContent = helpers.getMailContent("forgottenPassword");
        message.setFrom(companyMail);
        message.setTo(user.getEmail());
        message.setSubject(mailContent.get(0));
        message.setText(buildForgottenPassMessage(user, mailContent));
        javaMailSender.send(message);
    }
}