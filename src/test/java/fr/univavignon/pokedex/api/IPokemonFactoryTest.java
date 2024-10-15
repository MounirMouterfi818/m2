/*package fr.univavignon.pokedex.api;

import org.mockito.Mockito.*;

//import org.junit.api.BeforeEach;
//import org.junit.Test;
import org.junit.Test;

public class IPokemonFactoryTest {

    
}
*/
package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class IPokemonFactoryTest {

    @Test
    public void createPokemonTest() {
        // Mocking IPokemonFactory
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

        // Defining the Pokemon parameters
        int index = 0;  // Example index for Bulbizarre
        int cp = 613;
        int hp = 64;
        int dust = 4000;
        int candy = 4;

        // Mocking the returned Pokemon instance
        Pokemon bulbizarre = new Pokemon(index, "Bulbizarre", 126, 126, 90, cp, hp, dust, candy, 56);

        // Define the behavior of createPokemon method when called with the parameters
        when(pokemonFactory.createPokemon(index, cp, hp, dust, candy)).thenReturn(bulbizarre);

        // Call the method with the parameters
        Pokemon createdPokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        // Assert that the created Pokemon is not null
        assertNotNull(createdPokemon);

        // Assert that the returned Pokemon has the correct attributes
        assertEquals(index, createdPokemon.getIndex());
        assertEquals("Bulbizarre", createdPokemon.getName());
        assertEquals(cp, createdPokemon.getCp());
        assertEquals(hp, createdPokemon.getHp());
        assertEquals(dust, createdPokemon.getDust());
        assertEquals(candy, createdPokemon.getCandy());

        // Verify that the createPokemon method was called with the correct parameters
        verify(pokemonFactory).createPokemon(index, cp, hp, dust, candy);
    }
}
