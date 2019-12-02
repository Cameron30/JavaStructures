/**
 * 
 * @author Cameron / Justin
 * @version 10102016
 * Abstract class for statistics
 */
public abstract class StatisticsAbstract 
{

    /**abstract to get min day
     * @return DataDay for min 
     * @param statisticId name of statistic
     * @param k null
     */
    public abstract DataDay getStatisticMinDay(
            String statisticId, KeyConstraints k);
    
    /**abstract to get max  day
     * @return DataDay for max
     * @param statisticId name of statistic
     * @param k null
     */
    public abstract DataDay getStatisticMaxDay(
            String statisticId, KeyConstraints k);
    
    /**abstract to get average
     * @return Sample for average
     * @param statisticId name of statistic
     * @param k null
     */
    public abstract Sample getStatisticAverage(
            String statisticId, KeyConstraints k);
}
