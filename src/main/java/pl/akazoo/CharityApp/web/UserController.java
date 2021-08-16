package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.hibernate.id.CompositeNestedGeneratedValueGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.CharityApp.domain.converter.Converter;
import pl.akazoo.CharityApp.domain.dto.PasswordChanger;
import pl.akazoo.CharityApp.domain.dto.UserEdit;
import pl.akazoo.CharityApp.domain.model.User;
import pl.akazoo.CharityApp.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final Converter converter;

    @GetMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("userEdit", new UserEdit());
        return "user/profile";
    }

    @PostMapping("/profile")
    public String profileUpdate(@Valid UserEdit userEdit, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "user/profile";
        }

        User user = converter.userEditToLoggedUserUpdated(userEdit);
        userService.add(user);
        return "redirect:/user/profile";
    }

    @PostMapping("/changePassword")
    public String passwordChanger(@Valid PasswordChanger passwordChanger, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/profile";
        }
        return "messages/passwordChanged";
    }

    @GetMapping("/collections")
    public String collections() {

        return "user/collections";
    }
}
