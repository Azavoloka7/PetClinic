package com.zavoloka.PetClinic.controller;

import com.zavoloka.PetClinic.model.Visit;
import com.zavoloka.PetClinic.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/visits")
public class VisitController {

    @Autowired
    private VisitService visitService;

    @GetMapping
    public String listVisits(Model model) {
        List<Visit> visits = visitService.getAllVisits();
        model.addAttribute("visits", visits);
        return "visits/listVisits";
    }

    @GetMapping("/{visitId}")
    public String showVisit(@PathVariable Long visitId, Model model) {
        Visit visit = visitService.getVisitById(visitId);
        model.addAttribute("visit", visit);
        return "visits/showVisit";
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("visit", new Visit());
        return "visits/createOrUpdateVisitForm";
    }

    @PostMapping("/new")
    public String processCreationForm(@ModelAttribute("visit") Visit visit) {
        visitService.saveVisit(visit);
        return "redirect:/visits/" + visit.getId();
    }

    @GetMapping("/{visitId}/edit")
    public String initUpdateForm(@PathVariable Long visitId, Model model) {
        Visit visit = visitService.getVisitById(visitId);
        model.addAttribute("visit", visit);
        return "visits/createOrUpdateVisitForm";
    }

    @PostMapping("/{visitId}/edit")
    public String processUpdateForm(@ModelAttribute("visit") Visit visit, @PathVariable Long visitId) {
        visit.setId(visitId);
        visitService.saveVisit(visit);
        return "redirect:/visits/" + visit.getId();
    }
}
