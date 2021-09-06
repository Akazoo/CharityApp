package pl.akazoo.CharityApp.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CategoryAdd {

    @Size(max = 50)
    @NotBlank
    private String name;
}