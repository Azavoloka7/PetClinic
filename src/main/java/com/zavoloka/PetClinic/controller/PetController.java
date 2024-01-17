package com.zavoloka.PetClinic.controller;

import com.zavoloka.PetClinic.model.Pet;
import com.zavoloka.PetClinic.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public String listPets(Model model) {
        List<Pet> pets = petService.getAllPets();
        model.addAttribute("pets", pets);
        return "pets/listPets";
    }

    @GetMapping("/{petId}")
    public String showPet(@PathVariable Long petId, Model model) {
        Pet pet = petService.getPetById(petId);
        model.addAttribute("pet", pet);
        return "pets/showPet";
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("pet", new Pet());
        return "pets/createOrUpdatePetForm";
    }

    @PostMapping("/new")
    public String processCreationForm(@ModelAttribute("pet") Pet pet) {
        petService.savePet(pet);
        return "redirect:/pets/" + pet.getId();
    }

    @GetMapping("/{petId}/edit")
    public String initUpdateForm(@PathVariable Long petId, Model model) {
        Pet pet = petService.getPetById(petId);
        model.addAttribute("pet", pet);
        return "pets/createOrUpdatePetForm";
    }

    @PostMapping("/{petId}/edit")
    public String processUpdateForm(@ModelAttribute("pet") Pet pet, @PathVariable Long petId) {
        pet.setId(petId);
        petService.savePet(pet);
        return "redirect:/pets/" + pet.getId();
    }
}
