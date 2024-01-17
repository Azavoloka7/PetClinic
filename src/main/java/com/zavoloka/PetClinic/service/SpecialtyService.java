package com.zavoloka.PetClinic.service;

import com.zavoloka.PetClinic.model.Specialty;

import java.util.List;

public interface SpecialtyService {
    List<Specialty> getAllSpecialties();
    Specialty getSpecialtyById(Long specialtyId);
    void saveSpecialty(Specialty specialty);
    void deleteSpecialty(Long specialtyId);
    // Other service methods if needed
}
