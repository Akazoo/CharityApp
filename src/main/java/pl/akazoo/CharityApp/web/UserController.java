package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.CharityApp.service.UserService;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("user", userService.getLoggedUser());
        return "user/profile";
    }

    @GetMapping("/collections")
    public String collections() {

        return "user/collections";
    }
}
