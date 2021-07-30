package pl.akazoo.CharityApp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.CharityApp.domain.model.Category;
import pl.akazoo.CharityApp.domain.repository.CategoryRepository;
import pl.akazoo.CharityApp.exceptions.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public List<Category> getCategoriesById(List<Long> idList){
        List<Category> readyList = new ArrayList<>();
        idList.forEach(id -> readyList.add(getById(id)));
        return readyList;
    }

    public Category getById(Long id){
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category with id=" + id + " not exist"));
    }
}