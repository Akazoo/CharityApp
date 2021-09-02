package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.akazoo.CharityApp.domain.converter.Converter;
import pl.akazoo.CharityApp.domain.dto.PasswordChanger;
import pl.akazoo.CharityApp.domain.dto.UserEdit;
import pl.akazoo.CharityApp.domain.model.User;
import pl.akazoo.CharityApp.service.DonationService;
import pl.akazoo.CharityApp.service.UserService;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final Converter converter;
    private final PasswordEncoder passwordEncoder;
    private final DonationService donationService;

    @GetMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("userEdit", new UserEdit());
        return "users/profile";
    }

    @PostMapping("/profile")
    public String profileUpdate(@Valid UserEdit userEdit, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/profile";
        }
        User user = converter.userEditToLoggedUserUpdated(userEdit);
        userService.add(user);
        return "redirect:user/profile";
    }

    @GetMapping("/changePassword")
    public String passwordChange(Model model) {
        PasswordChanger passwordChanger = new PasswordChanger();
        passwordChanger.setEmail(userService.getLoggedUser().getEmail());
        model.addAttribute("passwordChanger", passwordChanger);
        return "users/passwordChange";
    }

    @PostMapping("/changePassword")
    public String passwordChanger(@Valid PasswordChanger passwordChanger, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/passwordChange";
        }
        if (!passwordChanger.getPassword().equals(passwordChanger.getPassword2())) {
            bindingResult.rejectValue("password", null, "Hasła nie są takie same.");
            return "users/passwordChange";
        }
        User user = userService.getUserByEmail(passwordChanger.getEmail());
        user.setPassword(passwordEncoder.encode(passwordChanger.getPassword()));
        userService.add(user);
        return "messages/passwordChanged";
    }

    @GetMapping("/collections")
    public String collections(Model model) {
        model.addAttribute("donations", donationService.getAllByLoggedUser());
        return "users/collections";
    }
}