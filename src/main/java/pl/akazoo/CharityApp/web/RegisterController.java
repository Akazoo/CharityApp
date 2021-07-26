package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.CharityApp.domain.converter.Converter;
import pl.akazoo.CharityApp.domain.dto.UserAdd;
import pl.akazoo.CharityApp.domain.model.User;
import pl.akazoo.CharityApp.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {

    private final Converter converter;
    private final UserService userService;

    @GetMapping
    public String registerForm(Model model){
        model.addAttribute("userAdd", new UserAdd());
        return "register";
    }

    @PostMapping
    public String registerConfirm(@Valid UserAdd userAdd, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "register";
        }
        if (userService.exists(userAdd.getEmail())) {
            bindingResult.rejectValue("login", null,"Podany adres email  jest już w użyciu.");
            return "register";
        }
        if (!userAdd.getPassword().equals(userAdd.getPassword2())) {
            bindingResult.rejectValue("password", null,"Hasła nie są takie same.");
            return "register";
        }
        User user = converter.userAddToUser(userAdd);
        userService.add(user);
        return "redirect:/login";
    }
}