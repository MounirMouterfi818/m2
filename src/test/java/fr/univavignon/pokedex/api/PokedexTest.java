package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PokedexTest {

    private Pokedex pokedex;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setUp() {
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
        pokedex = new Pokedex(metadataProvider, pokemonFactory);
    }

    @Test
    public void testAddPokemon() {
        Pokemon pokemon = new Pokemon(1, "Pikachu", 50, 40, 35, 200, 50, 300, 25, 80.0);
        int index = pokedex.addPokemon(pokemon);
        assertEquals(0, index);
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon pokemon = new Pokemon(1, "Pikachu", 50, 40, 35, 200, 50, 300, 25, 80.0);
        pokedex.addPokemon(pokemon);
        Pokemon retrieved = pokedex.getPokemon(0);
        assertEquals("Pikachu", retrieved.getName());
    }

    @Test
    public void testGetPokemonThrowsException() {
        assertThrows(PokedexException.class, () -> pokedex.getPokemon(999));
    }

    @Test
    public void testGetPokemons() {
        assertTrue(pokedex.getPokemons().isEmpty());
    }

    @Test
    public void testGetPokemonsWithComparator() {
        Pokemon p1 = new Pokemon(1, "Bulbasaur", 50, 40, 35, 200, 50, 300, 25, 70.0);
        Pokemon p2 = new Pokemon(2, "Charmander", 60, 50, 45, 300, 60, 400, 35, 90.0);
        pokedex.addPokemon(p1);
        pokedex.addPokemon(p2);

        List<Pokemon> sorted = pokedex.getPokemons(Comparator.comparing(Pokemon::getName));
        assertEquals("Bulbasaur", sorted.get(0).getName());
    }
}
