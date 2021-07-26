package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.eclipse.jdt.internal.compiler.util.CompoundNameVector;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.CharityApp.domain.converter.Converter;
import pl.akazoo.CharityApp.domain.dto.DonationAdd;
import pl.akazoo.CharityApp.domain.model.Category;
import pl.akazoo.CharityApp.domain.model.Donation;
import pl.akazoo.CharityApp.domain.model.Institution;
import pl.akazoo.CharityApp.service.CategoryService;
import pl.akazoo.CharityApp.service.DonationService;
import pl.akazoo.CharityApp.service.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/donate")
@RequiredArgsConstructor
public class DonationController {

    private final InstitutionService institutionService;
    private final CategoryService categoryService;
    private final Converter converter;
    private final DonationService donationService;

    @GetMapping
    public String donateForm(Model model){
        model.addAttribute("donationAdd", new DonationAdd());
        return "form";
    }

    @PostMapping("/completed")
    public String donateCompleted(@Valid DonationAdd donationAdd, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }
        Donation donation = converter.donationAddToDonation(donationAdd);
        donationService.add(donation);
        return "form-confirmation";
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