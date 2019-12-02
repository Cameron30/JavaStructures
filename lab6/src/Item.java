/**
 * The abstract class Item describes the properties and functions
 * that an item in a fantasy game can have.  This includes the item's
 * name, value, and weight.  An Item can be "used", allowing for a
 * descriptive string of the use to be returned to the user.
 * 
 * @author Nicholas
 * @version 2016-09-22
 */
public abstract class Item implements Comparable<Item>
{
    /**
     * The current number of Item objects that have
     * been created.
     */
    private static int numberOfItems = 0;
    
    /**
     * The unique identifier for this Item instance.
     */
    private int id;
    
    /** 
     * The value of the item, in gold pieces.
     */
    private int value;
    
    /**
     * The name of the item.
     */
    private String name;

    /**
     * The weight of the item, in fantasy units.
     */
    private double weight;
   
    /**
     * Reset the object ID counter.
     * 
     * This is useful when you have multiple Junit Test classes
     * (call this method within the unit test @BeforeClass method).
     */
    public static void reset()
    {
        numberOfItems = 0;
    }
    
    /**
     * "Uses" the Item, returning a descriptive string
     * of what happened when used.
     * 
     * @return The text describing what happened when using the item.
     */
    public abstract String use();
    
    /**
     * Item Constructor
     * 
     * @param name Name of the item.
     * @param value Value of the item.
     * @param weight Weight of the item.
     */
    public Item(String name, int value, double weight)
    {
        //variables are assigned
        this.name = name;
        this.value = value;
        this.weight = weight;
        
        //id is given then 1 is added to the counter
        id = numberOfItems;
        ++numberOfItems;
    }
    
    /**
     * Object ID number
     * 
     * @return the ID
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Value of the item
     * 
     * @return the value
     */
    public int getValue()
    {
        return value;
    }

    /**
     * Name of the item
     * 
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Item weight
     * 
     * @return the weight
     */
    public double getWeight()
    {
        return weight;
    }

    /**
     * Change the value of the item
     * 
     * @param value the value to set
     */
    public void setValue(int value)
    {
        this.value = value;
    }

    /**
     * Change the name of the item 
     * 
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Set the weight of the item
     * 
     * @param weight the weight to set
     */
    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    /**
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     * 
     * First compares the value of the Items, defaults to
     * lexicographical ordering (Comparing by the value of
     * the letters, not the case.  i.e. A == a) if they are equal.
     * 
     * @param other The other Item to compare against.
     * @return -1, 0, or 1 based on the rules defined above.
     */
    public int compareTo(Item other)
    {
        //returns order according to value
        if (value > other.value)
        {
            return 1;
        } 
        else if (value < other.value)
        {
            return -1;
        } 
        else
        {
            //compares lexicographically
            return (name.compareToIgnoreCase(other.getName()));
        }
    }
    
    /** Return a description of the item
     * 
     * @see java.lang.Object#toString()
     * @return A String describing the item
     */
    @Override
    public String toString()
    {
        //returns formatted string
        return String.format("%s -- Value: %d, Weight: %.2f", 
                name, value, weight);
    }
}
