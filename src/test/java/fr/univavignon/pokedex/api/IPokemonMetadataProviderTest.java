package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);

        // Créer des métadonnées pour un Pokémon
        PokemonMetadata metadata = new PokemonMetadata(1, "Pikachu", 50, 40, 35);
        when(metadataProvider.getPokemonMetadata(1)).thenReturn(metadata);

        // Tester la méthode
        PokemonMetadata retrievedMetadata = metadataProvider.getPokemonMetadata(1);
        assertNotNull(retrievedMetadata);
        assertEquals("Pikachu", retrievedMetadata.getName());
    }
}
