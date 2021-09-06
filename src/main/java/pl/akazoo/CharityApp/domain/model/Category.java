package pl.akazoo.CharityApp.domain.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Category{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, unique = true, nullable = false)
    private String name;
}