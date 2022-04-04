package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.akazoo.CharityApp.domain.helpers.Converter;
import pl.akazoo.CharityApp.domain.dto.InstitutionAdd;
import pl.akazoo.CharityApp.domain.dto.InstitutionEdit;
import pl.akazoo.CharityApp.domain.model.Institution;
import pl.akazoo.CharityApp.service.DonationService;
import pl.akazoo.CharityApp.service.EmailService;
import pl.akazoo.CharityApp.service.InstitutionService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/foundations")
@RequiredArgsConstructor
public class FoundationController {

    private final DonationService donationService;
    private final InstitutionService institutionService;
    private final Converter converter;
    private final EmailService emailService;

    @GetMapping("/delete/{id:\\d+}")
    public String deleteFoundation(@PathVariable Long id) {
        donationService.changeInstitutionToNoneByInstitutionId(id);
        institutionService.delete(id);
        emailService.sendUpdateToAllUsers("Fundacje/Foundations");
        return "redirect:/admin/foundations";
    }

    @GetMapping("/edit/{id:\\d+}")
    public String editFoundation(@PathVariable Long id, Model model, @RequestHeader("Referer") String referer) {
        Institution institution = institutionService.getById(id);
        model.addAttribute("institutionEdit", converter.institutionToInstitutionEdit(institution));
        model.addAttribute("back", referer);
        return "foundations/edit";
    }

    @PostMapping("/edit/check")
    public String editFoundation(@Valid InstitutionEdit institutionEdit, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "foundations/edit";
        }
        if (institutionService.existsByName(institutionEdit.getName())){
            if(!institutionService.getById(institutionEdit.getId()).getName().equals(institutionEdit.getName())) {
                bindingResult.rejectValue("name", null, "Podana nazwa jest już zajęta/Name already in use.");
                return "foundations/edit";
            }
        }
        Institution institution = converter.institutionEditToInstitution(institutionEdit);
        institutionService.add(institution);
        emailService.sendUpdateToAllUsers("Fundacje/Foundations");
        return "redirect:/admin/foundations";
    }

    @GetMapping("/add")
    public String addFoundation(Model model, @RequestHeader("Referer") String referer) {
        model.addAttribute("institutionAdd", new InstitutionAdd());
        model.addAttribute("back", referer);
        return "foundations/add";
    }

    @PostMapping("/add")
    public String addFoundationCheck(@Valid InstitutionAdd institutionAdd, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "foundations/add";
        }
        if (institutionService.existsByName(institutionAdd.getName())) {
            bindingResult.rejectValue("name", null, "Podana nazwa jest już zajęta/Name already in use.");
            return "foundations/add";
        }
        Institution institution = converter.institutionAddToInstitution(institutionAdd);
        institutionService.add(institution);
        emailService.sendUpdateToAllUsers("Fundacje/Foundations");
        return "redirect:/admin/foundations";
    }
}