package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RocketPokemonFactoryTest {

    private RocketPokemonFactory rocketPokemonFactory;

    @BeforeEach
    public void setUp() {
        rocketPokemonFactory = new RocketPokemonFactory();
    }

    @Test
    public void testCreatePokemonWithKnownIndex() {
        int index = 1; // Bulbasaur
        int cp = 500;
        int hp = 60;
        int dust = 3000;
        int candy = 3;

        Pokemon pokemon = rocketPokemonFactory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull(pokemon);
        assertEquals(index, pokemon.getIndex());
        assertEquals("Bulbasaur", pokemon.getName());
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());
        assertTrue(pokemon.getIv() >= 0.0 && pokemon.getIv() <= 1.0);
    }

    @Test
    public void testCreatePokemonWithUnknownIndex() {
        int index = 999; // Unknown index
        int cp = 400;
        int hp = 50;
        int dust = 2000;
        int candy = 2;

        Pokemon pokemon = rocketPokemonFactory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull(pokemon);
        assertEquals(index, pokemon.getIndex());
        assertEquals("MISSINGNO", pokemon.getName());
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());
        assertTrue(pokemon.getIv() >= 0.0 && pokemon.getIv() <= 1.0);
    }

    @Test
    public void testCreatePokemonWithNegativeIndex() {
        int index = -1; // Ash's Pikachu
        int cp = 800;
        int hp = 70;
        int dust = 4000;
        int candy = 5;

        Pokemon pokemon = rocketPokemonFactory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull(pokemon);
        assertEquals(index, pokemon.getIndex());
        assertEquals("Ash's Pikachu", pokemon.getName());
        assertEquals(1000, pokemon.getAttack());
        assertEquals(1000, pokemon.getDefense());
        assertEquals(1000, pokemon.getStamina());
        assertEquals(0.0, pokemon.getIv(), 0.0);
    }

    @Test
    public void testGenerateRandomStats() {
        // Ensure stats are generated within expected range
        int iterations = 100;
        for (int i = 0; i < iterations; i++) {
            Pokemon pokemon = rocketPokemonFactory.createPokemon(1, 500, 60, 3000, 3);
            assertTrue(pokemon.getAttack() >= 0 && pokemon.getAttack() <= 100);
            assertTrue(pokemon.getDefense() >= 0 && pokemon.getDefense() <= 100);
            assertTrue(pokemon.getStamina() >= 0 && pokemon.getStamina() <= 100);
        }
    }
}
