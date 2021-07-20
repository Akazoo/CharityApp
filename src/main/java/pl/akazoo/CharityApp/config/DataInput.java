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
import pl.akazoo.CharityApp.service.CategoryService;
import pl.akazoo.CharityApp.service.DonationService;
import pl.akazoo.CharityApp.service.InstitutionService;
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

    @EventListener
    @Transactional
    public void testData(ContextRefreshedEvent event) {
        if (!alreadyRun.getAndSet(true)) {

            Category category = new Category(null,"śmieci");
            Institution institution = new Institution(null,"\"Dbam o Zdrowie\"","Pomoc dzieciom z ubogich rodzin.");
            Institution institution1 = new Institution(null,"\"A kogo\"","Pomoc wybudzaniu dzieci ze śpiączki.");
            Institution institution2 = new Institution(null,"\"Dla dzieci\"","Pomoc osobom znajdującym się w trudnej sytuacji życiowej.");
            Institution institution3 = new Institution(null,"\"Bez domu\"","Pomoc dla osób nie posiadających miejsca zamieszkania.");

            Donation donation = new Donation(null,5, List.of(category),institution,"asd","asd","121", LocalDate.now(), LocalTime.now(),"niewiem");

            categoryService.add(category);
            institutionService.add(institution);
            institutionService.add(institution1);
            institutionService.add(institution2);
            institutionService.add(institution3);
            donationService.add(donation);
        }
    }
}