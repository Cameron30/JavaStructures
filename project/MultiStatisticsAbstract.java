/**
 * class that will perform statistics algorithms
 * 
 * @author cameron ray / justin huebner
 * @version 10.12.2016
 */
public abstract class MultiStatisticsAbstract 
    extends StatisticsAbstract implements Iterable<Integer>
{

    /**abstract gets the item at int i
     * @return StatisticsAbstract item
     * @param key for the treemaps
     */
    protected abstract StatisticsAbstract getItem(Integer key);

    /**
     * Compute the min of some statistic over 
     * all of the sub-objects of *this*.  If there are duplicate
     * minimum values, then the first will be returned.  If there 
     * are no valid values, then the last day will be returned
     * 
     * @param statisticId String describing the statistic 
     * (or measure) over which the min is to be computed
     * @param constraints key constraints
     * @return The day containing the min
     */
    public DataDay getStatisticMinDay(String statisticId,
            KeyConstraints constraints)
    {
     // staff code
        // Best day and sample so far
        DataDay bestDay = new DataDay();
        Sample bestValue = new Sample();

        // Compute the next constraints
        KeyConstraints nextConstraint = constraints.getNext();
        if (constraints != null)
        {
            nextConstraint = constraints.getNext();
        }

        // Iterate over all of the keys in this object
        for (Integer key: this)
        {
            // Is this a key that we want?
            if (constraints.isEmpty() || constraints.contains(key))
            {
                // Yes!
                
                // Fetch the next object
                StatisticsAbstract o = getItem(key);

                // Ask the next object what its best value is
                DataDay newDay = o
                        .getStatisticMinDay(statisticId, nextConstraint);
                Sample newValue = newDay
                        .getStatisticAverage(statisticId, nextConstraint);

                // Is this new one better?
                if (newValue.isLessThan(bestValue))
                {
                    // Yes - replace
                    bestDay = newDay;
                    bestValue = newValue;
                }
            }
        }

        return bestDay;
    }

    /**
     * Compute the max of some statistic over 
     * all of the sub-objects of *this*.  If there are duplicate
     * maximum values, then the first will be returned.  If there 
     * are no valid values, then the last day will be returned
     * 
     * @param statisticId String describing the statistic 
     * (or measure) over which the max is to be computed
     * @param constraints keyconstraints
     * @return The day containing the max
     */
    public DataDay getStatisticMaxDay(String statisticId,
            KeyConstraints constraints)
    {
        // Best day and sample so far
        DataDay bestDay = new DataDay();
        Sample bestValue = new Sample();

        // Compute the next constraints
        KeyConstraints nextConstraint = null;
        if (constraints != null)
        {
            nextConstraint = constraints.getNext();
        }

        // Iterate over all of the keys in this object
        for (Integer key: this)
        {
            // Is this a key that we want?
            if (constraints.isEmpty() || constraints.contains(key))
            {
                // Yes!
                
                // Fetch the next object
                StatisticsAbstract o = getItem(key);

                // Ask the next object what its best value is
                DataDay newDay = o
                        .getStatisticMaxDay(statisticId, nextConstraint);
                Sample newValue = newDay
                        .getStatisticAverage(statisticId, nextConstraint);

                // Is this new one better?
                if (newValue.isGreaterThan(bestValue))
                {
                    // Yes - replace
                    bestDay = newDay;
                    bestValue = newValue;
                }
            }
        }

        return bestDay;
    }
    
    
    /**
     * Compute the average of some statistic over 
     * all of the sub-objects of *this*.
     * 
     * @param statisticId String describing the statistic 
     * (or measure) over which the average is to be computed
     * @param k keyconstraints
     * @return A sample containing the result.  Note that the
     * sample will be invalid if there are no sub-objects
     */
    public Sample getStatisticAverage(String statisticId, KeyConstraints k)
    {

        // Incremental accumulation of values
        double accum = 0.0;
        int count = 0;
        
        // Compute the next constraints
        KeyConstraints nextConstraint = null;
        if (k != null)
        {
            nextConstraint = k.getNext();
        }

        // Iterate over sub-objects
        for (Integer key: this)
        { 
            if (k.isEmpty() || k.contains(key))
            {
                
                // Fetch the next object
                StatisticsAbstract o = getItem(key);

                // Ask the next object what its best value is
                Sample newValue = o
                        .getStatisticAverage(statisticId, nextConstraint);
                
                if (newValue.isValid())
                {
                    accum += newValue.getValue();
                    count += 1; 
                }
            }
        } 
        
        // Were there any sub-objects?
        if (count == 0)
        {
            // No - return an invalid sample
            return new Sample();
        }
        else
        {
            // Yes - return the average
            return new Sample(accum / count);
        }
    }
;
}
