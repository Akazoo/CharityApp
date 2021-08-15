package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.CharityApp.domain.model.User;
import pl.akazoo.CharityApp.security.TokenService;
import pl.akazoo.CharityApp.service.EmailService;
import pl.akazoo.CharityApp.service.UserService;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/activation")
@RequiredArgsConstructor
public class ActivationController {

    private final TokenService tokenService;
    private final UserService userService;
    private final EmailService emailService;

    @GetMapping("/{token}")
    public String activate(@PathVariable String token) {

        Optional<User> user = userService.getUserByToken(token);

        if (user.isPresent() && user.get().getAccountConfirmation().equals("waiting")) {
            User present = user.get();
            if (!tokenService.isTokenActive(present)) {
                present.setActivationToken(tokenService.getToken());
                present.setTokenExpireDate(LocalDate.now());
                emailService.sendActivationToken(present);
                userService.add(present);
                return "/messages/tokenExpired";
            }
            present.setAccountConfirmation("confirmed");
            userService.add(present);
            return "/messages/userConfirmed";
        }
        return "/messages/badToken";
    }

    @GetMapping("/failure")
    private String activationFailure(){
        return "/messages/activationFailure";
    }
}