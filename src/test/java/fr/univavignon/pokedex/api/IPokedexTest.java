package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IPokedexTest {

    private IPokedex pokedex;
    private Pokemon pokemon;

    @BeforeEach
    public void setUp() {
        // Créez un mock de IPokedex
        pokedex = Mockito.mock(IPokedex.class);

        // Créez un objet Pokemon pour les tests
        pokemon = new Pokemon(1, "Pikachu", 50, 40, 35, 200, 50, 300, 25, 80.0);

        // Définir le comportement de certains mocks
        when(pokedex.size()).thenReturn(1);
        when(pokedex.addPokemon(any(Pokemon.class))).thenReturn(1);
        try {
            when(pokedex.getPokemon(1)).thenReturn(pokemon);
            when(pokedex.getPokemon(999)).thenThrow(new PokedexException("Invalid Pokémon index."));
        } catch (PokedexException e) {
            throw new RuntimeException(e);
        }
        when(pokedex.getPokemons()).thenReturn(List.of(pokemon));
        when(pokedex.getPokemons(any(Comparator.class))).thenAnswer(invocation -> {
            Comparator<Pokemon> comparator = invocation.getArgument(0);
            List<Pokemon> mutableList = new ArrayList<>(List.of(pokemon)); // Liste mutable
            mutableList.sort(comparator); // Tri sur la liste mutable
            return mutableList;
        });
    }


    @Test
    public void testSize() {
        // Tester la taille du Pokedex
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        // Ajouter un Pokémon et tester l'index retourné
        int index = pokedex.addPokemon(pokemon);
        assertEquals(1, index);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        // Récupérer un Pokémon par son index et tester ses propriétés
        Pokemon retrievedPokemon = pokedex.getPokemon(1);
        assertNotNull(retrievedPokemon);
        assertEquals("Pikachu", retrievedPokemon.getName());
    }

    @Test
    public void testGetPokemonThrowsException() {
        // Vérifier qu'une exception est levée pour un index invalide
        Exception exception = assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(999);
        });
        assertEquals("Invalid Pokémon index.", exception.getMessage());
    }

    @Test
    public void testGetPokemons() {
        // Tester la récupération de la liste des Pokémons
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertNotNull(pokemons);
        assertEquals(1, pokemons.size());
    }

    @Test
    public void testGetPokemonsWithComparator() {
        // Tester la récupération triée des Pokémons
        Comparator<Pokemon> comparator = Comparator.comparing(Pokemon::getName);
        List<Pokemon> sortedPokemons = pokedex.getPokemons(comparator);
        assertNotNull(sortedPokemons);
        assertEquals(1, sortedPokemons.size());
        assertEquals("Pikachu", sortedPokemons.get(0).getName());
    }

    @Test
    public void testEmptyPokedex() {
        // Simuler un Pokedex vide
        when(pokedex.size()).thenReturn(0);
        when(pokedex.getPokemons()).thenReturn(List.of());

        assertEquals(0, pokedex.size());
        assertTrue(pokedex.getPokemons().isEmpty());
    }
}
