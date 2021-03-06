package pl.akazoo.CharityApp.domain.helpers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.akazoo.CharityApp.domain.dto.*;
import pl.akazoo.CharityApp.domain.model.Category;
import pl.akazoo.CharityApp.domain.model.Donation;
import pl.akazoo.CharityApp.domain.model.Institution;
import pl.akazoo.CharityApp.domain.model.User;
import pl.akazoo.CharityApp.security.TokenService;
import pl.akazoo.CharityApp.service.CategoryService;
import pl.akazoo.CharityApp.service.InstitutionService;
import pl.akazoo.CharityApp.service.UserService;
import java.time.LocalDate;
import java.time.Period;

@Component
@RequiredArgsConstructor
public class Converter {

    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final UserService userService;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;
    @Value("${charity.app.token.expire.days}")
    private Integer tokenExpireDays;

    public User userAddToUser(UserAdd userAdd) {
        User user = new User();
        user.setFirstName(userAdd.getFirstName());
        String encodedPassword = passwordEncoder.encode(userAdd.getPassword());
        user.setPassword(encodedPassword);
        user.setRole("ROLE_USER");
        user.setAccountConfirmation("waiting");
        user.setEmail(userAdd.getEmail());
        user.setLastName(userAdd.getLastName());
        user.setActivationToken(tokenService.getToken());
        user.setTokenExpireDate(LocalDate.now().plus(Period.ofDays(tokenExpireDays)));
        return user;
    }

    public Donation donationAddToDonation(DonationAdd donationAdd) {
        Donation donation = new Donation();
        donation.setQuantity(donationAdd.getQuantity());
        donation.setCategories(categoryService.getCategoriesById(donationAdd.getCategories()));
        donation.setInstitution(institutionService.getById(donationAdd.getInstitution()));
        donation.setStreet(donationAdd.getStreet());
        donation.setCity(donationAdd.getCity());
        donation.setZipCode(donationAdd.getZipCode());
        donation.setPickUpDate(donationAdd.getPickUpDate());
        donation.setPickUpTime(donationAdd.getPickUpTime());
        donation.setPickUpComment(donationAdd.getPickUpComment());
        donation.setPhoneNumber(donationAdd.getPhoneNumber());
        donation.setStatus("created");
        donation.setUser(userService.getLoggedUser());
        return donation;
    }

    public User userEditToLoggedUserUpdated(UserEdit userEdit) {
        User user = userService.getLoggedUser();
        user.setLastName(userEdit.getLastName());
        user.setFirstName(userEdit.getFirstName());
        return user;
    }

    public InstitutionEdit institutionToInstitutionEdit(Institution institution) {
        InstitutionEdit institutionEdit = new InstitutionEdit();
        institutionEdit.setId(institution.getId());
        institutionEdit.setName(institution.getName());
        institutionEdit.setDescription(institution.getDescription());
        return institutionEdit;
    }
    public Institution institutionEditToInstitution(InstitutionEdit institutionEdit) {
        Institution institution1 = new Institution();
        institution1.setId(institutionEdit.getId());
        institution1.setName(institutionEdit.getName());
        institution1.setDescription(institutionEdit.getDescription());
        return institution1;
    }

    public Institution institutionAddToInstitution(InstitutionAdd institutionAdd) {
        Institution institution = new Institution();
        institution.setName(institutionAdd.getName());
        institution.setDescription(institutionAdd.getDescription());
        return institution;
    }

    public CategoryEdit categoryToCategoryEdit(Category category) {
        CategoryEdit categoryEdit = new CategoryEdit();
        categoryEdit.setId(category.getId());
        categoryEdit.setName(category.getName());
        return categoryEdit;
    }

    public Category categoryEditToCategory(CategoryEdit categoryEdit){
        Category category = new Category();
        category.setId(categoryEdit.getId());
        category.setName(categoryEdit.getName());
        return category;
    }

    public Category categoryAddToCategory(CategoryAdd categoryAdd) {
        Category category = new Category();
        category.setName(categoryAdd.getName());
        return category;
    }

    public User userEditToUser(UserEdit userEdit) {
        User user = userService.getById(userEdit.getId());
        user.setLastName(userEdit.getLastName());
        user.setFirstName(userEdit.getFirstName());
        user.setNotes(userEdit.getNotes());
        return user;
    }
}