package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PokedexFactoryTest {

    @Test
    public void testCreatePokedex() {
        IPokedexFactory factory = new PokedexFactory();
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

        IPokedex pokedex = factory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(pokedex);
        assertEquals(0, pokedex.size());
    }
}
