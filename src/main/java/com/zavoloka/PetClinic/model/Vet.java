package com.zavoloka.PetClinic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table (name = "vets")
public class Vet {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Specialty> specialties = new HashSet<>();

    // Constructors, getters, setters

    // Add convenience methods for adding/removing specialties as needed

    public void addSpecialty(Specialty specialty) {
        specialties.add(specialty);
        specialty.getVets().add(this);
    }

    public void removeSpecialty(Specialty specialty) {
        specialties.remove(specialty);
        specialty.getVets().remove(this);
    }

    // Implementing hashCode and equals
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, specialties);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vet vet = (Vet) obj;
        return Objects.equals(id, vet.id) &&
                Objects.equals(firstName, vet.firstName) &&
                Objects.equals(lastName, vet.lastName) &&
                Objects.equals(specialties, vet.specialties);
    }

    // Implementing toString
    @Override
    public String toString() {
        return "Vet{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialties=" + specialties +
                '}';
    }
}
