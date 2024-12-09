package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class IPokemonFactoryTest {

    @Test
    public void testCreatePokemon() {
        // Créer un mock de IPokemonFactory
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

        // Créer un Pokémon avec des valeurs arbitraires
        Pokemon mockPokemon = new Pokemon(1, "Pikachu", 50, 40, 35, 200, 50, 300, 25, 80.0);

        // Définir le comportement de la méthode createPokemon du mock
        when(pokemonFactory.createPokemon(1, 200, 50, 300, 25)).thenReturn(mockPokemon);

        // Appeler la méthode createPokemon et tester
        Pokemon createdPokemon = pokemonFactory.createPokemon(1, 200, 50, 300, 25);

        // Vérifier que le Pokémon créé n'est pas null
        assertNotNull(createdPokemon);

        // Vérifier que les attributs du Pokémon créé sont corrects
        assertEquals("Pikachu", createdPokemon.getName());
        assertEquals(200, createdPokemon.getCp());
        assertEquals(50, createdPokemon.getHp());
        assertEquals(300, createdPokemon.getDust());
        assertEquals(25, createdPokemon.getCandy());
        assertEquals(80.0, createdPokemon.getIv());
    }

    @Test
    public void testCreatePokemonWithExtremeValues() {
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

        // Créer un Pokémon avec des valeurs extrêmes
        Pokemon mockPokemon = new Pokemon(1, "Pikachu", 100, 100, 100, 9999, 100, 1000, 100, 100.0);
        when(pokemonFactory.createPokemon(1, 9999, 100, 1000, 100)).thenReturn(mockPokemon);

        // Appeler la méthode createPokemon et tester
        Pokemon createdPokemon = pokemonFactory.createPokemon(1, 9999, 100, 1000, 100);

        // Vérifier que les valeurs extrêmes sont bien respectées
        assertNotNull(createdPokemon);
        assertEquals(9999, createdPokemon.getCp());
        assertEquals(100, createdPokemon.getHp());
        assertEquals(1000, createdPokemon.getDust());
        assertEquals(100, createdPokemon.getCandy());
        assertEquals(100.0, createdPokemon.getIv());
    }

    @Test
    public void testCreatePokemonWithZeroValues() {
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

        // Créer un Pokémon avec des valeurs à zéro
        Pokemon mockPokemon = new Pokemon(1, "Pikachu", 0, 0, 0, 0, 0, 0, 0, 0.0);
        when(pokemonFactory.createPokemon(1, 0, 0, 0, 0)).thenReturn(mockPokemon);

        // Appeler la méthode createPokemon et tester
        Pokemon createdPokemon = pokemonFactory.createPokemon(1, 0, 0, 0, 0);

        // Vérifier que le Pokémon créé a des valeurs à zéro
        assertNotNull(createdPokemon);
        assertEquals(0, createdPokemon.getCp());
        assertEquals(0, createdPokemon.getHp());
        assertEquals(0, createdPokemon.getDust());
        assertEquals(0, createdPokemon.getCandy());
        assertEquals(0.0, createdPokemon.getIv());
    }

    @Test
    public void testCreatePokemonVerifyMethodCall() {
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

        // Créer un Pokémon avec des valeurs arbitraires
        Pokemon mockPokemon = new Pokemon(1, "Pikachu", 50, 40, 35, 200, 50, 300, 25, 80.0);
        when(pokemonFactory.createPokemon(1, 200, 50, 300, 25)).thenReturn(mockPokemon);

        // Appeler la méthode createPokemon
        pokemonFactory.createPokemon(1, 200, 50, 300, 25);

        // Vérifier que la méthode a été appelée exactement une fois avec les bons paramètres
        verify(pokemonFactory, times(1)).createPokemon(1, 200, 50, 300, 25);
    }
}
