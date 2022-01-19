package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.CharityApp.domain.helpers.Converter;
import pl.akazoo.CharityApp.domain.dto.UserEdit;
import pl.akazoo.CharityApp.domain.model.User;
import pl.akazoo.CharityApp.service.DonationService;
import pl.akazoo.CharityApp.service.UserService;
import javax.validation.Valid;

@Controller
@RequestMapping("/admin/users")
@RequiredArgsConstructor
public class UsersController {

    private final UserService userService;
    private final DonationService donationService;
    private final Converter converter;

    @GetMapping("/delete/{id:\\d+}")
    public String deleteUser(@PathVariable Long id) {
        donationService.changeUserToNoneByUserId(id);
        userService.delete(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/edit/{id:\\d+}")
    public String editUser(@PathVariable Long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("userToEdit", user);
        model.addAttribute("userEdit", new UserEdit());
        return "/users/admin/editUser";
    }

    @PostMapping("/edit/check")
    public String editCheck(@Valid UserEdit userEdit, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/users/admin/editUser";
        }
        User user = converter.userEditToUser(userEdit);
        userService.add(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/block/{id:\\d+}")
    public String blockUser(@PathVariable Long id) {
        userService.blockUnblockById(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/elevate/{id:\\d+}")
    public String elevateUser(@PathVariable Long id) {
        userService.elevateUserToAdmin(id);
        return "redirect:/admin/users";
    }
}
