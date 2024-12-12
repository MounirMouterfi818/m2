package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PokemonMetadataProviderTest {

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadataProvider provider = new PokemonMetadataProvider();
        PokemonMetadata metadata = provider.getPokemonMetadata(1);
        assertNotNull(metadata);
    }

    @Test
    public void testInvalidIndex() {
        PokemonMetadataProvider provider = new PokemonMetadataProvider();
        assertThrows(PokedexException.class, () -> provider.getPokemonMetadata(999));
    }
}
