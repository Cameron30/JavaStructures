/**
 * Item class for a role-playing game. These are physical things
 * like swords, potions, and tomes. 
 * 
 * @author Taner Davis
 * @version 20160827
 */
public class Item 
{

    /**
     * The name of the item
     */
    private String name;

    /**
     * The weight of the item in fantasy units
     */
    private double weight;

    /**
     * How much the item can be sold for (in gold pieces)
     */
    private int price;


    /**
     * Empty (Default) Constructor
     */
    public Item()
    {
        //makes an empty item
    }

    /**
     * Constructor to create an item given only a name
     * 
     * @param name  The name of the item
     */
    public Item(String name)
    {
        this.name = name;
    }

    /**
     * Constructor to create an Item given a name and weight of
     * the item.
     * 
     * @param name String name of the item
     * @param weight double value for the weight in fantasy units
     */
    public Item(String name, double weight) 
    {
        this.name = name;
        this.weight = weight;
    }

    /**
     * Complete Constructor. Set the name, weight and price of 
     * the item
     * 
     * @param name  String name of the item
     * @param weight  double value for the weight in fantasy units
     * @param price  int value for the price in gold pieces
     */
    public Item(String name, double weight, int price) 
    {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }


    /**
     * Return the name of the given Item
     * @return  String name of the item object
     */
    public String getName() 
    {
        return this.name;
    }

    /**
     * Return the weight of the given Item in fantasy units
     * @return the weight of Item as a double
     */
    public double getWeight() 
    {
        return this.weight;
    }

    /**
     * Return the price of the item in gold pieces
     * @return the price of the item as in int
     */
    public int getPrice() 
    {
        return this.price;
    }


    /**
     * Alter the name of an item.
     * @param newName the new Name of the item 
     */
    public void setName(String newName) 
    {
        this.name = newName;
    }

    /**
     * Alter the weight of an item
     * @param newWeight the new weight of the item in fantasy 
     * units
     */
    public void setWeight(double newWeight) 
    {
        this.weight = newWeight;
    }

    /**
     * Alter the price of an item
     * @param newPrice the new selling price of an item in gold 
     * pieces
     */
    public void setPrice(int newPrice) 
    {
        this.price = newPrice;
    }


    /**
     * When the user needs to print out info about an item, present
     * the item in order of name, weight, and selling price
     * 
     * @return The string representation of the Item class
     */
    public String toString()
    {
        return String.format("%s, %.1f Fantasy Units, %d Gold\n", 
                this.name, this.weight, this.price);
    }
}
