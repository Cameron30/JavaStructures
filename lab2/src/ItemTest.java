import org.junit.Test;
import org.junit.Assert;


/**
 * Testing class for Item object
 * 
 * @author Taner Davis
 * @version 20160827
 */
public class ItemTest 
{

    /**
     * Test the empty Item constructor
     */
    @Test
    public void emptyItemConstructorTest()
    {
        //Use the default constructor
        Item item = new Item();

        //The name should be null, and the price and weight zero
        Assert.assertNull(item.getName());
        Assert.assertEquals(0, item.getPrice());
        Assert.assertEquals(0, item.getWeight(), 0.01);

    }

    /**
     * Test the Item constructor with only a String parameter
     */
    @Test
    public void singleParameterConstructorTest()
    {
        //Use the single-parameter constructor
        Item item = new Item("Portal Gun");

        /*
         * The name should match its initial parameter,
         * the price and weight should be zero
         */
        Assert.assertEquals("Portal Gun", item.getName());
        Assert.assertEquals(0, item.getPrice());
        Assert.assertEquals(0, item.getWeight(), 0.01);

    }

    /**
     * Test the Item constructor using a string parameter
     * and a double weight
     */
    @Test
    public void doubleParameterConstructorTest()
    {
        //Use the double-parameter constructor
        Item item = new Item("Battle Axe", 98.7);

        /*
         * The name should match its initial parameter,
         * the weight should equal its initial value,
         * and the price should be zero
         */
        Assert.assertEquals("Battle Axe", item.getName());
        Assert.assertEquals(0, item.getPrice());
        Assert.assertEquals(98.7, item.getWeight(), 0.01);

    }

    /**
     * Test full constructor and the getters
     */
    @Test
    public void fullConstructorTest() 
    {
        // Use full constructor
        Item item = new Item("Whip", 10.1, 80);

        /*
         * The name should match its initial parameter,
         * and the weight and price should equal their 
         * initial values
         */
        Assert.assertEquals(80, item.getPrice());
        Assert.assertEquals(10.1, item.getWeight(), 0.01);
        Assert.assertTrue(item.getName().equals("Whip"));
    }

    /**
     * Test all mutator methods
     */
    @Test
    public void allMutatorsTest() 
    {
        // Use full constructor
        Item item = new Item("Change This", 999.9, 999);

        // Set name, price, and weight properties
        item.setName("Scythe");
        item.setPrice(125);
        item.setWeight(38.3);

        /*
         * The name should match the parameter passed
         * into the mutator methods, and the weight and 
         * price should equal the values passed to their
         * respective mutator methods.
         */
        Assert.assertEquals(125, item.getPrice());
        Assert.assertEquals(38.3, item.getWeight(), 0.01);
        Assert.assertTrue(item.getName().equals("Scythe"));
    }

    /**
     * Test the String representation of an Item
     */
    @Test
    public void itemToStringTest()
    {
        Item item = new Item("MegaBuster", 27.9, 500);

        Assert.assertEquals("MegaBuster, 27.9 Fantasy Units, 500 Gold\n", 
                item.toString());
    }
}

