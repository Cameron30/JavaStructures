import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author Cameron
 * @version 09292016
 */
public class BowTest {
    
    /**
     * tests the polish
     */
    @Test
    public void polishTest()
    {
        Bow temp = new Bow(100, 100, 100, 100);
        temp.polish();
        Assert.assertEquals(100.05, temp.getDurability(), 0);
    }

}
