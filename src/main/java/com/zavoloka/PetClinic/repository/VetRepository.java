package com.zavoloka.PetClinic.repository;

import com.zavoloka.PetClinic.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Vet, Long> {
    // Custom query methods if needed
}
