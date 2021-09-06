package pl.akazoo.CharityApp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.akazoo.CharityApp.domain.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName(String name);
}