package com.zavoloka.PetClinic.controller;

import com.zavoloka.PetClinic.model.Vet;
import com.zavoloka.PetClinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vets")
public class VetController {

    private final VetService vetService;

    @Autowired
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping
    public String listVets(Model model) {
        List<Vet> vets = vetService.getAllVets();
        model.addAttribute("vets", vets);
        return "vets/listVets";
    }

    @GetMapping("/{vetId}")
    public String showVet(@PathVariable Long vetId, Model model) {
        Vet vet = vetService.getVetById(vetId);
        model.addAttribute("vet", vet);
        return "vets/showVet";
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("vet", new Vet());
        return "vets/createOrUpdateVetForm";
    }

    @PostMapping("/new")
    public String processCreationForm(@ModelAttribute("vet") Vet vet) {
        vetService.saveVet(vet);
        return "redirect:/vets/" + vet.getId();
    }

    @GetMapping("/{vetId}/edit")
    public String initUpdateForm(@PathVariable Long vetId, Model model) {
        Vet vet = vetService.getVetById(vetId);
        model.addAttribute("vet", vet);
        return "vets/createOrUpdateVetForm";
    }

    @PostMapping("/{vetId}/edit")
    public String processUpdateForm(@ModelAttribute("vet") Vet vet, @PathVariable Long vetId) {
        vet.setId(vetId);
        vetService.saveVet(vet);
        return "redirect:/vets/" + vet.getId();
    }

    @GetMapping("/{vetId}/delete")
    public String deleteVet(@PathVariable Long vetId) {
        vetService.deleteVet(vetId);
        return "redirect:/vets";
    }
}
