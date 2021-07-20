package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.CharityApp.service.DonationService;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    private final DonationService donationService;

    @GetMapping
    public String homeAction(Model model) {
        model.addAttribute("donations", donationService.count());
        model.addAttribute("bags", donationService.bagsCount());
        return "index";
    }
}