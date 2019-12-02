/**
 * Abstract class: 
 * - contains sub-objects over which statistics can be 
 * computed (MultiStatisticsAbstract)
 * - Requires a method for adding a day.
 * 
 * @author CS2334
 * @version 2016-11-10
 *
 */
public abstract class MultiStatisticsWithDaysAbstract
    extends MultiStatisticsAbstract
{
    /**
     * add day
     * @param day day to add
     */
    protected abstract void addDay(DataDay day);
}
