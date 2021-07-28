package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.CharityApp.domain.model.ContactMessage;
import pl.akazoo.CharityApp.service.EmailService;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/contact")
public class EmailController {

    private final EmailService emailService;

    @PostMapping
    public String sendMail(@Valid ContactMessage contactMessage, BindingResult bindingResult, @RequestHeader ("Referer") String referer){
        if(bindingResult.hasErrors()){
            return "cowczesnie #contact";
        }
        emailService.sendMessage("akazoo@interia.pl", contactMessage.getFirstName(), contactMessage.getText() + contactMessage.getResponseMail());
        return "redirect:/contact";
    }

    @GetMapping
    public String confirmed(){
        return "sent";
    }
}