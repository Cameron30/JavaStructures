import org.junit.Test;
import org.junit.Assert;

/**
 * 
 * @author Cameron
 * @version 10142016
 * tests pokemon
 */
public class PokemonTest 
{

    /**
     * Tests the to strings
     */
    @Test
    public void toStringTest()
    {
        Assert.assertEquals(Pokemon.BULBASAUR.toString(), "Bulbasaur: a "
                + "relaxed grass type");
        
        Assert.assertEquals(Pokemon.CHARMANDER.toString(), "Charmander: a "
                + "brave fire type");
        
        Assert.assertEquals(Pokemon.SQUIRTLE.toString(), "Squirtle: a "
                + "quiet water type");
    }
    
    /**
     * tests the information
     */
    @Test
    public void infoTest()
    {
        Assert.assertEquals(Pokemon.BULBASAUR.getNature().toString(), 
                "relaxed");
        Assert.assertEquals(Pokemon.BULBASAUR.getPokemonType().toString(), 
                "grass");
        
        Assert.assertEquals(Pokemon.CHARMANDER.getNature().toString(), 
                "brave");
        Assert.assertEquals(Pokemon.CHARMANDER.getPokemonType().toString(), 
                "fire");
        
        Assert.assertEquals(Pokemon.SQUIRTLE.getNature().toString(), 
                "quiet");
        Assert.assertEquals(Pokemon.SQUIRTLE.getPokemonType().toString(), 
                "water");
    }
}
