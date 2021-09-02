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
import pl.akazoo.CharityApp.domain.dto.PasswordChanger;
import pl.akazoo.CharityApp.domain.dto.UserEdit;
import pl.akazoo.CharityApp.domain.model.Institution;
import pl.akazoo.CharityApp.domain.model.User;
import pl.akazoo.CharityApp.service.CategoryService;
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
    private final CategoryService categoryService;
    private final Converter converter;

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

    @GetMapping("/foundations")
    public String foundations(Model model) {
        model.addAttribute("institutions", institutionService.getAll());
        return "users/admin/foundations";
    }

    @GetMapping("/categories")
    public String categories(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "users/admin/categories";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.getUsersByRole("ROLE_USER"));
        return "users/admin/users";
    }

    @GetMapping("/admins/demote/{id:\\d+}")
    public String demotion(@PathVariable Long id) {
        User user = userService.getLoggedUser();
        if (user.getId().equals(id) || userService.getNumberOfAdmins() <= 1) {
            return "redirect:/admin/admins";
        }
        userService.demoteAdminToUser(id);
        return "redirect:/admin/admins";
    }

    @GetMapping("/foundations/delete/{id:\\d+}")
    public String delete(@PathVariable Long id) {
        donationService.changeInstitutionToNoneByInstitutionId(id);
        institutionService.delete(id);
        return "redirect:/admin/foundations";
    }

    @GetMapping("/foundations/edit/{id:\\d+}")
    public String editFoundation(@PathVariable Long id, Model model) {
        Institution institution = institutionService.getById(id);
        model.addAttribute("foundation", converter.institutionToInstitutionAdd(institution));
        return "foundations/edit";
    }

    @PostMapping("/foundations/edit/check")
    public String editFoundation(@Valid InstitutionAdd institutionAdd, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "foundations/edit";
        }
        Institution institution = converter.institutionAddToInstitution(institutionAdd);
        institutionService.add(institution);
        return "redirect:admins/foundations";
    }

    @GetMapping("/foundations/add")
    public String addFoundation(Model model) {
        model.addAttribute("foundation", new InstitutionAdd());
        return "foundations/add";
    }

    @PostMapping("/foundations/add")
    public String addFoundationCheck(@Valid InstitutionAdd institutionAdd, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "foundations/add";
        }
        if (institutionService.existsByName(institutionAdd.getName())) {
            bindingResult.rejectValue("name", null, "Podana nazwa jest już zajęta.");
            return "foundations/add";
        }
        Institution institution = converter.institutionAddToInstitution(institutionAdd);
        institutionService.add(institution);
        return "redirect:admin/foundations";
    }
}