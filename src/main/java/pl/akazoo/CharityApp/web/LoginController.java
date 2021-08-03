package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.CharityApp.domain.dto.PasswordReminder;
import pl.akazoo.CharityApp.service.UserService;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @GetMapping
    public String loginForm() {
        return "login";
    }

    @GetMapping("/forgotten")
    public String forgottenPassword(Model model) {
        model.addAttribute("passwordReminder", new PasswordReminder());
        return "resetPassword";
    }

    @PostMapping("/forgotten")
    public String forgottenPasswordCheck(@Valid PasswordReminder passwordReminder, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "resetPassword";
        }
        if(!userService.exists(passwordReminder.getEmail())){
            bindingResult.rejectValue("email",null,"Użytkownik o podanym mailu nie istnieje.");
            return "resetPassword";
        }
        return "";
    }
}