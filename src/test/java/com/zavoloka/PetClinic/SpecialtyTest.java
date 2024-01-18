package com.zavoloka.PetClinic;

import com.zavoloka.PetClinic.model.Specialty;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SpecialtyTest {

    @Test
    void testHashCodeAndEquals() {
        // Arrange
        Specialty specialty1 = new Specialty();
        specialty1.setId(1L);
        specialty1.setName("Surgery");

        Specialty specialty2 = new Specialty();
        specialty2.setId(1L);
        specialty2.setName("Surgery");

        Specialty specialtyWithDifferentValues = new Specialty();
        specialtyWithDifferentValues.setId(2L);
        specialtyWithDifferentValues.setName("Dentistry");

        // Act & Assert
        assertEquals(specialty1.hashCode(), specialty2.hashCode());
        assertEquals(specialty1, specialty2);

        assertNotEquals(specialty1.hashCode(), specialtyWithDifferentValues.hashCode());
        assertNotEquals(specialty1, specialtyWithDifferentValues);
    }

    @Test
    void testToString() {
        // Arrange
        Specialty specialty = new Specialty();
        specialty.setId(1L);
        specialty.setName("Surgery");

        // Act
        String toStringResult = specialty.toString();

        // Assert
        assertTrue(toStringResult.contains("Specialty{id=1, name='Surgery', specialties=[]}"));
    }

    @Test
    void testAddAndRemoveSpecialty() {
        // Arrange
        Specialty specialty1 = new Specialty();
        specialty1.setId(1L);
        specialty1.setName("Surgery");

        Specialty specialty2 = new Specialty();
        specialty2.setId(2L);
        specialty2.setName("Dentistry");

        Set<Specialty> specialties = new HashSet<>();
        specialties.add(specialty1);

        // Act
        specialty2.setSpecialties(specialties);

        // Assert
        assertTrue(specialty2.getSpecialties().contains(specialty1));

        // Act
        specialty2.getSpecialties().remove(specialty1);

        // Assert
        assertFalse(specialty2.getSpecialties().contains(specialty1));
    }
}
