package com.zavoloka.PetClinic;

import com.zavoloka.PetClinic.model.Owner;
import com.zavoloka.PetClinic.model.Pet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PetTest {

    @InjectMocks
    private Pet pet;

    @Mock
    private Owner owner;

    @Test
    void testHashCodeAndEquals() {
        // Arrange
        pet.setId(1L);
        pet.setName("Fido");
        pet.setBirthDate(LocalDate.of(2020, 1, 1));
        pet.setOwner(owner);

        Pet anotherPetWithSameValues = new Pet();
        anotherPetWithSameValues.setId(1L);
        anotherPetWithSameValues.setName("Fido");
        anotherPetWithSameValues.setBirthDate(LocalDate.of(2020, 1, 1));
        anotherPetWithSameValues.setOwner(owner);

        Pet petWithDifferentValues = new Pet();
        petWithDifferentValues.setId(2L);
        petWithDifferentValues.setName("Buddy");
        petWithDifferentValues.setBirthDate(LocalDate.of(2021, 1, 1));
        petWithDifferentValues.setOwner(new Owner());

        // Assert
        assertEquals(pet.hashCode(), anotherPetWithSameValues.hashCode());
        assertNotEquals(pet.hashCode(), petWithDifferentValues.hashCode());

        assertEquals(pet, anotherPetWithSameValues);
        assertNotEquals(pet, petWithDifferentValues);
    }

    @Test
    void testToString() {
        // Arrange
        pet.setId(1L);
        pet.setName("Fido");
        pet.setBirthDate(LocalDate.of(2020, 1, 1));
        pet.setOwner(owner);

        // Act
        String toStringResult = pet.toString();

        // Assert
        assertTrue(toStringResult.contains("Pet{id=1, name='Fido', birthDate=2020-01-01, owner=" + owner + "}"));
    }
}
