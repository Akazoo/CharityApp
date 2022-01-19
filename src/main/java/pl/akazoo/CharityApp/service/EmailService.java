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
        message.setFrom(companyMail);
        message.setTo(companyMail);
        String subject = "Mam pytanie odnośnie aplikacji \"Dobre Ręce\"";
        message.setSubject(subject);
        message.setText(buildContactMessage(contactMessage));
        javaMailSender.send(message);
        sendConfirmationContact(contactMessage);
    }

    private void sendConfirmationContact(ContactMessage contactMessage) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(companyMail);
        message.setTo(contactMessage.getResponseMail());
        String subject = "Twoje zapytanie odnośnie aplikacji \"Dobre Ręce\"";
        message.setSubject(subject);
        message.setText(buildContactMessage(contactMessage));
        javaMailSender.send(message);
    }

    private String buildContactMessage(ContactMessage contactMessage) {
        return "Pytanie od " + contactMessage.getFirstName() + " :\n"
                + contactMessage.getText() + "\n" +
                "Odpowiedż proszę przesłać na adres :" + contactMessage.getResponseMail();
    }

    private String buildActivationMessage(User user) {
        return "Aby aktywować konto wejdź proszę w podany link: \n\n"
                + "http://localhost:8080/tokens/activation/" + user.getActivationToken() + "\n\n" +
                "Link ważny jest przez 7 dni od daty rejestracji.\n" +
                "Po tym okresie podczas wejścia na podaną stronę zostanie wygenerowany nowy email.\n" +
                "Dziękujemy za Twoj udział w naszej akcji :)\nZespół \"Dobre Ręce\"";
    }

    public void sendActivationToken(User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(companyMail);
        message.setTo(user.getEmail());
        message.setSubject("Potwierdź swoje konto na portalu \"Dobre Ręce\"");
        message.setText(buildActivationMessage(user));
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