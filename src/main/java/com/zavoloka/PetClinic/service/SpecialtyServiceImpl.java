package com.zavoloka.PetClinic.service;

import com.zavoloka.PetClinic.model.Specialty;
import com.zavoloka.PetClinic.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Override
    public List<Specialty> getAllSpecialties() {
        return specialtyRepository.findAll();
    }

    @Override
    public Specialty getSpecialtyById(Long specialtyId) {
        return specialtyRepository.findById(specialtyId).orElse(null);
    }

    @Override
    public void saveSpecialty(Specialty specialty) {
        specialtyRepository.save(specialty);
    }

    @Override
    public void deleteSpecialty(Long specialtyId) {
        specialtyRepository.deleteById(specialtyId);
    }

    // Other service methods implementation if needed
}
