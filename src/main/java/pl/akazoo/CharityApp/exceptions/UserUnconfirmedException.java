package pl.akazoo.CharityApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserUnconfirmedException extends RuntimeException {

    public UserUnconfirmedException() {}

    public UserUnconfirmedException(String message) {
        super(message);
    }
}
