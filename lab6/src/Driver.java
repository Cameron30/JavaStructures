/**
 * Driver class for testing
 * 
 * @author Nicholas
 * @version 2016-09-22
 */

public class Driver
{
    /**
     * Main method for basic test
     * 
     * @param args Unused arguments
     */
    public static void main(String[] args)
    {
        // Create the inventory
        Inventory inventory = new Inventory();

        // Create a set of items
        Item a = new Sword(30.4219, 0.7893, 300, 2.032);
        Item b = new Sword(40, 0.7893, 200, 2);
        Item c = new Sword(40, 1, 100, 3);
        Item pizza = new Pizza(12, true);

        // Add the items to the inventory
        inventory.addItem(a);
        inventory.addItem(b);
        inventory.addItem(c);
        inventory.addItem(pizza);
        
        // Display the inventory
        System.out.println(inventory);
        
    
        // Sort by natural order
        inventory.sort();
        
        // Display the new inventory
        System.out.println(inventory);
        
        // Sort by weight
        inventory.sort(new ItemWeightComparator());
        
        // Display the inventory again
        System.out.println(inventory);
        
        // Use the sword
        System.out.println(a.use());
        System.out.println(a.use());
        
        System.out.println(pizza.use());
    }
}
