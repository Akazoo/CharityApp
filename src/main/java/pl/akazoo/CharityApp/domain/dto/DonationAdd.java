package pl.akazoo.CharityApp.domain.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class DonationAdd {

    @NotNull(message = "{general.notEmpty}")
    private Integer quantity;
    @NotEmpty(message = "{category.notEmpty}")
    private List<Long> categories;
    @NotNull(message = "{institution.notEmpty}")
    private Long institution;
    @NotBlank(message = "{general.notEmpty}")
    private String street;
    @NotBlank(message = "{general.notEmpty}")
    private String city;
    @NotBlank(message = "{general.notEmpty}")
    @Pattern(regexp = "[0-9]{2}-[0-9]{3}", message = "{zipCode.correct}")
    private String zipCode;
    @NotNull(message = "{general.notEmpty}")
    @Future(message = "{date.correct}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate pickUpDate;
    @NotNull(message = "{general.notEmpty}")
    private LocalTime pickUpTime;
    @Size(max = 255, message = "{size.255}")
    private String pickUpComment;
    @NotBlank(message = "{general.notEmpty}")
    @Pattern(regexp = "\\+[0-9]{2,5} [0-9]{9}", message = "{phone.correct}")
    private String phoneNumber;
}