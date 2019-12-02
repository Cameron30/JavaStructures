/**
 * The Pizza class extends the Consumable class, implementing
 * the eat() method, which returns a descriptive String about
 * the eating of the Pizza, and increases the number of slices
 * eaten until this equals the number of total slices,
 * at which point the Pizza becomes "consumed".
 * 
 * @author Nicholas
 * @version 2016-09-22
 */
public class Pizza extends Consumable
{
    /**
     * The total number of slices the full Pizza has.
     */
    private int numberOfSlices;

    /**
     * The number of slices of the Pizza that have been eaten.
     */
    private int slicesEaten;
    
    /**
     * @param numberOfSlices The number of slices that can be eaten
     * before the Pizza has been consumed.
     * @param spoiled Whether or not the Pizza is spoiled.
     */
    public Pizza(int numberOfSlices, boolean spoiled)
    {
        super("pizza", 50, 2, spoiled);
        
        this.numberOfSlices = numberOfSlices;
        slicesEaten = 0;
    }
    
    /* (non-Javadoc)
     * @see Consumable#eat()
     */
    @Override
    public String eat()
    {
        if (slicesEaten < numberOfSlices)
        {            
            slicesEaten++;
            
            if (slicesEaten >= numberOfSlices)
            {
                setConsumed(true); // All gone!
            }
            
            return "You eat a slice of the pizza.";
        }
        else
        {
            /* There is no description returned if the Pizza
             * is consumed since we are only interacting with
             * class instances through the API defined by Item,
             * which does not expose eat().
             * 
             * Consumable's implementation of use() will display
             * an appropriate message if the player tries to "use"
             * a consumed Consumable.
             */
            return "";
        }        
    }
}
