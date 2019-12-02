import java.util.HashMap;

/**
 * Lab 8
 *
 * An enumeration containing a subset of the possible
 * types that a Pokemon can have.
 *
 * @author Nicholas
 * @version 2016-10-08
 */
public enum PokemonType
{
    /**
     * The Fire type.
     */
    FIRE,

    /**
     * The Grass type.
     */
    GRASS,

    /**
     * The Water type.
     */
    WATER;

    /**
     * Maps a PokemonType to the PokemonType that it is strong against.
     */
    private static final HashMap<PokemonType, PokemonType> STRENGTH_MAP;

    /**
     * Maps a PokemonType to the PokemonType that it is weak against.
     */
    private static final HashMap<PokemonType, PokemonType> WEAKNESS_MAP;

    /**
     * Initialized only once
     */
    static
    {
        WEAKNESS_MAP = new HashMap<PokemonType, PokemonType>();
        STRENGTH_MAP = new HashMap<PokemonType, PokemonType>();
        
        STRENGTH_MAP.put(GRASS, WATER);
        STRENGTH_MAP.put(WATER, FIRE);
        STRENGTH_MAP.put(FIRE, GRASS);
        
        WEAKNESS_MAP.put(FIRE, WATER);
        WEAKNESS_MAP.put(GRASS, FIRE);
        WEAKNESS_MAP.put(WATER, GRASS);
    }

    /**
     * Method that gives the type that this type is strong against.
     *
     * @return The PokemonType that this type is strong against.
     */
    public PokemonType effectiveAgainst()
    {
        return STRENGTH_MAP.get(this);
    }

    /**
     * Method that gives the type that this type is weak against.
     *
     * @return The PokemonType that this type is weak against.
     */
    public PokemonType weakAgainst()
    {
        return WEAKNESS_MAP.get(this);
    }

    /**
     * @return lowercase name
     */
    @Override
    public String toString()
    {
        return name().toLowerCase();
    }
}
