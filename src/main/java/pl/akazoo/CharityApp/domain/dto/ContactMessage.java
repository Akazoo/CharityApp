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

    @NotBlank
    private String text;
    @NotBlank
    private String firstName;
    @NotBlank
    @Email
    private String responseMail;
}