package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.CharityApp.domain.dto.PasswordChanger;
import pl.akazoo.CharityApp.domain.model.User;
import pl.akazoo.CharityApp.security.TokenService;
import pl.akazoo.CharityApp.service.EmailService;
import pl.akazoo.CharityApp.service.UserService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tokens")
public class TokensController {

    private final TokenService tokenService;
    private final UserService userService;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/activation/{token}")
    public String activate(@PathVariable String token) {

        Optional<User> user = userService.getUserByToken("activation", token);

        if (user.isPresent() && user.get().getAccountConfirmation().equals("waiting")) {
            User present = user.get();
            if (!tokenService.isTokenActive(present)) {
                present.setActivationToken(tokenService.getToken());
                present.setTokenExpireDate(LocalDate.now());
                emailService.sendActivationToken(present);
                userService.add(present);
                return "messages/tokenExpired";
            }
            present.setAccountConfirmation("confirmed");
            present.setActivationToken("");
            userService.add(present);
            return "messages/userAccountConfirmed";
        }
        return "messages/badToken";
    }

    @GetMapping("/failure")
    public String activationFailure() {
        return "messages/activationFailure";
    }

    @GetMapping("/blocked")
    public String accountBlocked() {
        return "messages/accountBlocked";
    }

    @GetMapping("/resetPassword/{token}")
    public String reset(@PathVariable String token, Model model) {

        Optional<User> user = userService.getUserByToken("reset", token);

        if (user.isPresent()) {
            PasswordChanger passwordChanger = new PasswordChanger();
            passwordChanger.setEmail(user.get().getEmail());
            model.addAttribute("passwordChanger",passwordChanger);
            return "resetPassword/passwordChange";
        }

        return "messages/badToken";
    }

    @PostMapping("/resetPassword/reset")
    public String resetPassword(@Valid PasswordChanger passwordChanger, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "resetPassword/passwordChange";
        }
        if (!passwordChanger.getPassword().equals(passwordChanger.getPassword2())) {
            bindingResult.rejectValue("password", null, "Hasła nie są takie same/Passwords are not identical.");
            return "resetPassword/passwordChange";
        }
        User user = userService.getUserByEmail(passwordChanger.getEmail());
        user.setPassword(passwordEncoder.encode(passwordChanger.getPassword()));
        user.setResetPasswordToken("");
        userService.add(user);
        return "messages/passwordReset";
    }
}