package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class IPokemonMetadataProviderTest {

    @Test
    public void getPokemonMetadataTest() throws PokedexException {
        // Mocking IPokemonMetadataProvider
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);

        // Defining a valid index for the test (e.g., 0 for Bulbizarre)
        int index = 0;

        // Mocking the returned PokemonMetadata instance
        PokemonMetadata bulbizarreMetadata = new PokemonMetadata(index, "Bulbizarre", 126, 126, 90);

        // Defining the behavior of getPokemonMetadata when called with a valid index
        when(metadataProvider.getPokemonMetadata(index)).thenReturn(bulbizarreMetadata);

        // Call the method with the index
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);

        // Assert that the metadata is not null
        assertNotNull(metadata);

        // Assert that the metadata contains the correct information
        assertEquals(index, metadata.getIndex());
        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());

        // Verify that the getPokemonMetadata method was called with the correct index
        verify(metadataProvider).getPokemonMetadata(index);
    }

    @Test(expected = PokedexException.class)
    public void getPokemonMetadataInvalidIndexTest() throws PokedexException {
        // Mocking IPokemonMetadataProvider
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);

        // Defining an invalid index (e.g., negative or out of bounds)
        int invalidIndex = -1;

        // Defining the behavior of getPokemonMetadata to throw an exception for an invalid index
        when(metadataProvider.getPokemonMetadata(invalidIndex)).thenThrow(new PokedexException("Invalid index"));

        // Call the method with the invalid index and expect a PokedexException
        metadataProvider.getPokemonMetadata(invalidIndex);
    }
}
