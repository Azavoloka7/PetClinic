package com.zavoloka.PetClinic;

import com.zavoloka.PetClinic.model.Pet;
import com.zavoloka.PetClinic.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@EntityScan(basePackages = "com.zavoloka.PetClinic.model")
@SpringBootApplication
public class PetClinicApplication implements CommandLineRunner {

    @Autowired
    private PetRepository petRepository;

    public static void main(String[] args) {
        SpringApplication.run(PetClinicApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // Display all pets in the console
        List<Pet> pets = petRepository.findAll();
        pets.forEach(pet -> System.out.println("Pet Name: " + pet.getName()));
    }
}
