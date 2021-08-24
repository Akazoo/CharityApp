package pl.akazoo.CharityApp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.CharityApp.domain.model.Donation;
import pl.akazoo.CharityApp.domain.repository.DonationRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class DonationService {

    private final DonationRepository donationRepository;
    private final UserService userService;

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

    public void delete(Long id){
        Optional<Donation> donation = getDonationById(id);
        log.debug("Obiekt do usunięcia:" + donation);
        donation.ifPresent(donationRepository::delete);
        log.debug("Usunięto:" + donation);
    }

    public void confirmCollection(Long id){
        Optional<Donation> donation = getDonationById(id);
        if(donation.isPresent()){
            Donation donation1 = donation.get();
            donation1.setStatus("collected");
            add(donation1);
        }
    }

    public Optional<Donation> getDonationById(Long id){
        return donationRepository.findById(id);
    }

    public List<Donation> getAllByLoggedUser() {
        return donationRepository.findAllByUser(userService.getLoggedUser());
    }
}