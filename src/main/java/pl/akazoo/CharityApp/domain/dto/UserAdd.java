package pl.akazoo.CharityApp.domain.dto;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class UserAdd {

    @NotBlank(message = "{general.notEmpty}")
    @Email(message = "{email.correct}")
    private String email;
    @NotBlank(message = "{general.notEmpty}")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "{password.correct}")
    private String password;
    @NotBlank(message = "{general.notEmpty}")
    private String password2;
    @NotBlank(message = "{general.notEmpty}")
    private String firstName;
    @NotBlank(message = "{general.notEmpty}")
    private String lastName;
}