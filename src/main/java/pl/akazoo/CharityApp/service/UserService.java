package pl.akazoo.CharityApp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akazoo.CharityApp.domain.model.Institution;
import pl.akazoo.CharityApp.domain.model.User;
import pl.akazoo.CharityApp.domain.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public void add(User user) {
        log.debug("Obiekt do zapisu: " + user);
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

    public Optional<User> getUserByToken(String tokenName, String token) {
        switch (tokenName) {
            case "activation":
                return userRepository.findUserByActivationToken(token);
            case "reset":
                return userRepository.findUserByResetPasswordToken(token);
            default:
                return Optional.empty();
        }
    }

    public User getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.orElseGet(User::new);
    }

    public List<User> getUsersByRole(String role) {
        return userRepository.findUsersByRole(role);
    }

    public void demoteAdminToUser(Long id) {
        User user = getById(id);
        user.setRole("ROLE_USER");
        add(user);

    }

    public void elevateUserToAdmin(Long id) {
        User user = getById(id);
        user.setRole("ROLE_ADMIN");
        add(user);
    }

    public int getNumberOfAdmins() {
        return userRepository.countUsersByRoleEquals("ROLE_ADMIN");
    }

    public void delete(Long id) {
        User user = getById(id);
        log.debug("Obiekt do usunięcia: " + user);
        userRepository.delete(user);
        log.debug("Usunięto: " + user);
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElseGet(User::new);
    }

    public void blockUnblockById(Long id) {
        User user = getById(id);
        String status = user.getAccountConfirmation();
        if (!status.equals("blocked")) user.setAccountConfirmation("blocked");
        if (status.equals("blocked")) user.setAccountConfirmation("active");
        add(user);
    }

    public List<User> getAll(){
        List<User> userList = userRepository.findAll();
        userList.remove(0);
        return userList;
    }
}