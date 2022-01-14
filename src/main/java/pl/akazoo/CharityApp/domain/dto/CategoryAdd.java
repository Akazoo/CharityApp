package pl.akazoo.CharityApp.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CategoryAdd {

    @Size(max = 50, message = "{size.50}")
    @NotBlank(message = "{general.notEmpty}")
    private String name;
}