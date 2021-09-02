package pl.akazoo.CharityApp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.akazoo.CharityApp.domain.model.Institution;

public interface InstitutionRepository extends JpaRepository<Institution,Long> {

    boolean existsByName(String name);
}