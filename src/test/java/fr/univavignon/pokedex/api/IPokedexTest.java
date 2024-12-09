package fr.univavignon.pokedex.api;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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
        } catch (PokedexException e) {
            throw new RuntimeException(e);
        }
        when(pokedex.getPokemons()).thenReturn(List.of(pokemon));
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
    public void testGetPokemons() {
        // Tester la récupération de la liste des Pokémons
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertNotNull(pokemons);
        assertEquals(1, pokemons.size());
    }
}
