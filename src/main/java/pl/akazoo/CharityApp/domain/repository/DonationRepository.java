package pl.akazoo.CharityApp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.akazoo.CharityApp.domain.model.Donation;
import pl.akazoo.CharityApp.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface DonationRepository extends JpaRepository<Donation,Long> {

    @Query("select SUM(d.quantity) from Donation d")
    Optional<Long> countBags();

    List<Donation> findAllByUser(User user);

    List<Donation> findAllByInstitution_Id(Long id);
}