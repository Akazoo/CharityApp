package pl.akazoo.CharityApp.domain.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "institutions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, unique = true, nullable = false)
    private String name;
    @Column(length = 100)
    private String description;
}