package com.zavoloka.PetClinic.repository;

import com.zavoloka.PetClinic.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
    // Custom query methods if needed
}