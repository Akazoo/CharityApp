package pl.akazoo.CharityApp.domain.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserEdit {

    @NotBlank(message = "{general.notEmpty}")
    private String firstName;
    @NotBlank(message = "{general.notEmpty}")
    private String lastName;
    private Long id;
    @Size(max = 100, message = "{size.100}")
    private String notes;
}