/**
 * An object that holds all of a 
 * player's Item objects that they
 * currently own. These items can then
 * have a total weight, total gold, and
 * total quantity of each item printed
 * so the player can know what they have
 * in their inventory for selling purposes.
 * 
 * @author Taner Davis
 * @version 20160827
 *
 */
public class Inventory 
{

    /**
     * Item array to hold all of a player's items.
     * The Item array acts as an ArrayList where 
     * it can increase in size as needed.
     */
    private Item[] items;

    /**
     * The next empty location in the items array.
     * Used to store the next item the player acquires.
     */
    private int currentIndex;


    /**
     * Default Constructor
     */
    public Inventory() 
    {
        this.items = new Item[1];
        this.currentIndex = 0;
    }

    /**
     * Extend the size of the internal items array by 10 
     * each time this is called.
     * 
     * @param oldSize The prior size of the array
     */
    private void extendArray(int oldSize)
    {
        Item[] newArray = new Item[oldSize + 10];
        
        //copy each value from items into the new array.
        for (int i = 0; i < this.items.length; ++i) 
        {
            newArray[i] = this.items[i];
        }
        items = newArray;
    }

    /**
     * Add a single item object to the player's inventory.
     * 
     * @param i  The single item to be added to the player's 
     * inventory.
     */
    public void addItem(Item i) 
    { 
        // Check if the current index is at the end of the 
        //  array
        if (this.currentIndex == this.items.length - 1) 
        {
            // If so, extend the size of the array
            this.extendArray(items.length);
        }
        //actually add items to the inventory
        this.items[this.currentIndex] = i;
        this.currentIndex += 1;
    }

    //getter methods

    /**
     * Returns the value, in gold, of all items inside a player's
     * inventory.
     * 
     * @return The sum of price for all items in the player's 
     * inventory
     */
    public int getTotalPrice() 
    {
        int result = 0;
        //loop over all fruit and sum the price fields
        for (int i = 0; i < currentIndex; ++i) 
        {
            result += this.items[i].getPrice();   
        }
        return result;
    }

    /**
     * Returns the total weight of all items in the player's 
     * inventory.
     * 
     * @return The sum of weight for all items in the player's 
     * inventory.
     */
    public double getTotalWeight() {
        double result = 0;
        //loop over all items and sum the weight fields
        for (int i = 0; i < currentIndex; ++i ) 
        {
            result += this.items[i].getWeight();
        }
        //return the summed result;
        return result;
    }

    /**
     * Returns the total number of items inside the player's 
     * inventory.
     * 
     * @return The number of items currently in the player's 
     * inventory.
     */
    public int getSize() 
    {
        return this.currentIndex;
    }

    /**
     * Loop over all the items in the player's inventory and 
     * weigh the ones that have the same name as the parameter
     * @param name Name of items to calculate weight.
     * @return Total weight of all items in the player's 
     * inventory with a specified name. 
     */
    public double weighItemsByName(String name) 
    {
        double totalWeight = 0.0;
        for (int i = 0; i < this.currentIndex; ++i) 
        {
            //only perform the calculations if the names are equal.
            Item item = this.items[i];
            if (item.getName() == name) 
            {
                totalWeight += item.getWeight();
            }
        }
        return totalWeight;
    }

    /**
     * Loop over all the Items in the player's inventory and 
     * sum the price 
     * of the ones that have the same name as the parameter
     * @param name Name of items to calculate weight.
     * @return Total weight of all items in the player's 
     * inventory with a specified name. 
     */
    public int priceItemsByName(String name) 
    {
        int totalPrice = 0;
        for (int i = 0; i < this.currentIndex; i++) 
        {
            //only perform the calculations if the names are equal.
            Item item = this.items[i];
            if (item.getName().equalsIgnoreCase(name)) 
            {
                totalPrice += item.getPrice();
            }
        }
        return totalPrice;
    }

    /**
     * Retrieve the array that constitutes the 
     * player's inventory
     * 
     * @return The Item array that is the player's inventory
     */
    public Item[] getItems()
    {
        return items;
    }

    /**
     * When the user requires the inventory to be printed out,
     * model it in the style of a dialogue prompt of an RPG
     * 
     * @return A string representing the information stored in 
     * the Inventory class.
     */
    public String toString() 
    {
        String result = "You currently have the following items " +
               "in your inventory: \n";
        String temp;
        for (int i = 0; i < this.currentIndex; ++i) 
        {
            //add each Item in the array to the result string
            temp = this.items[i].toString();
            result = result + temp;
        }
        return result;
    }
}
