package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.CharityApp.domain.model.User;
import pl.akazoo.CharityApp.service.UserService;

@Controller
@RequestMapping("/admin/admins")
@RequiredArgsConstructor
public class AdminsController {

    private final UserService userService;

    @GetMapping("/demote/{id:\\d+}")
    public String demotion(@PathVariable Long id) {
        User user = userService.getLoggedUser();
        if (user.getId().equals(id)) {
            return "redirect:/admin/admins/badAction/2";
        }
        if (userService.getNumberOfAdmins() <= 1) {
            return "redirect:/admin/admins/badAction/1";
        }
        userService.demoteAdminToUser(id);
        return "redirect:/admin/admins";
    }

    @GetMapping("/badAction/{ip:\\d+}")
    public String adminsBadAction(Model model, @PathVariable Long ip) {
        model.addAttribute("admins", userService.getUsersByRole("ROLE_ADMIN"));
        model.addAttribute("noAdmin",ip);
        return "/users/admin/admins";
    }
}
