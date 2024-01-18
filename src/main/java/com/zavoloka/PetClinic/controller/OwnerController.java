package com.zavoloka.PetClinic.controller;

import com.zavoloka.PetClinic.model.Owner;
import com.zavoloka.PetClinic.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public String listOwners(Model model) {
        List<Owner> owners = ownerService.getAllOwners();
        model.addAttribute("owners", owners);
        return "owners/listOwners";
    }

    @GetMapping("/{ownerId}")
    public String showOwner(@PathVariable Long ownerId, Model model) {
        Owner owner = ownerService.getOwnerById(ownerId);
        model.addAttribute("owner", owner);
        return "owners/showOwner";
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("owner", new Owner());
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/new")
    public String processCreationForm(@ModelAttribute("owner") Owner owner) {
        ownerService.saveOwner(owner);
        return "redirect:/owners/" + owner.getId();
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateForm(@PathVariable Long ownerId, Model model) {
        Owner owner = ownerService.getOwnerById(ownerId);
        model.addAttribute("owner", owner);
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateForm(@ModelAttribute("owner") Owner owner, @PathVariable Long ownerId) {
        owner.setId(ownerId);
        ownerService.saveOwner(owner);
        return "redirect:/owners/" + owner.getId();
    }
}
