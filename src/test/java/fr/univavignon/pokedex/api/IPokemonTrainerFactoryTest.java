/*package fr.univavignon.pokedex.api;

//import org.mockito.Mockito.*;
import org.junit.Test;

 
public class IPokemonTrainerFactoryTest {

}*/
package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class IPokemonTrainerFactoryTest {

    @Test
    public void createTrainerTest() {
        // Mocking the dependencies
        IPokemonTrainerFactory trainerFactory = mock(IPokemonTrainerFactory.class);
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);

        // Defining trainer details
        String trainerName = "Ash";
        Team team = Team.MYSTIC; // Example of a team (can be INSTINCT, MYSTIC, or VALOR)

        // Mocking the PokemonTrainer instance
        PokemonTrainer ashTrainer = new PokemonTrainer(trainerName, team, pokedexFactory.createPokedex(null, null));

        // Defining the behavior of createTrainer
        when(trainerFactory.createTrainer(trainerName, team, pokedexFactory)).thenReturn(ashTrainer);

        // Call the createTrainer method
        PokemonTrainer trainer = trainerFactory.createTrainer(trainerName, team, pokedexFactory);

        // Assert that the trainer is not null
        assertNotNull(trainer);

        // Assert that the trainer has the correct name and team
        assertEquals(trainerName, trainer.getName());
        assertEquals(team, trainer.getTeam());

        // Verify that createTrainer was called with the correct parameters
        verify(trainerFactory).createTrainer(trainerName, team, pokedexFactory);
    }
}

