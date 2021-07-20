package pl.akazoo.CharityApp.domain.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class DonationAdd {

    @NotNull(message = "Podana liczba musi być większa od 0.")
    private Integer quantity;
    @NotEmpty(message = "Wybierz jedna lub więcej kategorii.")
    private List<Long> categories;
    @NotNull(message = "Proszę wybrać instytucję.")
    private Long institution;
    @NotBlank(message = "To pole nie może pozostać puste.")
    private String street;
    @NotBlank(message = "To pole nie może pozostać puste.")
    private String city;
    @NotBlank(message = "To pole nie może pozostać puste.")
    @Pattern(regexp = "[0-9]{2}-[0-9]{3}", message = "Poprawny format kodu to xx-xxx")
    private String zipCode;
    @NotBlank(message = "To pole nie może pozostać puste.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate pickUpDate;
    @NotBlank(message = "To pole nie może pozostać puste.")
    private LocalTime localTime;
    private String pickUpComment;
}