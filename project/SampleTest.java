import org.junit.Test;
import org.junit.Assert;

/**
 * 
 * @author cameron ray / justin huebner
 * @version 20160919
 * tests sample constructor
 */
public class SampleTest
{
    /**
     * validity tester
     */
    @Test
    public void constructorValidityTest()
    {
        Sample temp = new Sample();
        Assert.assertEquals(false, temp.isValid());
        
        Sample temp2 = new Sample(-901);
        Assert.assertEquals(false, temp2.isValid());
        
        Sample temp3 = new Sample(69);
        Assert.assertEquals(true, temp3.isValid());
    }
    
    /**
     * tests toString
     */
    @Test
    public void valueToStringTest()
    {
        Sample temp = new Sample();
        Assert.assertEquals("invalid", temp.toString());
        
        Sample temp2 = new Sample(123.1234);
        Assert.assertEquals("123.1234", temp2.toString());
    }

    /**
     * Tests for values
     */
    @Test
    public void valueTest()
    {
        Sample temp = new Sample();
        Assert.assertEquals(0.0, temp.getValue(), 0.0);
        
        Sample temp2 = new Sample(420.69);
        Assert.assertEquals(420.69, temp2.getValue(), 0.0);
        
                
    }
}
