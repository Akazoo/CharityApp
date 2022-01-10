package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.aspectj.asm.IModelFilter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.akazoo.CharityApp.domain.converter.Converter;
import pl.akazoo.CharityApp.domain.dto.InstitutionAdd;
import pl.akazoo.CharityApp.domain.dto.InstitutionEdit;
import pl.akazoo.CharityApp.domain.dto.PasswordChanger;
import pl.akazoo.CharityApp.domain.dto.UserEdit;
import pl.akazoo.CharityApp.domain.model.Category;
import pl.akazoo.CharityApp.domain.model.Institution;
import pl.akazoo.CharityApp.domain.model.User;
import pl.akazoo.CharityApp.service.CategoryService;
import pl.akazoo.CharityApp.service.DonationService;
import pl.akazoo.CharityApp.service.InstitutionService;
import pl.akazoo.CharityApp.service.UserService;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminPanelController {

    private final DonationService donationService;
    private final UserService userService;
    private final InstitutionService institutionService;
    private final CategoryService categoryService;

    @GetMapping("/collections")
    public String collections(Model model) {
        model.addAttribute("donations", donationService.getAllDonations());
        return "users/collections";
    }

    @GetMapping("/admins")
    public String admins(Model model) {
        model.addAttribute("admins", userService.getUsersByRole("ROLE_ADMIN"));
        return "/users/admin/admins";
    }

    @GetMapping("/admins/badAction")
    public String adminsBadAction(Model model) {
        model.addAttribute("admins", userService.getUsersByRole("ROLE_ADMIN"));
        model.addAttribute("noAdmin","Nie możesz zdegradować siebie <br> lub po wykonaniu tej akcji liczba administratorów będzie mniejsza niż 1.");
        return "/users/admin/admins";
    }

    @GetMapping("/foundations")
    public String foundations(Model model) {
        model.addAttribute("institutions", institutionService.getAll());
        return "users/admin/foundations";
    }

    @GetMapping("/categories")
    public String categories(Model model) {
        List<Category> categories = categoryService.getAll();
        categories.sort(Comparator.comparing(Category::getId));
        model.addAttribute("categories", categories);
        return "users/admin/categories";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.getUsersByRole("ROLE_USER"));
        return "users/admin/users";
    }
}