package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PokemonFactoryTest {

    @Test
    public void testCreatePokemon() {
        PokemonFactory factory = new PokemonFactory();
        Pokemon pokemon = factory.createPokemon(1, 200, 100, 3000, 25);
        assertNotNull(pokemon);
        assertEquals(200, pokemon.getCp());
    }
}
