/**
 * 
 * @author Cameron
 * @version 10142016
 * Pokemon information class
 */
public class PokemonInfo {

    /**the nature of the pokemon*/
    private Nature nature;
    
    /**the type of the pokemon*/
    private PokemonType pokemonType;
    
    /**
     * 
     * @param nature of the pokemon
     * @param pokemonType of the pokemon
     */
    public PokemonInfo(Nature nature, PokemonType pokemonType)
    {
        this.nature = nature;
        this.pokemonType = pokemonType;
    }
    
    /**
     * @return String for nature
     */
    public Nature getNature()
    {
        return nature;
    }
    
    /**
     * @return PokemonType of the pokemon
     */
    public PokemonType getPokemonType()
    {
        return pokemonType;
    }
    
    /**
     * @return String with nature and type
     */
    public String toString()
    {
        return String.format("a %s %s type", nature, pokemonType);
    }
    
}
