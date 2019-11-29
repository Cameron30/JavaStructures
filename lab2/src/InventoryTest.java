import org.junit.Assert;
import org.junit.Test;

/**
 * Tests all part of the Inventory class.
 * @author Cameron
 *@version 20160901
 */
public class InventoryTest 
{
    /**
     * Item tester #1
     */
    private Item tempItem = new Item("Axe", 25, 1000);
    
    /**
     * Inventory tester
     */
    private Inventory inven = new Inventory();
    
    /**
     * Item tester #2
     */
    private Item tempItem2 = new Item("Sword", 50, 100);

    /**
     * Tests addItem and constructs for Inventory
     */
    @Test
    public void constructAndAddItemTest() 
    {
        //adds items to inventory
        Inventory tempInv = new Inventory();
        inven.addItem(tempItem);
        Assert.assertFalse(inven.equals(tempInv));  

        //tests if they can be properly added
        inven.addItem(tempItem2);
        //This should fail
        Assert.assertFalse(inven.equals(tempInv));          
    }
    
    /**
     * getTotalPrice gets thoroughly tested using two items
     */
    @Test
    public void getTotalPriceTest() 
    {
        //tests price with a single item
        inven.addItem(tempItem);
        Assert.assertEquals(1000, inven.getTotalPrice());
        
        //adds tempItem2 to total
        inven.addItem(tempItem2);
        Assert.assertEquals(1100, inven.getTotalPrice());   
    }
    
    /**
     * getTotalWeight gets thoroughly tested using two items
     */
    @Test
    public void getTotalWeightTest() 
    {
        //tests weight with a single item
        inven.addItem(tempItem);
        Assert.assertEquals(25, inven.getTotalWeight(), .001);
        
        //adds tempItem2 to total
        inven.addItem(tempItem2);
        Assert.assertEquals(75, inven.getTotalWeight(), .001);       
    }
    
    /**
     * getSize method gets tested
     */
    @Test
    public void getSizeTest() 
    {
        //adds 3 items then tests for 3 items found
        inven.addItem(tempItem);
        inven.addItem(tempItem);
        inven.addItem(tempItem);
        Assert.assertEquals(inven.getSize(), 3);
    }
    
    /**
     * weighItemsByName gets tested
     */
    @Test
    public void weighItemsByNameTest() 
    {
        //adds two items to inventory
        inven.addItem(tempItem);
        inven.addItem(tempItem2);
        
        //gets weight of "Axe"
        Assert.assertEquals(inven.weighItemsByName("Axe"),
                tempItem.getWeight(), 0.0);
    }
    
    /**
     * priceItemsByName gets tested
     */
    @Test
    public void priceItemsByNameTest() 
    {
        //adds two items to inventory
        inven.addItem(tempItem);
        inven.addItem(tempItem2);
        
        //gets price of "Axe"
        Assert.assertEquals(inven.priceItemsByName("Axe"),
                tempItem.getPrice(), 0.0);
    }
    
    /**
     * getItems gets tested 
     */
    @Test
    public void getItemsTest() 
    {
        //adds two items to inventory
        inven.addItem(tempItem);
        inven.addItem(tempItem2);
        
        //creates temp array for test
        Item[] tempArr = new Item[0];
        tempArr = inven.getItems();
        
        //tests getItems
        Assert.assertTrue(tempArr[0].equals(tempItem));
        
    }
    
    /**
     * toString gets tested
     */
    @Test
    public void toStringTest() 
    {
        //creates String with proper answer
        inven.addItem(tempItem);
        String output = "You currently have the following items in your "
                + "inventory: \n" + tempItem.toString();
        //Tests toString
        Assert.assertEquals(output, inven.toString());
    }
}
