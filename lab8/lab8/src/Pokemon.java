/**
 * 
 * @author Cameron
 * @version 10142016
 * Pokemon descriptions
 */
public enum Pokemon {
    
    /**
     * Bulbasaur.
     */
    BULBASAUR (new PokemonInfo(Nature.RELAXED, PokemonType.GRASS)),

    /**
     * Charmander.
     */
    CHARMANDER (new PokemonInfo(Nature.BRAVE, PokemonType.FIRE)),

    /**
     * Squirtle.
     */
    SQUIRTLE (new PokemonInfo(Nature.QUIET, PokemonType.WATER));
    
    /**the information on the pokemon*/
    private PokemonInfo info;
    
    /**
     * Constructor
     * @param info PokemonInfo for pokemon
     */
    private Pokemon(PokemonInfo info)
    {
        this.info = info;
    }
    
    /**
     * 
     * @return Nature
     */
    public Nature getNature()
    {
        return info.getNature();
    }
    
    /**
     * 
     * @return Nature
     */
    public PokemonType getPokemonType()
    {
        return info.getPokemonType();
    }
    
    /**
     * @return the formatted string
     */
    public String toString()
    {
        char[] formatName = name().toLowerCase().toCharArray();
        formatName[0] = Character.toUpperCase(formatName[0]);
        
        String properName = new String(formatName);
        
        return (String.format("%s: %s", properName, info));
    }

}
