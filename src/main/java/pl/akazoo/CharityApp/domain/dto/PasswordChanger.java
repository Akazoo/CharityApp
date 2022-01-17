package pl.akazoo.CharityApp.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class PasswordChanger {

    @NotBlank(message = "{general.notEmpty}")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "{password.correct}")
    private String password;
    @NotBlank(message = "{general.notEmpty}")
    private String password2;
    @NotBlank(message = "{general.notEmpty}")
    private String email;
}