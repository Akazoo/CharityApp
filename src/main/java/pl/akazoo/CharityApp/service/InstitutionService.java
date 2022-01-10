package pl.akazoo.CharityApp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.CharityApp.domain.model.Institution;
import pl.akazoo.CharityApp.domain.repository.InstitutionRepository;
import pl.akazoo.CharityApp.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class InstitutionService {

    private final InstitutionRepository institutionRepository;

    public void add(Institution institution) {
        log.debug("Obiekt do zapisu: " + institution);
        institutionRepository.save(institution);
        log.debug("Zapisano: " + institution);
    }

    public void delete(Long id) {
        Institution institution = getById(id);
        log.debug("Obiekt do usunięcia: " + institution);
        institutionRepository.delete(institution);
        log.debug("Usunięto: " + institution);
    }

    public List<Institution> getAll() {
        return institutionRepository.findAll();
    }

    public Institution getById(Long id) {
        return institutionRepository.findById(id).orElseGet(Institution::new);
    }

    public boolean existsByName(String name){
        return institutionRepository.existsByName(name);
    }
}