import org.junit.Test;
import org.junit.Assert;

/**
 * 
 * @author Cameron
 * @version 10142016
 * tests the types
 */
public class PokemonTypeTest 
{
    
    /**
     * Tests the effectivity
     */
    @Test
    public void effectiveTest()
    {
        Assert.assertEquals("grass", PokemonType.FIRE.effectiveAgainst()
                .toString());
        Assert.assertEquals("water", PokemonType.FIRE.weakAgainst()
                .toString());
        
        Assert.assertEquals("water", PokemonType.GRASS.effectiveAgainst()
                .toString());
        Assert.assertEquals("fire", PokemonType.GRASS.weakAgainst()
                .toString());
        
        Assert.assertEquals("fire", PokemonType.WATER.effectiveAgainst()
                .toString());
        Assert.assertEquals("grass", PokemonType.WATER.weakAgainst()
                .toString());
    }

}
