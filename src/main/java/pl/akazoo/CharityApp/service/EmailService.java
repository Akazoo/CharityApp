package pl.akazoo.CharityApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import pl.akazoo.CharityApp.domain.model.ContactMessage;
import pl.akazoo.CharityApp.domain.model.User;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final String companyMail = "akazooproductions@gmail.com";
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

    public String buildContactMessage(ContactMessage contactMessage){
        return "Pytanie od " + contactMessage.getFirstName() +" :\n"
                + contactMessage.getText() +"\n" +
                "Odpowiedż proszę przesłać na adres :" + contactMessage.getResponseMail();
    }

    public String buildActivationMessage(User user){
        return "Aby aktywować konto wejdź proszę w podany link: \n "
                +"http://localhost:8080/activation/" + user.getActivationToken() + "\n" +
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
}