package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String sendMail(@Valid ContactMessage contactMessage, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/contact/error";
        }
        emailService.sendContactMessage(contactMessage);
        return "redirect:/contact";
    }

    @GetMapping
    public String confirmed(){
        return "messages/sent";
    }

    @GetMapping("/error")
    public String error(){
        return "messages/error";
    }
}