package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.CharityApp.domain.helpers.Converter;
import pl.akazoo.CharityApp.domain.dto.UserAdd;
import pl.akazoo.CharityApp.domain.model.User;
import pl.akazoo.CharityApp.service.EmailService;
import pl.akazoo.CharityApp.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {

    private final Converter converter;
    private final UserService userService;
    private final EmailService emailService;

    @GetMapping
    public String registerForm(Model model) {
        model.addAttribute("userAdd", new UserAdd());
        return "mainPage/register";
    }

    @PostMapping
    public String registerConfirm(@Valid UserAdd userAdd, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "mainPage/register";
        }
        if (userService.exists(userAdd.getEmail())) {
            bindingResult.rejectValue("email", null, "Podany adres email jest już w użyciu.");
            return "mainPage/register";
        }
        if (!userAdd.getPassword().equals(userAdd.getPassword2())) {
            bindingResult.rejectValue("password", null, "Hasła nie są takie same.");
            return "mainPage/register";
        }
        User user = converter.userAddToUser(userAdd);
        emailService.sendActivationToken(user);
        userService.add(user);
        return "messages/registrationDone";
    }
}