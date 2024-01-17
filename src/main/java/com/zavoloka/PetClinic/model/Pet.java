package com.zavoloka.PetClinic.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;


    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    // Constructors, getters, setters, hashCode, equals, and other methods
}
