package pl.akazoo.CharityApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/donate")
public class DonationController {

    @GetMapping
    public String donateForm(){
        return "form";
    }
}
