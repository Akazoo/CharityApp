package pl.akazoo.CharityApp.domain.dto;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserAdd {

    @NotBlank(message = "To pole nie może być puste.")
    @Email(message = "Wprowadź proszę poprawny email.")
    private String email;
    @NotBlank(message = "To pole nie może być puste.")
    private String password;
    @NotBlank(message = "To pole nie może być puste.")
    private String password2;
    @NotBlank(message = "To pole nie może być puste.")
    private String firstName;
    @NotBlank(message = "To pole nie może być puste.")
    private String lastName;
}