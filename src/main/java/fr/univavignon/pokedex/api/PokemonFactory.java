package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.*;

public class PokemonFactory implements IPokemonFactory {

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        double iv = Math.random() * 100;
        return new Pokemon(index, "Unknown", 0, 0, 0, cp, hp, dust, candy, iv);
    }
}
