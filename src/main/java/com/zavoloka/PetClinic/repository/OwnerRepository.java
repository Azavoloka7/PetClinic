package com.zavoloka.PetClinic.repository;

import com.zavoloka.PetClinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    // Custom query methods if needed
}