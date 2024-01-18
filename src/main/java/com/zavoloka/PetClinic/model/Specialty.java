package com.zavoloka.PetClinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "specialties")
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "vet_specialties",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Specialty> specialties = new HashSet<>();

    // Constructors, getters, setters, and other methods

    // Implementing hashCode and equals
    @Override
    public int hashCode() {
        return Objects.hash(id, name, specialties);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Specialty specialty = (Specialty) obj;
        return Objects.equals(id, specialty.id) &&
                Objects.equals(name, specialty.name) &&
                Objects.equals(specialties, specialty.specialties);
    }

    // Implementing toString
    @Override
    public String toString() {
        return "Specialty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialties=" + specialties +
                '}';
    }

    // Constructors, getters, setters
    // ...

}

