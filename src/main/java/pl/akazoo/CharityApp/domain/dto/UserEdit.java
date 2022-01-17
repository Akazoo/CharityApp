package pl.akazoo.CharityApp.domain.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class UserEdit {

    @NotBlank(message = "{general.notEmpty}")
    private String firstName;
    @NotBlank(message = "{general.notEmpty}")
    private String lastName;
    private Long id;
}