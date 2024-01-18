package com.zavoloka.PetClinic;

import com.zavoloka.PetClinic.model.Owner;
import com.zavoloka.PetClinic.model.Pet;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerTest {

    @InjectMocks
    private Owner owner;

    @Mock
    private Pet pet;

    @Test
    void addPet_shouldAddPetToOwner() {
        // Arrange
        when(pet.getOwner()).thenReturn(null);

        // Act
        owner.addPet(pet);

        // Assert
        assertTrue(owner.getPets().contains(pet));
        assertEquals(owner, pet.getOwner());
    }

    @Test
    void removePet_shouldRemovePetFromOwner() {
        // Arrange
        owner.getPets().add(pet);

        // Act
        owner.removePet(pet);

        // Assert
        assertFalse(owner.getPets().contains(pet));
        assertNull(pet.getOwner());
    }

    @Test
    void addPet_shouldNotAddPetIfAlreadyOwnedByAnotherOwner() {
        // Arrange
        Owner anotherOwner = new Owner();
        anotherOwner.setId(2L);
        when(pet.getOwner()).thenReturn(anotherOwner);

        // Act
        owner.addPet(pet);

        // Assert
        assertFalse(owner.getPets().contains(pet));
    }

    @Test
    void testHashCodeAndEquals() {
        // Arrange
        Owner owner1 = new Owner();
        owner1.setId(1L);

        Owner owner2 = new Owner();
        owner2.setId(1L);

        Owner owner3 = new Owner();
        owner3.setId(2L);

        // Assert
        assertEquals(owner1.hashCode(), owner2.hashCode());
        assertNotEquals(owner1.hashCode(), owner3.hashCode());

        assertEquals(owner1, owner2);
        assertNotEquals(owner1, owner3);
    }

    @Test
    void testToString() {
        // Arrange
        owner.setId(1L);
        owner.setFirstName("John");
        owner.setLastName("Doe");
        owner.setAddress("123 Main St");
        owner.setCity("City");
        owner.setTelephone("123-456-7890");

        // Act
        String toStringResult = owner.toString();

        // Assert
        assertTrue(toStringResult.contains("Owner [id=1, firstName=John, lastName=Doe, address=123 Main St, city=City, telephone=123-456-7890]"));
    }
}
