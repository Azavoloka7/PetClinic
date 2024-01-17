package com.zavoloka.PetClinic.service;

import com.zavoloka.PetClinic.model.Pet;
import com.zavoloka.PetClinic.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPetById(Long petId) {
        return petRepository.findById(petId).orElse(null);
    }

    @Override
    public void savePet(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    public void deletePet(Long petId) {
        petRepository.deleteById(petId);
    }

    // Other service methods implementation if needed
}
