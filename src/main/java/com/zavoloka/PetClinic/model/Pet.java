package com.zavoloka.PetClinic.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
//@Table(name = "pets")
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


    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate, owner);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pet pet = (Pet) obj;
        return Objects.equals(id, pet.id) &&
                Objects.equals(name, pet.name) &&
                Objects.equals(birthDate, pet.birthDate) &&
                Objects.equals(owner, pet.owner);
    }

    // Implementing toString
    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", owner=" + owner +
                '}';
    }
}
