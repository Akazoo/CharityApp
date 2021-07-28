package pl.akazoo.CharityApp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.CharityApp.domain.model.Donation;
import pl.akazoo.CharityApp.domain.repository.DonationRepository;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class DonationService {

    private final DonationRepository donationRepository;

    public Long count(){
        return donationRepository.count();
    }

    public Long getBagsCount(){
       Optional<Long> bags = donationRepository.countBags();
        return bags.orElse(0L);
    }

    public void add(Donation donation){
        log.debug("Obiekt do zapisu: " + donation);
        donationRepository.save(donation);
        log.debug("Zapisano: " + donation);
    }
}