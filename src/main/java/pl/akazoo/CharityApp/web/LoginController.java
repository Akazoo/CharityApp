package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.CharityApp.domain.dto.PasswordReminder;
import pl.akazoo.CharityApp.domain.model.User;
import pl.akazoo.CharityApp.security.TokenService;
import pl.akazoo.CharityApp.service.EmailService;
import pl.akazoo.CharityApp.service.UserService;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;
    private final TokenService tokenService;
    private final EmailService emailService;

    @GetMapping
    public String loginForm() {
        return "login";
    }

    @GetMapping("/forgotten")
    public String forgottenPassword(Model model) {
        model.addAttribute("passwordReminder", new PasswordReminder());
        return "resetPassword/resetPassword";
    }

    @PostMapping("/forgotten")
    public String forgottenPasswordCheck(@Valid PasswordReminder passwordReminder, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "resetPassword/resetPassword";
        }
        if(!userService.exists(passwordReminder.getEmail())){
            bindingResult.rejectValue("email",null,"Użytkownik o podanym mailu nie istnieje.");
            return "resetPassword/resetPassword";
        }
        User user = userService.getUserByEmail(passwordReminder.getEmail());
        user.setResetPasswordToken(tokenService.getToken());
        emailService.sendForgottenPassMessage(user);
        userService.add(user);
        return "messages/forgottenPassMessage";
    }
}