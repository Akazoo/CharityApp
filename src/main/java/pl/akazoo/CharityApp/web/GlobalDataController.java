package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.akazoo.CharityApp.domain.dto.ContactMessage;
import pl.akazoo.CharityApp.domain.model.User;
import pl.akazoo.CharityApp.exceptions.ResourceNotFoundException;
import pl.akazoo.CharityApp.exceptions.UserBlockedException;
import pl.akazoo.CharityApp.exceptions.UserUnconfirmedException;
import pl.akazoo.CharityApp.service.UserService;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalDataController {

    private final UserService userService;

    @ModelAttribute
    public void globalData(Model model) {
        model.addAttribute("loggedUser", userService.getLoggedUser());
        model.addAttribute("contactMessage", new ContactMessage());

        User user = userService.getLoggedUser();
        if (user.getAccountConfirmation() != null) {
            switch (user.getAccountConfirmation()) {
                case "waiting":
                    throw new UserUnconfirmedException();
                case "blocked":
                    throw new UserBlockedException();
            }
        }
    }

    @ExceptionHandler(UserUnconfirmedException.class)
    public String unconfirmed() {
        return "messages/activationFailure";
    }

    @ExceptionHandler(UserBlockedException.class)
    public String blocked() {
        return "messages/accountBlocked";
    }
}