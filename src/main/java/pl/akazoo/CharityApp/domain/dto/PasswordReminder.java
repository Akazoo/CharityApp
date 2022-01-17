package pl.akazoo.CharityApp.domain.dto;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class PasswordReminder {

    @NotBlank(message = "{general.notEmpty}")
    @Email(message = "{email.correct}")
    private String email;
}