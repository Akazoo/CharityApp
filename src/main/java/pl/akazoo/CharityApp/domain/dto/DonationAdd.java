package pl.akazoo.CharityApp.domain.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class DonationAdd {

    @NotNull(message = "To pole nie może pozostać puste.")
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
    @NotNull(message = "To pole nie może pozostać puste.")
    @Future(message = "Data nie może być z przeszłości.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate pickUpDate;
    @NotNull(message = "To pole nie może pozostać puste.")
    private LocalTime pickUpTime;
    @Size(max = 255, message = "Maksymalna długość znaków to 255")
    private String pickUpComment;
    @NotBlank(message = "To pole nie może pozostać puste.")
    @Pattern(regexp = "\\+[0-9]{2,5} [0-9]{9}", message = "Poprawny format telefonu to to +xx xxxxxxxxx")
    private String phoneNumber;
}