package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.CharityApp.domain.dto.PasswordChanger;
import pl.akazoo.CharityApp.domain.dto.UserEdit;
import pl.akazoo.CharityApp.domain.model.User;
import pl.akazoo.CharityApp.service.DonationService;
import pl.akazoo.CharityApp.service.InstitutionService;
import pl.akazoo.CharityApp.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final DonationService donationService;
    private final UserService userService;
    private final InstitutionService institutionService;

    @GetMapping("/collections")
    public String collections(Model model) {
        model.addAttribute("donations",donationService.getAllDonations());
        return "users/collections";
    }

    @GetMapping("/admins")
    public String admins(Model model) {
        model.addAttribute("admins",userService.getUsersByRole("ROLE_ADMIN"));
        return "/users/admin/admins";
    }

    @GetMapping("/foundations")
    public String foundations(Model model) {
        model.addAttribute("institutions",institutionService.getAll());
        return "users/admin/foundations";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users",userService.getUsersByRole("ROLE_USER"));
        return "users/admin/users";
    }

}