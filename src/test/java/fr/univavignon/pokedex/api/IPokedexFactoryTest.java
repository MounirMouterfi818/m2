/*package fr.univavignon.pokedex.api;


import static org.mockito.Mockito.*;

//import org.junit.api.BeforeEach;
//import org.junit.api.Test;
import org.junit.Test;
public class IPokedexFactoryTest {

  
}
*/
package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class IPokedexFactoryTest {

    @Test
    public void createPokedexTest() {
        // Mocking IPokedexFactory
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);

        // Mocking dependencies of createPokedex method
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        IPokedex pokedex = mock(IPokedex.class);

        // Define the behavior of the createPokedex method when called with mocks
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);

        // Call the method with the mocked objects
        IPokedex createdPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        // Assert that the created pokedex is not null
        assertNotNull(createdPokedex);

        // Verify that the createPokedex method was called with the correct parameters
        verify(pokedexFactory).createPokedex(metadataProvider, pokemonFactory);
    }
}
