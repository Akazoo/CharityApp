package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.CharityApp.service.UserService;

@Controller
@RequestMapping("/admin/users")
@RequiredArgsConstructor
public class UsersController {

    private final UserService userService;

    @GetMapping("/delete/{id:\\d+}")
    public String deleteUser(@PathVariable Long id) {

        return "redirect:/admin/users";
    }

    @GetMapping("/edit/{id:\\d+}")
    public String editUser(@PathVariable Long id) {

        return "widok";
    }

    @PostMapping("/edit/check")
    public String editCheck() {
        return "redirect:/admin/users";
    }

    @GetMapping("/block/{id:\\d+}")
    public String blockUser(@PathVariable Long id) {
        return "redirect:/admin/users";
    }

    @GetMapping("/elevate/{id:\\d+}")
    public String elevateUser(@PathVariable Long id) {
        userService.elevateUserToAdmin(id);
        return "redirect:/admin/users";
    }
}
