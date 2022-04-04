package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.akazoo.CharityApp.domain.helpers.Converter;
import pl.akazoo.CharityApp.domain.dto.CategoryAdd;
import pl.akazoo.CharityApp.domain.dto.CategoryEdit;
import pl.akazoo.CharityApp.domain.model.Category;
import pl.akazoo.CharityApp.service.CategoryService;
import pl.akazoo.CharityApp.service.DonationService;
import pl.akazoo.CharityApp.service.EmailService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final DonationService donationService;
    private final Converter converter;
    private final EmailService emailService;

    @GetMapping("/delete/{id:\\d+}")
    public String deleteCategory(@PathVariable Long id) {
        donationService.changeCategoryToNoneByCategoryId(id);
        categoryService.delete(id);
        emailService.sendUpdateToAllUsers("Kategorie/Categories");
        return "redirect:/admin/categories";
    }

    @GetMapping("/edit/{id:\\d+}")
    public String editCategory(@PathVariable Long id, Model model, @RequestHeader("Referer") String referer) {
        Category category = categoryService.getById(id);
        model.addAttribute("categoryEdit", converter.categoryToCategoryEdit(category));
        model.addAttribute("back", referer);
        return "categories/edit";
    }

    @PostMapping("/edit/check")
    public String editCategory(@Valid CategoryEdit categoryEdit, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "categories/edit";
        }
        if (categoryService.existsByName(categoryEdit.getName())){
            if(!categoryService.getById(categoryEdit.getId()).getName().equals(categoryEdit.getName())) {
                bindingResult.rejectValue("name", null, "Podana nazwa jest już zajęta/Name already in use.");
                return "categories/edit";
            }
        }
        Category category= converter.categoryEditToCategory(categoryEdit);
        categoryService.add(category);
        emailService.sendUpdateToAllUsers("Kategorie/Categories");
        return "redirect:/admin/categories";
    }

    @GetMapping("/add")
    public String addCategory(Model model, @RequestHeader("Referer") String referer) {
        model.addAttribute("categoryAdd", new CategoryAdd());
        model.addAttribute("back", referer);
        return "categories/add";
    }

    @PostMapping("/add")
    public String addCategoryCheck(@Valid CategoryAdd categoryAdd, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "categories/add";
        }
        if (categoryService.existsByName(categoryAdd.getName())) {
            bindingResult.rejectValue("name", null, "Podana nazwa jest już zajęta/Name already in use.");
            return "categories/add";
        }
        Category category = converter.categoryAddToCategory(categoryAdd);
        categoryService.add(category);
        emailService.sendUpdateToAllUsers("Kategorie/Categories");
        return "redirect:/admin/categories";
    }
}