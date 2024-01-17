package com.zavoloka.PetClinic.service;

import com.zavoloka.PetClinic.model.Pet;

import java.util.List;

public interface PetService {
    List<Pet> getAllPets();
    Pet getPetById(Long petId);
    void savePet(Pet pet);
    void deletePet(Long petId);
    // Other service methods if needed
}
