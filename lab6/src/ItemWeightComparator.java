/**
 * 
 * @author Cameron
 * @version 09292016
 *
 */
public class ItemWeightComparator implements ItemComparator
{

    /**
     * compares by weight, then value.
     * @return int for placement
     * @param first is the first item
     * @param second is the second item
     */
    public int compare(Item first, Item second) 
    {
        if (first.getWeight() > second.getWeight())
        {
            return 1;
        } 
        else if (first.getWeight() < second.getWeight())
        {
            return -1;
        } 
        else
        {
            return (first.compareTo(second));
        }
    }

}
