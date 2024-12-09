package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
        assertEquals(50, retrievedMetadata.getAttack());
        assertEquals(40, retrievedMetadata.getDefense());
        assertEquals(35, retrievedMetadata.getStamina());
    }

    @Test
    public void testGetPokemonMetadataWithInvalidIndex() throws PokedexException {
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);

        // Simuler le cas où l'index n'est pas valide
        when(metadataProvider.getPokemonMetadata(999)).thenThrow(new PokedexException("Invalid Pokémon index"));

        // Tester si une exception est lancée pour un index invalide
        PokedexException thrown = assertThrows(PokedexException.class, () -> {
            metadataProvider.getPokemonMetadata(999);
        });

        // Vérifier le message de l'exception
        assertEquals("Invalid Pokémon index", thrown.getMessage());
    }

    @Test
    public void testGetPokemonMetadataWithNullReturnValue() throws PokedexException {
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);

        // Simuler un cas où la méthode retourne null (par exemple, Pokémon non trouvé)
        when(metadataProvider.getPokemonMetadata(2)).thenReturn(null);

        // Tester si la méthode retourne null pour un Pokémon non trouvé
        PokemonMetadata retrievedMetadata = metadataProvider.getPokemonMetadata(2);
        assertNull(retrievedMetadata);
    }
}
