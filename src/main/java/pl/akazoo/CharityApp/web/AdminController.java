package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.CharityApp.service.UserService;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    @GetMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("user", userService.getLoggedUser());
        return "admin/profile";
    }

    @GetMapping("/collections")
    public String collections() {
        return "admin/collections";
    }

    @GetMapping("/admins")
    public String admins() {
        return "admin/admins";
    }

    @GetMapping("/foundations")
    public String foundations() {
        return "admin/foundations";
    }

    @GetMapping("/users")
    public String users() {
        return "admin/users";
    }
}
