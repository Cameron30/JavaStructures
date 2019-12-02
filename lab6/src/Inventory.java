import java.util.ArrayList;
import java.util.Collections;

/**
 * The Inventory maintains a collection (that can be added to) of Item objects,
 * can sort them in various ways, and can display its contents.
 * 
 * @author Nicholas
 * @version 2016-09-22
 */
public class Inventory
{
    /**
     * Collection of fantasy Items.
     */
    private ArrayList<Item> items;

    /**
     * Initializes the ArrayList of Items.
     */
    public Inventory()
    {
        items = new ArrayList<Item>();
    }

    /**
     * Adds the specified Item to this Inventory's collection.
     * 
     * @param item
     *            The Item to add to the Inventory.
     */
    public void addItem(Item item)
    {
        items.add(item);
    }

    /**
     * Sorts the Item objects in this Inventory's collection by their default
     * ordering defined by Item's implementation of Comparable.
     * 
     * In this case, sorts by value and then lexicographical ordering.
     */
    public void sort()
    {
        Collections.sort(items);
    }

    /**
     * Sorts the Item objects in this Inventory's collection by the ordering
     * defined by the ItemComparator.
     * 
     * @param comparator
     *            The ItemComparator to use for sorting.
     */
    public void sort(ItemComparator comparator)
    {
        Collections.sort(items, comparator);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder(
                "You have the following items in your inventory:\n");

        for (Item item : items)
        {
            result.append(item.toString() + "\n");
        }

        return result.toString();
    }
}
