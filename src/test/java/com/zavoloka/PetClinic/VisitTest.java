package com.zavoloka.PetClinic;

import com.zavoloka.PetClinic.model.Pet;
import com.zavoloka.PetClinic.model.Visit;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VisitTest {

    @Test
    void testHashCodeAndEquals() {
        // Arrange
        Visit visit1 = new Visit();
        visit1.setId(1L);
        visit1.setDate(LocalDate.of(2022, 1, 1));
        visit1.setDescription("Regular checkup");

        Visit visit2 = new Visit();
        visit2.setId(1L);
        visit2.setDate(LocalDate.of(2022, 1, 1));
        visit2.setDescription("Regular checkup");

        Visit visitWithDifferentValues = new Visit();
        visitWithDifferentValues.setId(2L);
        visitWithDifferentValues.setDate(LocalDate.of(2022, 1, 2));
        visitWithDifferentValues.setDescription("Emergency visit");

        // Act & Assert
        assertEquals(visit1.hashCode(), visit2.hashCode());
        assertEquals(visit1, visit2);

        assertNotEquals(visit1.hashCode(), visitWithDifferentValues.hashCode());
        assertNotEquals(visit1, visitWithDifferentValues);
    }

    @Test
    void testToString() {
        // Arrange
        Visit visit = new Visit();
        visit.setId(1L);
        visit.setDate(LocalDate.of(2022, 1, 1));
        visit.setDescription("Regular checkup");

        // Act
        String toStringResult = visit.toString();

        // Assert
        assertTrue(toStringResult.contains("Visit{id=1, date=2022-01-01, description='Regular checkup', pet=null}"));
    }

    @Test
    void testSetPet() {
        // Arrange
        Visit visit = new Visit();
        visit.setId(1L);
        visit.setDate(LocalDate.of(2022, 1, 1));
        visit.setDescription("Regular checkup");

        Pet pet = new Pet();
        pet.setId(1L);
        pet.setName("Buddy");

        // Act
        visit.setPet(pet);

        // Assert
        assertEquals(pet, visit.getPet());
        assertTrue(pet.getVisits().contains(visit));
    }
}
