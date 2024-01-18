package com.zavoloka.PetClinic;

import com.zavoloka.PetClinic.model.Specialty;
import com.zavoloka.PetClinic.model.Vet;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VetTest {

    @Test
    void testHashCodeAndEquals() {
        // Arrange
        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("John");
        vet1.setLastName("Doe");

        Vet vet2 = new Vet();
        vet2.setId(1L);
        vet2.setFirstName("John");
        vet2.setLastName("Doe");

        Vet vetWithDifferentValues = new Vet();
        vetWithDifferentValues.setId(2L);
        vetWithDifferentValues.setFirstName("Jane");
        vetWithDifferentValues.setLastName("Smith");

        // Act & Assert
        assertEquals(vet1.hashCode(), vet2.hashCode());
        assertEquals(vet1, vet2);

        assertNotEquals(vet1.hashCode(), vetWithDifferentValues.hashCode());
        assertNotEquals(vet1, vetWithDifferentValues);
    }

    @Test
    void testToString() {
        // Arrange
        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("John");
        vet.setLastName("Doe");

        // Act
        String toStringResult = vet.toString();

        // Assert
        assertTrue(toStringResult.contains("Vet{id=1, firstName='John', lastName='Doe', specialties=[]}"));
    }

    @Test
    void testAddAndRemoveSpecialty() {
        // Arrange
        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("John");
        vet.setLastName("Doe");

        Specialty surgery = new Specialty();
        surgery.setId(1L);
        surgery.setName("Surgery");

        Specialty dentistry = new Specialty();
        dentistry.setId(2L);
        dentistry.setName("Dentistry");

        Set<Specialty> specialties = new HashSet<>();
        specialties.add(surgery);

        // Act
        vet.setSpecialties(specialties);

        // Assert
        assertTrue(vet.getSpecialties().contains(surgery));

        // Act
        vet.getSpecialties().add(dentistry);

        // Assert
        assertTrue(vet.getSpecialties().contains(dentistry));

        // Act
        vet.getSpecialties().remove(surgery);

        // Assert
        assertFalse(vet.getSpecialties().contains(surgery));
    }
}
