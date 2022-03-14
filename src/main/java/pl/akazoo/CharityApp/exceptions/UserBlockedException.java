package pl.akazoo.CharityApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserBlockedException extends RuntimeException {

    public UserBlockedException() {}

    public UserBlockedException(String message) {
        super(message);
    }
}
