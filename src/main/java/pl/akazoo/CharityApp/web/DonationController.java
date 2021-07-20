package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.CharityApp.domain.model.Category;
import pl.akazoo.CharityApp.domain.model.Institution;
import pl.akazoo.CharityApp.service.CategoryService;
import pl.akazoo.CharityApp.service.InstitutionService;
import java.util.List;

@Controller
@RequestMapping("/donate")
@RequiredArgsConstructor
public class DonationController {

    private final InstitutionService institutionService;
    private final CategoryService categoryService;

    @GetMapping
    public String donateForm(){
        return "form";
    }

    @ModelAttribute("institutions")
    public List<Institution> getInstitutions(){
        return institutionService.getAll();
    }

    @ModelAttribute("categories")
    public List<Category> getCategories(){
        return categoryService.getAll();
    }
}