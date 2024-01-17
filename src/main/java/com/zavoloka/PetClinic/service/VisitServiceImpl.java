package com.zavoloka.PetClinic.service;

import com.zavoloka.PetClinic.model.Visit;
import com.zavoloka.PetClinic.repository.VisitRepository;
import com.zavoloka.PetClinic.model.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitRepository visitRepository;

    @Override
    public List<Visit> getAllVisits() {
        return visitRepository.findAll();
    }

    @Override
    public Visit getVisitById(Long visitId) {
        return visitRepository.findById(visitId).orElse(null);
    }

    @Override
    public void saveVisit(Visit visit) {
        visitRepository.save(visit);
    }


    @Override
    public void deleteVisit(Long visitId) {
        visitRepository.deleteById(visitId);
    }

    // Other service methods implementation if needed
}
