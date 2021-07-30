package pl.akazoo.CharityApp.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column
    private String accountConfirmation;
    @Column(nullable = false)
    private String role;
    @Column
    private LocalDate creationDate;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column
    private String activationToken;
    @Column
    private LocalDate tokenExpireDate;

    @PrePersist
    public void setCreationDate(){
        this.creationDate = LocalDate.now();
    }
}