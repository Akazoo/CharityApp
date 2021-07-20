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
            Institution institution = new Institution(null,"nic","nic2");

            Donation donation = new Donation(null,5, List.of(category),institution,"asd","asd","121", LocalDate.now(), LocalTime.now(),"niewiem");

            categoryService.add(category);
            institutionService.add(institution);
            donationService.add(donation);
        }
    }
}