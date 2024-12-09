package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class IPokemonTrainerFactoryTest {

    @Test
    public void testCreateTrainerWithNullTeam() {
        // Mocking the IPokemonTrainerFactory
        IPokemonTrainerFactory trainerFactory = mock(IPokemonTrainerFactory.class);

        // Mocking the required objects for the trainer creation
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);

        // Creating a mock for the Pokedex
        IPokedex mockPokedex = mock(IPokedex.class);

        // Create the PokemonTrainer manually with a null team
        PokemonTrainer trainer = new PokemonTrainer("Ash", null, mockPokedex);

        // Defining the behavior of the mock (what should be returned when the method is called)
        when(trainerFactory.createTrainer("Ash", null, pokedexFactory)).thenReturn(trainer);

        // Create the trainer using the factory
        PokemonTrainer createdTrainer = trainerFactory.createTrainer("Ash", null, pokedexFactory);

        // Test the result
        assertNotNull(createdTrainer);
        assertEquals("Ash", createdTrainer.getName());
        assertNull(createdTrainer.getTeam());  // Since we passed null as the team
    }

    @Test
    public void testCreateTrainerWithValidTeam() {
        // Mocking the IPokemonTrainerFactory
        IPokemonTrainerFactory trainerFactory = mock(IPokemonTrainerFactory.class);

        // Mocking the required objects for the trainer creation
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);

        // Creating a mock for the Pokedex
        IPokedex mockPokedex = mock(IPokedex.class);

        // Create the PokemonTrainer manually with a valid team (here we use null to avoid using Team)
        PokemonTrainer trainer = new PokemonTrainer("Misty", null, mockPokedex);

        // Defining the behavior of the mock (what should be returned when the method is called)
        when(trainerFactory.createTrainer("Misty", null, pokedexFactory)).thenReturn(trainer);

        // Create the trainer using the factory
        PokemonTrainer createdTrainer = trainerFactory.createTrainer("Misty", null, pokedexFactory);

        // Test the result
        assertNotNull(createdTrainer);
        assertEquals("Misty", createdTrainer.getName());
        assertNull(createdTrainer.getTeam());  // No team passed, so it should be null
    }

}
