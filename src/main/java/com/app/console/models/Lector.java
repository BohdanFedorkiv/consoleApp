package com.app.console.models;

import lombok.*;
import javax.persistence.*;
import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Table(name = "lectors")
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "degree")
    @Enumerated(EnumType.STRING)
    private Degree degree;

    @ManyToMany(mappedBy = "lectors")
    private Set<Department> departments = new HashSet<>();
}
