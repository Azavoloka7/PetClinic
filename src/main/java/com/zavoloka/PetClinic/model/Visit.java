package com.zavoloka.PetClinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "visits")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    // Constructors

    public Visit() {
        // Default constructor
    }

    public Visit(LocalDate date, String description, Pet pet) {
        this.date = date;
        this.description = description;
        this.pet = pet;
    }

    // Getters, setters

    // Implementing hashCode and equals
    @Override
    public int hashCode() {
        return Objects.hash(id, date, description, pet);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Visit visit = (Visit) obj;
        return Objects.equals(id, visit.id) &&
                Objects.equals(date, visit.date) &&
                Objects.equals(description, visit.description) &&
                Objects.equals(pet, visit.pet);
    }

    // Implementing toString
    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", pet=" + pet +
                '}';
    }
}
