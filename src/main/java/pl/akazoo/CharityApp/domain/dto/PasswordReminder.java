package pl.akazoo.CharityApp.domain.dto;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class PasswordReminder {

    @NotBlank(message = "To pole nie może być puste.")
    @Email(message = "Wprowadź proszę poprawny email.")
    private String email;
}