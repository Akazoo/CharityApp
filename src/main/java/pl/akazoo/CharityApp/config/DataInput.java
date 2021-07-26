package pl.akazoo.CharityApp.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
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

    private AtomicBoolean alreadyRun = new AtomicBoolean(false);

    private final DonationService donationService;
    private final InstitutionService institutionService;
    private final CategoryService categoryService;
    private final UserService userService;

    @EventListener
    @Transactional
    public void testData(ContextRefreshedEvent event) {
        if (!alreadyRun.getAndSet(true)) {

            Category category = new Category(null, "ubrania, które nadają się do ponownego użycia");
            Category category1 = new Category(null, "ubrania, do wyrzucenia");
            Category category2 = new Category(null, "zabawki");
            Category category3 = new Category(null, "inne");
            Institution institution = new Institution(null, "Dbam o Zdrowie", "Pomoc dzieciom z ubogich rodzin.");
            Institution institution1 = new Institution(null, "A kogo", "Pomoc wybudzaniu dzieci ze śpiączki.");
            Institution institution2 = new Institution(null, "Dla dzieci", "Pomoc osobom znajdującym się w trudnej sytuacji życiowej.");
//            Institution institution3 = new Institution(null,"Bez domu","Pomoc dla osób nie posiadających miejsca zamieszkania.");

            User user = new User();
            user.setPassword("aa");
            user.setEmail("aa");
            user.setRole("ROLE_ADMIN");
            user.setAccountConfirmed("activated");
            user.setFirstName("Paweł");
            user.setLastName("Zobaczymy");
            userService.add(user);
            Donation donation = new Donation(null, 5, List.of(category), institution, "asd", "asd", "121", LocalDate.now(), LocalTime.now(), "niewiem", "+48 587416524", user);

            categoryService.add(category);
            categoryService.add(category1);
            categoryService.add(category2);
            categoryService.add(category3);
            institutionService.add(institution);
            institutionService.add(institution1);
            institutionService.add(institution2);
//            institutionService.add(institution3);
            donationService.add(donation);
        }
    }
}