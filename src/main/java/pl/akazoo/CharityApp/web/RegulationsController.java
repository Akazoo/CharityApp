package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.CharityApp.domain.helpers.Helpers;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/rules")
public class RegulationsController {

    private final Helpers helpers;

    @GetMapping
    public String confirmed(Model model){
        List<String> rules = helpers.geRulesContent();
        model.addAttribute("rules",rules);
        return "mainPage/rules";
    }
}
