package pl.akazoo.CharityApp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.akazoo.CharityApp.domain.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<User> findUserByActivationToken(String token);

    Optional<User> findUserByResetPasswordToken(String token);

}
