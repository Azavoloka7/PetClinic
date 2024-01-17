package com.zavoloka.PetClinic.repository;

import com.zavoloka.PetClinic.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
    // Custom query methods if needed
}