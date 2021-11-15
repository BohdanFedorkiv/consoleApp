package com.app.console.models;

import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "head", referencedColumnName = "id")
    private Lector head;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Departments_Lectors",
            joinColumns = { @JoinColumn(name = "department_id") },
            inverseJoinColumns = { @JoinColumn(name = "lector_id") }
    )
    Set<Lector> lectors = new HashSet<>();
}
