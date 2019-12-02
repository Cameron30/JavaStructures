import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * 
 * @author Cameron / Justin
 * @version 10122016
 * Dataset which has an array of years
 */
public class DataSet extends MultiStatisticsWithDaysAbstract
{

    /**ArrayList of years*/
    private TreeMap<Integer, DataYear> years = new TreeMap<Integer, DataYear>();
    
    private String stationId = "";

    /**
     * constructor
     */
    public DataSet()
    {
        
    }

    /**
     * @return DataYear at specific point
     * @param year corresponding to item
     */
    protected DataYear getItem(Integer year)
    {
        //returns the selected year, assumes that this year will exist...
        return years.get(year);
    }

    /**
     * @param d day
     */
    protected void addDay(DataDay d)
    {
        //if the year has not been created, create it.
        if (!years.containsKey(d.getYear()))
        {
            years.put(d.getYear(), new DataYear());
        }
        //add the day to the year.
        years.get(d.getYear()).addDay(d);
        
        stationId = d.getStationID();
    }

    /**
     * @return String for all the proper values.
     */
    public String toString()
    {
        return "Data Set: " + stationId;
    }

    /**
     * @return iterated years
     */
    public Iterator<Integer> iterator()
    {
        //give an iterator over the keys of the treemap 
        return years.navigableKeySet().iterator();
    }

    /**
     * @return string structure
     */
    public String getStructure()
    {
        //converts TreeMap to arrayList of months
        ArrayList<DataYear> allYears = new ArrayList<DataYear>();
        for (Entry<Integer, DataYear> entry : years.entrySet())
        {
            allYears.add(entry.getValue());
        }
        
        //adds year data to return
        String returnStr = toString() + "\n";
        
        //adds months to the return string
        for (int i = 0; i < allYears.size(); ++i)
        {
            returnStr += allYears.get(i).getStructure();
        }
        
        //returns
        return returnStr; 
    }
}
