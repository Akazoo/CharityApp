package pl.akazoo.CharityApp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.CharityApp.domain.model.Category;
import pl.akazoo.CharityApp.domain.repository.CategoryRepository;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void add(Category category){
        log.debug("Obiekt do zapisu: " + category);
        categoryRepository.save(category);
        log.debug("Zapisano: " + category);
    }
}