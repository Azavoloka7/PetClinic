package com.zavoloka.PetClinic.service;

import com.zavoloka.PetClinic.model.Vet;
import java.util.List;

public interface VetService {
    List<Vet> getAllVets();
    Vet getVetById(Long vetId);
    void saveVet(Vet vet);
    void deleteVet(Long vetId);
    // Other service methods if needed
}
