package com.zavoloka.PetClinic.controller;

import com.zavoloka.PetClinic.model.Specialty;
import com.zavoloka.PetClinic.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/specialties")
public class SpecialtyController {

    private final SpecialtyService specialtyService;

    @Autowired
    public SpecialtyController(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @GetMapping
    public String listSpecialties(Model model) {
        List<Specialty> specialties = specialtyService.getAllSpecialties();
        model.addAttribute("specialties", specialties);
        return "specialties/listSpecialties";
    }

    @GetMapping("/{specialtyId}")
    public String showSpecialty(@PathVariable Long specialtyId, Model model) {
        Specialty specialty = specialtyService.getSpecialtyById(specialtyId);
        model.addAttribute("specialty", specialty);
        return "specialties/showSpecialty";
    }

    @GetMapping("/new")
    public String initCreationForm(@org.jetbrains.annotations.NotNull Model model) {
        model.addAttribute("specialty", new Specialty());
        return "specialties/createOrUpdateSpecialtyForm";
    }

    @PostMapping("/new")
    public String processCreationForm(@ModelAttribute("specialty") Specialty specialty) {
        specialtyService.saveSpecialty(specialty);
        return "redirect:/specialties/" + specialty.getId();
    }

    @GetMapping("/{specialtyId}/edit")
    public String initUpdateForm(@PathVariable Long specialtyId, Model model) {
        Specialty specialty = specialtyService.getSpecialtyById(specialtyId);
        model.addAttribute("specialty", specialty);
        return "specialties/createOrUpdateSpecialtyForm";
    }

    @PostMapping("/{specialtyId}/edit")
    public String processUpdateForm(@ModelAttribute("specialty") Specialty specialty, @PathVariable Long specialtyId) {
        specialty.setId(specialtyId);
        specialtyService.saveSpecialty(specialty);
        return "redirect:/specialties/" + specialty.getId();
    }

    @GetMapping("/{specialtyId}/delete")
    public String deleteSpecialty(@PathVariable Long specialtyId) {
        specialtyService.deleteSpecialty(specialtyId);
        return "redirect:/specialties";
    }
}
