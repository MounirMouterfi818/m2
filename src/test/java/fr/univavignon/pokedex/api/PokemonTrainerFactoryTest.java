package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PokemonTrainerFactoryTest {

    @Test
    public void testCreateTrainer() {
        PokemonTrainerFactory factory = new PokemonTrainerFactory();
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);

        PokemonTrainer trainer = factory.createTrainer("Ash", Team.MYSTIC, pokedexFactory);
        assertNotNull(trainer);
        assertEquals("Ash", trainer.getName());
    }
}
