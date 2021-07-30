package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.akazoo.CharityApp.domain.model.ContactMessage;
import pl.akazoo.CharityApp.service.UserService;

@ControllerAdvice(basePackageClasses = {HomeController.class})
@RequiredArgsConstructor
public class GlobalDataController {

    private final UserService userService;

    @ModelAttribute
    public void globalData(Model model) {
        model.addAttribute("logged",userService.getLoggedUser().getFirstName());
        model.addAttribute("contactMessage", new ContactMessage());
    }
}