package pl.akazoo.CharityApp.domain.dto;

import lombok.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ContactMessage {

    @NotBlank(message = "{general.notEmpty}")
    private String text;
    @NotBlank(message = "{general.notEmpty}")
    private String firstName;
    @NotBlank(message = "{general.notEmpty}")
    @Email(message = "{email.correct}")
    private String responseMail;
}