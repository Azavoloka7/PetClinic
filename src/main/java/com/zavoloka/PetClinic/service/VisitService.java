package com.zavoloka.PetClinic.service;

import com.zavoloka.PetClinic.model.Visit;

import java.util.List;

public interface VisitService {
    List<Visit> getAllVisits();
    Visit getVisitById(Long visitId);
    void saveVisit(Visit visit);
    void deleteVisit(Long visitId);
    // Other service methods if needed
}
