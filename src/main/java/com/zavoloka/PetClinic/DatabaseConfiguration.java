package com.zavoloka.PetClinic;

import com.zavoloka.PetClinic.model.Pet;
import com.zavoloka.PetClinic.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseConfiguration {

    @Autowired
    private PetRepository petRepository;

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            List<Pet> pets = petRepository.findAll();
            pets.forEach(pet -> System.out.println("Pet Name: " + pet.getName()));
        };
    }
}
