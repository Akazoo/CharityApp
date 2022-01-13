package pl.akazoo.CharityApp.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akazoo.CharityApp.domain.Helpers.Converter;
import pl.akazoo.CharityApp.domain.dto.CategoryAdd;
import pl.akazoo.CharityApp.domain.dto.CategoryEdit;
import pl.akazoo.CharityApp.domain.model.Category;
import pl.akazoo.CharityApp.service.CategoryService;
import pl.akazoo.CharityApp.service.DonationService;
import javax.validation.Valid;

@Controller
@RequestMapping("/admin/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final DonationService donationService;
    private final Converter converter;

    @GetMapping("/delete/{id:\\d+}")
    public String deleteCategory(@PathVariable Long id) {
        donationService.changeCategoryToNoneByCategoryId(id);
        categoryService.delete(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/edit/{id:\\d+}")
    public String editCategory(@PathVariable Long id, Model model) {
        Category category = categoryService.getById(id);
        model.addAttribute("categoryEdit", converter.categoryToCategoryEdit(category));
        return "categories/edit";
    }

    @PostMapping("/edit/check")
    public String editCategory(@Valid CategoryEdit categoryEdit, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "categories/edit";
        }
        if (categoryService.existsByName(categoryEdit.getName())){
            if(!categoryService.getById(categoryEdit.getId()).getName().equals(categoryEdit.getName())) {
                bindingResult.rejectValue("name", null, "Podana nazwa jest już zajęta.");
                return "categories/edit";
            }
        }
        Category category= converter.categoryEditToCategory(categoryEdit);
        categoryService.add(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/add")
    public String addCategory(Model model) {
        model.addAttribute("categoryAdd", new CategoryAdd());
        return "categories/add";
    }

    @PostMapping("/add")
    public String addCategoryCheck(@Valid CategoryAdd categoryAdd, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "categories/add";
        }
        if (categoryService.existsByName(categoryAdd.getName())) {
            bindingResult.rejectValue("name", null, "Podana nazwa jest już zajęta.");
            return "categories/add";
        }
        Category category = converter.categoryAddToCategory(categoryAdd);
        categoryService.add(category);
        return "redirect:/admin/categories";
    }
}