package pl.akazoo.CharityApp.domain.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class UserEdit {

    @NotBlank(message = "To pole nie może być puste.")
    private String firstName;
    @NotBlank(message = "To pole nie może być puste.")
    private String lastName;
    private Long id;
}