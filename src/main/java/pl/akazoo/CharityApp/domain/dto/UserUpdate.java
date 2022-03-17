package pl.akazoo.CharityApp.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserUpdate {

    @NotBlank(message = "{general.notEmpty}")
    private String reason;
    @NotBlank(message = "{general.notEmpty}")
    private String target;
}