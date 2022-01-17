package pl.akazoo.CharityApp.domain.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class InstitutionAdd {

    @Size(max = 50, message = "{size.50}")
    @NotBlank(message = "{general.notEmpty}")
    private String name;
    @Size(max = 100, message = "{size.100}")
    @NotBlank(message = "{general.notEmpty}")
    private String description;
}