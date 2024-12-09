package fr.univavignon.pokedex.api;


import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class IPokemonFactoryTest {

    @Test
    public void testCreatePokemon() {
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

        // Créer un Pokémon avec des valeurs arbitraires
        Pokemon mockPokemon = new Pokemon(1, "Pikachu", 50, 40, 35, 200, 50, 300, 25, 80.0);
        when(pokemonFactory.createPokemon(1, 200, 50, 300, 25)).thenReturn(mockPokemon);

        // Appeler la méthode createPokemon et tester
        Pokemon createdPokemon = pokemonFactory.createPokemon(1, 200, 50, 300, 25);
        assertNotNull(createdPokemon);
        assertEquals("Pikachu", createdPokemon.getName());
    }
}
