package com.zavoloka.PetClinic.repository;

import com.zavoloka.PetClinic.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {
    // Custom query methods if needed
}
