package pl.akazoo.CharityApp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.CharityApp.domain.model.User;
import pl.akazoo.CharityApp.domain.repository.UserRepository;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public void add(User user){
        log.debug("Zapisywany obiekt: " + user);
        userRepository.save(user);
        log.debug("Zapisano: " + user);
    }

    public User getLoggedUser() {
        Optional<User> user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        return user.orElseGet(User::new);
    }

    public boolean exists(String email) {
        return userRepository.existsByEmail(email);
    }

    public Optional<User> getUserByToken(String token) {
        return userRepository.findUserByActivationToken(token);
    }
}