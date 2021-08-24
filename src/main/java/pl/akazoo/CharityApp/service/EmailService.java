package pl.akazoo.CharityApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import pl.akazoo.CharityApp.domain.dto.ContactMessage;
import pl.akazoo.CharityApp.domain.model.User;

@Component
@RequiredArgsConstructor
public class EmailService {

    @Value("${charity.app.company.email}")
    private String companyMail;
    private final JavaMailSender javaMailSender;

    public void sendContactMessage(ContactMessage contactMessage) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(companyMail);
        message.setTo(companyMail);
        String subject = "Mam pytanie odnośnie apliakcji \"Dobre Ręce\"";
        message.setSubject(subject);
        message.setText(buildContactMessage(contactMessage));
        javaMailSender.send(message);
    }

    private String buildContactMessage(ContactMessage contactMessage){
        return "Pytanie od " + contactMessage.getFirstName() +" :\n"
                + contactMessage.getText() +"\n" +
                "Odpowiedż proszę przesłać na adres :" + contactMessage.getResponseMail();
    }

    private String buildActivationMessage(User user){
        return "Aby aktywować konto wejdź proszę w podany link: \n "
                +"http://localhost:8080/tokens/activation/" + user.getActivationToken() + "\n" +
                "Link ważny jest przez 7 dni od daty rejestracji.\n" +
                "Po tym okresie podczas wejścia na podaną stronę zostanie wygenerowany nowy email." +
                "Dziękujemy za Twoj udział w naszej akcji :)\n Zespół \"Dobre Ręce\"";
    }

    public void sendActivationToken(User user){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(companyMail);
        message.setTo(user.getEmail());
        message.setSubject("Potwierdź swoje konto na \"Dobre Ręce\"");
        message.setText(buildActivationMessage(user));
        javaMailSender.send(message);
    }

    public String buildForgottenPassMessage(User user){
        return "Aby zmienić hasło wejdź proszę w podany link: \n "
                +"http://localhost:8080/tokens/resetPassword/" + user.getResetPasswordToken() + "\n" +
                "Token jest jednorazowy." + "\n" +
                "Dziękujemy za Twoj udział w naszej akcji :)\n Zespół \"Dobre Ręce\"";
    }

    public void sendForgottenPassMessage(User user){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(companyMail);
        message.setTo(user.getEmail());
        message.setSubject("Przypomnienie hasła na portalu \"Dobre Ręce\"");
        message.setText(buildForgottenPassMessage(user));
        javaMailSender.send(message);
    }
}