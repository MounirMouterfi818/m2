package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.*;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index < 0 || index >= 150) {
            throw new PokedexException("Invalid Pokémon index.");
        }
        return new PokemonMetadata(index, "Unknown", 50, 40, 35);
    }
}
