package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/rules")
public class RegulationsController {

    @GetMapping
    public String confirmed(){
        return "mainPage/rules";
    }
}
