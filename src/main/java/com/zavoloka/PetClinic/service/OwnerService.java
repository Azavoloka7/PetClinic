package com.zavoloka.PetClinic.service;

import com.zavoloka.PetClinic.model.Owner;

import java.util.List;

public interface OwnerService {
    List<Owner> getAllOwners();

    Owner getOwnerById(Long ownerId);

    void saveOwner(Owner owner);

    void deleteOwner(Long ownerId);
}
