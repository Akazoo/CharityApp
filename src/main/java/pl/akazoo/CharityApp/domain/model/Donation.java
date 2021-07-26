package pl.akazoo.CharityApp.domain.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "donations")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer quantity;
    @ManyToMany
    private List<Category> categories = new ArrayList<>();
    @ManyToOne
    private Institution institution;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String zipCode;
    @Column(nullable = false)
    private LocalDate pickUpDate;
    @Column(nullable = false)
    private LocalTime pickUpTime;
    @Column
    private String pickUpComment;
    @Column(nullable = false)
    private String phoneNumber;
    @ManyToOne
    private User user;
}