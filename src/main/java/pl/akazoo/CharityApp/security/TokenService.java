package pl.akazoo.CharityApp.security;

import org.springframework.stereotype.Component;
import pl.akazoo.CharityApp.domain.model.User;
import java.time.LocalDate;
import java.util.UUID;

@Component
public class TokenService {

    public String getToken() {
        return UUID.randomUUID().toString();
    }

    public boolean isTokenActive(User user) {
        return user.getTokenExpireDate().isAfter(LocalDate.now());
    }
}