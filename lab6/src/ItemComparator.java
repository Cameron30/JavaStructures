import java.util.Comparator;

/**
 * Interface used by Item.sort(ItemComparator comparator)
 * This ensures that Comparators passed into sort() compare
 * objects of type Item.
 * 
 * @author Nicholas
 * @version 2016-09-26
 */
public interface ItemComparator extends Comparator<Item>
{
}
