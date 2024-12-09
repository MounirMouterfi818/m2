package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class IPokedexFactoryTest {

    @Test
    public void testCreatePokedexSuccess() {
        // Mocks des dépendances
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        IPokedex mockPokedex = mock(IPokedex.class);

        // Simuler le comportement attendu
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(mockPokedex);

        // Appeler la méthode et vérifier le résultat
        IPokedex createdPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(createdPokedex, "Le Pokedex créé ne doit pas être nul.");

        // Vérifier que la méthode a été appelée correctement
        verify(pokedexFactory, times(1)).createPokedex(metadataProvider, pokemonFactory);
    }

    @Test
    public void testCreatePokedexWithNullDependencies() {
        // Mock de l'interface
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);

        // Configurer le mock pour qu'il lance une exception en cas de paramètres nuls
        when(pokedexFactory.createPokedex(null, null))
                .thenThrow(new NullPointerException("Les dépendances ne peuvent pas être nulles"));

        // Vérifier que l'exception est levée
        Exception exception = assertThrows(NullPointerException.class, () -> {
            pokedexFactory.createPokedex(null, null);
        });

        // Vérifier le message de l'exception
        assertEquals("Les dépendances ne peuvent pas être nulles", exception.getMessage());

        // Vérifier que la méthode a été appelée avec des paramètres nulls
        verify(pokedexFactory, times(1)).createPokedex(null, null);
    }


    @Test
    public void testCreatePokedexErrorHandling() {
        // Mocks des dépendances
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

        // Simuler un comportement inattendu (exception levée)
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory))
                .thenThrow(new IllegalStateException("Erreur simulée"));

        // Vérifier que l'exception est bien levée
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        });

        // Vérifier le message de l'exception
        assertEquals("Erreur simulée", exception.getMessage());
    }

    @Test
    public void testCreatePokedexMultipleCalls() {
        // Mocks des dépendances
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        IPokedex mockPokedex = mock(IPokedex.class);

        // Simuler le comportement attendu
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(mockPokedex);

        // Appeler plusieurs fois la méthode
        IPokedex createdPokedex1 = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        IPokedex createdPokedex2 = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        // Vérifier les résultats
        assertNotNull(createdPokedex1, "Le premier Pokedex créé ne doit pas être nul.");
        assertNotNull(createdPokedex2, "Le deuxième Pokedex créé ne doit pas être nul.");
        assertEquals(createdPokedex1, createdPokedex2, "Les deux Pokedex devraient être identiques (mock).");

        // Vérifier que la méthode a été appelée exactement deux fois
        verify(pokedexFactory, times(2)).createPokedex(metadataProvider, pokemonFactory);
    }
}
