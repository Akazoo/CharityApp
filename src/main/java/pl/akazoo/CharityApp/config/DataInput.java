package pl.akazoo.CharityApp.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.CharityApp.domain.model.Category;
import pl.akazoo.CharityApp.domain.model.Donation;
import pl.akazoo.CharityApp.domain.model.Institution;
import pl.akazoo.CharityApp.domain.model.User;
import pl.akazoo.CharityApp.service.CategoryService;
import pl.akazoo.CharityApp.service.DonationService;
import pl.akazoo.CharityApp.service.InstitutionService;
import pl.akazoo.CharityApp.service.UserService;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataInput {

    private final AtomicBoolean alreadyRun = new AtomicBoolean(false);

    private final DonationService donationService;
    private final InstitutionService institutionService;
    private final CategoryService categoryService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @EventListener
    @Transactional
    public void testData(ContextRefreshedEvent event) {
        if (!alreadyRun.getAndSet(true)) {

            Category category = new Category(null, "ubrania, które nadają się do ponownego użycia");
            Category category1 = new Category(null, "ubrania, do wyrzucenia");
            Category category2 = new Category(null, "zabawki");
            Category category3 = new Category(null, "inne");
            Category category0 = new Category(null, "deleted/usunięta");
            Institution institution0 = new Institution(null, "deleted/usunięta", "deleted/usunięta");
            Institution institution = new Institution(null, "Dbam o Zdrowie", "Pomoc dzieciom z ubogich rodzin.");
            Institution institution1 = new Institution(null, "A kogo", "Pomoc wybudzaniu dzieci ze śpiączki.");
            Institution institution2 = new Institution(null, "Dla dzieci", "Pomoc osobom znajdującym się w trudnej sytuacji życiowej.");
            Institution institution3 = new Institution(null, "Bez domu", "Pomoc dla osób nie posiadających miejsca zamieszkania.");

            User user = new User();
            user.setEmail("aa");
            user.setPassword(passwordEncoder.encode("aa"));
            user.setRole("ROLE_ADMIN");
            user.setAccountConfirmation("confirmed");
            user.setFirstName("Paweł");
            user.setLastName("Zobaczymy");
            userService.add(user);
            Donation donation = new Donation(null, 5, List.of(category,category2), institution, "asd", "asd", "121", LocalDate.now(), LocalTime.now(), "niewiem", "+48 587416524", user, "created", LocalDate.now(), null);
            Donation donation2 = new Donation(null, 10, List.of(category,category3), institution, "asdd", "asdds", "11221", LocalDate.now(), LocalTime.now(), "niewisem", "+48 587416524", user, "collected", LocalDate.now(), null);
            categoryService.add(category0);
            categoryService.add(category);
            categoryService.add(category1);
            categoryService.add(category2);
            categoryService.add(category3);
            institutionService.add(institution0);
            institutionService.add(institution);
            institutionService.add(institution1);
            institutionService.add(institution2);
            institutionService.add(institution3);
            donationService.add(donation);
            donationService.add(donation2);
            User user1 = new User();
            user1.setEmail("bb");
            user1.setPassword(passwordEncoder.encode("bb"));
            user1.setRole("ROLE_USER");
            user1.setAccountConfirmation("confirmed");
            user1.setFirstName("Paweł");
            user1.setLastName("Zobaczymy");
            userService.add(user1);
            Donation donation3 = new Donation(null, 5, List.of(category,category2), institution, "asd", "asd", "121", LocalDate.now(), LocalTime.now(), "niewiem", "+48 587416524", user1, "created", LocalDate.now(), null);
            Donation donation4 = new Donation(null, 10, List.of(category,category3), institution, "asdd", "asdds", "11221", LocalDate.now(), LocalTime.now(), "niewisem", "+48 587416524", user1, "collected", LocalDate.now(), null);
            donationService.add(donation3);
            donationService.add(donation4);

        }
    }
}