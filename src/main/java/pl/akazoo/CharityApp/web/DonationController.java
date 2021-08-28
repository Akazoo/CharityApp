package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
import java.util.Optional;

@Controller
@RequestMapping("/donation")
@RequiredArgsConstructor
public class DonationController {

    private final InstitutionService institutionService;
    private final CategoryService categoryService;
    private final Converter converter;
    private final DonationService donationService;

    @GetMapping("/donate")
    public String donateForm(Model model) {
        model.addAttribute("donationAdd", new DonationAdd());
        return "donations/form";
    }

    @PostMapping("/donate/completed")
    public String donateCompleted(@Valid DonationAdd donationAdd, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error","Formularz nie został przyjęty ponieważ zawiera błędy.");
            model.addAttribute("error1", "Popraw je proszę i spróbuj ponownie.");
            return "donations/form";
        }
        Donation donation = converter.donationAddToDonation(donationAdd);
        donationService.add(donation);
        return "messages/donationConfirmed";
    }

    @GetMapping("/{id:\\d+}")
    public String donationDetails(@PathVariable Long id, Model model, @RequestHeader("Referer") String referer) {
        Optional<Donation> donation = donationService.getDonationById(id);
        model.addAttribute("donation", donation.get());
        model.addAttribute("back", referer);
        return "donations/details";
    }

    @GetMapping("/delete/{id:\\d+}")
    public String deleteDonation(@PathVariable Long id, @RequestHeader("Referer") String referer) {
        donationService.delete(id);
        return "redirect:" + referer;
    }

    @GetMapping("/confirm/{id:\\d+}")
    public String confirmDonations(@PathVariable Long id) {
        donationService.confirmCollection(id);
        return "redirect:/user/collections";
    }

    @ModelAttribute("institutions")
    public List<Institution> getInstitutions() {
        return institutionService.getAll();
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryService.getAll();
    }
}