import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * 
 * @author CS2334.  Modified by: Cameron Ray / Justin Huebner
 * @version 09192016
 * <P>
 * Date: 2015-09-10 <BR>
 * Project 1
 * <P>
 * This class represents the data for all of the days within a single month
 *
 */

/**
 * 
 * @author cameron ray / Justin Huebner
 * @version 2016.09.19
 * class that contains days of data from a given csv file
 */
public class DataMonth extends MultiStatisticsWithDaysAbstract
{
    /** The set of days.  */
    private TreeMap<Integer, DataDay> days = new TreeMap<Integer, DataDay>();

    //instantiates the variables
    private int year;
    private int month;
    private String stationID;
  
    /**
     * DataMonth constructor
     */
    public DataMonth()
    {
        //empty constructor
    }

    /**
     * adds a day to this month
     * @param day is the day to add to the array.
     */
    protected void addDay(DataDay day)
    {
        //add day to this month, using the getDay getter
        days.put(day.getDay(), day);
        
        month = day.getMonth();
        year = day.getYear();
        stationID = day.getStationID();
    }
    
    /**
     * returns the day at the specified index
     * @param day is corresponding day
     * @return the dataday at i
     */
    protected DataDay getItem(Integer day)
    {
        if (days.containsKey(day))
        {
            //get the selected day
            return days.get(day);
        }
        //invalid dataday
        System.out.println("ERROR: EMPTY DAYS TREEMAP IN DATAMONTH");
        return new DataDay();
    }
    
    /**
     * Describe the month
     * 
     * @return A string describing the days and the statistics for the month
     */
    public String toString()
    {
        return String.format("%s-%s, %s", year, month, stationID);
    }
    
    /**
     * @return iterated days
     */
    public Iterator<Integer> iterator()
    {
        //give an iterator over the keys of the treemap
        return days.navigableKeySet().iterator();
    }
    
    /**
     * 
     * @return structure
     */
    public String getStructure()
    {
        //converts TreeMap to arrayList of days
        ArrayList<DataDay> allDays = new ArrayList<DataDay>();
        for (Entry<Integer, DataDay> entry : days.entrySet())
        {
            allDays.add(entry.getValue());
        }
        
        //adds year data to return
        String returnStr = "\t\t" + "Month: " + toString() + "\n";
        
        //adds days to the return string
        for (int i = 0; i < allDays.size(); ++i)
        {
            returnStr += "\t\t\t" + allDays.get(i) + "\n";
        }
        
        //returns
        return returnStr; 
    }

}
