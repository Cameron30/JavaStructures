import org.junit.Assert;
import org.junit.Test;

/**
 * Test suite for the Pizza class.
 * 
 * @author Nicholas
 * @version 2016-09-29
 */
public class PizzaTest
{

    /**
     * Test the Pizza class constructor.
     */
    @Test
    public void pizzaConstructorTest()
    {
        Pizza pizza = new Pizza(1, false);

        Assert.assertFalse(pizza.isConsumed());
        Assert.assertFalse(pizza.isSpoiled());
        
        /* Make sure to test the case where the Pizza is spoiled. */
        pizza = new Pizza(1, true);
        
        
        Assert.assertFalse(pizza.isConsumed());
        Assert.assertTrue(pizza.isSpoiled());
    }

    /**
     * Test that Pizza.eat() returns the expected string.
     */
    @Test
    public void pizzaEatTest()
    {
        Pizza pizza = new Pizza(2, false);
        
        Assert.assertEquals("You eat a slice of the pizza.", pizza.eat());
        Assert.assertFalse(pizza.isConsumed()); // We still have a slice left.

        Assert.assertEquals("You eat a slice of the pizza.", pizza.eat());
        Assert.assertTrue(pizza.isConsumed()); // Should be consumed now.
        
        /* We only had two slices, so this should return an empty string. */
        Assert.assertEquals("", pizza.eat());
    }
}
