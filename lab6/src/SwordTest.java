import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author Cameron
 * @version 09292016
 * Tests sword class
 */
public class SwordTest 
{
    
    /**
     * tests the polish
     */
    @Test
    public void polishTest()
    {
        Sword temp = new Sword(100, 100, 100, 100);
        temp.polish();
        Assert.assertEquals(100.05, temp.getDamage(), 0);
    }

}
