import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author Cameron
 * @version 09292016
 */
public class ItemTest
{
    /**static weight*/
    private static final double WEIGHT = 0.4527;
    /**static value multiplayer*/
    private static final int VALUE_MULTIPLIER = 247;
    /**static items array*/
    private static Item[] items;
    
    /**
     * sets up the tests
     */
    @BeforeClass
    public static void setUp()
    {
        Item.reset();
        
        items = new Item[5];
        
        for (int i = 0; i < 5; i++)
        {
            items[i] = new Item(Integer.toString(i),
                i * VALUE_MULTIPLIER, i + WEIGHT)
            {   
                @Override
                public String use()
                {
                    return "You use the item, it is good.";
                }  
            };
        }
    }

    /**
     * constructor test
     */
    @Test
    public void itemConstructorTest()
    {
        Assert.assertEquals(items[2].getName(), "2");
        Assert.assertEquals(items[2].getValue(), 2 * VALUE_MULTIPLIER);
        Assert.assertEquals(items[2].getWeight(), 2 + WEIGHT, 0.001);
    }
    
    /**
     * item id test
     */
    @Test
    public void getItemIdTest()
    {
        for (int i = 0; i < 5; i++)
        {
            Assert.assertEquals(i, items[i].getId());
        }
    }
    
    /**
     * lesser test
     */
    @Test
    public void compareItemToLesserItemTest()
    {
        Assert.assertTrue(items[1].compareTo(items[0]) > 0);
    }
    
    /**
     * equal test
     */
    @Test
    public void compareItemToEqualItemTest()
    {
        Assert.assertTrue(items[1].compareTo(items[1]) == 0);
    }
    
    /**
     * greater test
     */
    @Test
    public void compareItemToGreaterItemTest()
    {
        Assert.assertTrue(items[0].compareTo(items[1]) < 0);
    }
    
    /**
     * lexicographical equals
     */
    @Test
    public void compareEqualItemsLexicographicallyTest()
    {
        Item lesser = new Item("a", items[1].getValue(),
            items[1].getWeight())
            {
                @Override
                public String use()
                {
                    return null;
                }
            };
            
        Item greater = new Item("b", items[1].getValue(),
            items[1].getWeight())
            {
                @Override
                public String use()
                {
                    return null;
                }
            };

        Assert.assertTrue(lesser.compareTo(greater) < 0);
    }
    
    /**
     * to string test
     */
    @Test
    public void itemToStringTest()
    {
        Assert.assertEquals(String.format("%d -- Value: %d, Weight: %.2f",
            3, 3 * VALUE_MULTIPLIER, 3 + WEIGHT), items[3].toString());
    }
    
    /**
     * use test
     */
    @Test
    public void itemUseTest()
    {
        Assert.assertEquals("You use the item, it is good.",
            items[0].use());
    }
    
    /**
     * name test
     */
    @Test
    public void setItemNameTest()
    {
        items[0].setName("New Name");
        
        Assert.assertEquals("New Name", items[0].getName());
    }
    
    /**
     * value test
     */
    @Test
    public void setItemValueTest()
    {
        items[0].setValue(42);
        
        Assert.assertEquals(42, items[0].getValue());
    }
    
    /**
     * weight test
     */
    @Test
    public void setItemWeightTest()
    {
        items[0].setWeight(5 + WEIGHT);
        
        Assert.assertEquals(5 + WEIGHT, items[0].getWeight(), 0.001);
    }
}
