package pl.akazoo.CharityApp.domain.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.akazoo.CharityApp.domain.dto.DonationAdd;
import pl.akazoo.CharityApp.domain.dto.UserAdd;
import pl.akazoo.CharityApp.domain.model.Donation;
import pl.akazoo.CharityApp.domain.model.User;
import pl.akazoo.CharityApp.service.CategoryService;
import pl.akazoo.CharityApp.service.InstitutionService;
import pl.akazoo.CharityApp.service.UserService;

@Component
@RequiredArgsConstructor
public class Converter {

    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final UserService userService;

    public User userAddToUser(UserAdd userAdd) {
        User user = new User();
        user.setFirstName(userAdd.getFirstName());
        user.setPassword(userAdd.getPassword());
        user.setRole("ROLE_USER");
        user.setAccountConfirmed("waiting");
        user.setEmail(userAdd.getEmail());
        user.setLastName(userAdd.getLastName());
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
        donation.setUser(userService.getLoggedUser());
        return donation;
    }
}