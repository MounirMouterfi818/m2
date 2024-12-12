package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PokedexFactoryTest {

    private IPokedexFactory factory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setUp() {
        factory = new PokedexFactory();
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = new PokemonFactory(); // Utilise la classe réelle
    }

    @Test
    public void testCreatePokedex() {
        IPokedex pokedex = factory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(pokedex, "Pokedex should not be null.");
        assertEquals(0, pokedex.size(), "Newly created Pokedex should be empty.");
    }

    @Test
    public void testPokedexWithValidMetadataProvider() throws PokedexException {
        when(metadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbasaur", 126, 126, 90));

        IPokedex pokedex = factory.createPokedex(metadataProvider, pokemonFactory);
        PokemonMetadata metadata = pokedex.getPokemonMetadata(0);

        assertNotNull(metadata, "Metadata should not be null.");
        assertEquals("Bulbasaur", metadata.getName(), "Metadata name should match.");
        assertEquals(126, metadata.getAttack(), "Metadata attack should match.");
    }

    @Test
    public void testPokedexWithValidPokemonFactory() {
        IPokedex pokedex = factory.createPokedex(metadataProvider, pokemonFactory);
        Pokemon pokemon = pokedex.createPokemon(0, 500, 200, 3000, 3);

        assertNotNull(pokemon, "Pokemon should not be null.");
        assertEquals(0, pokemon.getIndex(), "Pokemon index should match.");
        assertEquals(500, pokemon.getCp(), "Pokemon CP should match.");
        assertEquals(200, pokemon.getHp(), "Pokemon HP should match.");
        assertEquals(3000, pokemon.getDust(), "Pokemon dust should match.");
        assertEquals(3, pokemon.getCandy(), "Pokemon candy should match.");
        assertTrue(pokemon.getIv() >= 0 && pokemon.getIv() <= 100, "Pokemon IV should be between 0 and 100.");
    }

    @Test
    public void testPokedexAddAndRetrievePokemon() throws PokedexException {
        IPokedex pokedex = factory.createPokedex(metadataProvider, pokemonFactory);

        Pokemon pokemon = new Pokemon(1, "Ivysaur", 600, 250, 4000, 4000, 4, 150, 120, 95.0);
        int index = pokedex.addPokemon(pokemon);

        assertEquals(0, index, "The index of the first added Pokemon should be 0.");
        assertEquals(1, pokedex.size(), "Pokedex size should be 1 after adding a Pokemon.");
        assertEquals(pokemon, pokedex.getPokemon(0), "Retrieved Pokemon should match the added Pokemon.");
    }



    @Test
    public void testPokedexWithMultiplePokemon() throws PokedexException {
        IPokedex pokedex = factory.createPokedex(metadataProvider, pokemonFactory);

        Pokemon p1 = new Pokemon(1, "Ivysaur", 600, 250, 4000, 4000, 4, 150, 120, 95.0);
        Pokemon p2 = new Pokemon(2, "Venusaur", 800, 300, 5000, 5000, 5, 200, 160, 99.0);

        pokedex.addPokemon(p1);
        pokedex.addPokemon(p2);

        assertEquals(2, pokedex.size(), "Pokedex size should be 2 after adding two Pokemon.");
        assertEquals(p1, pokedex.getPokemon(0), "First Pokemon should match.");
        assertEquals(p2, pokedex.getPokemon(1), "Second Pokemon should match.");
    }

    @Test
    public void testPokedexSortPokemon() {
        IPokedex pokedex = factory.createPokedex(metadataProvider, pokemonFactory);

        Pokemon p1 = new Pokemon(1, "Ivysaur", 600, 250, 4000, 4000, 4, 150, 120, 95.0);
        Pokemon p2 = new Pokemon(2, "Venusaur", 800, 300, 5000, 5000, 5, 200, 160, 99.0);
        Pokemon p3 = new Pokemon(0, "Bulbasaur", 400, 200, 3000, 3000, 3, 100, 80, 90.0);

        pokedex.addPokemon(p1);
        pokedex.addPokemon(p2);
        pokedex.addPokemon(p3);

        var sortedByName = pokedex.getPokemons((p1_, p2_) -> p1_.getName().compareTo(p2_.getName()));

        assertEquals("Bulbasaur", sortedByName.get(0).getName(), "First Pokemon should be Bulbasaur when sorted by name.");
        assertEquals("Ivysaur", sortedByName.get(1).getName(), "Second Pokemon should be Ivysaur when sorted by name.");
        assertEquals("Venusaur", sortedByName.get(2).getName(), "Third Pokemon should be Venusaur when sorted by name.");
    }
}
