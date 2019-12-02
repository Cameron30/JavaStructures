import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

/**
 * class that contains dataMonths
 * @author Cameron
 * @version 10.12.2016
 */
public class DataYear extends MultiStatisticsWithDaysAbstract
{

    private static TreeSet<Integer> yearList = new TreeSet<Integer>();

    private int year;

    private String stationID;

    private TreeMap<Integer, DataMonth> months = 
            new TreeMap<Integer, DataMonth>();

    /**
     * constructor
     */
    public DataYear() 
    {
        //default
    }

    /**
     * adds a day to a datamonth
     * @param day dataday object to be added
     */
    protected void addDay(DataDay day)
    {
        //add the month to an array
        int month = day.getMonth();

        if (!months.containsKey(day.getMonth()))
        {
            months.put(day.getMonth(), new DataMonth());
        }

        months.get(month).addDay(day);
        //used to be month - 1

        //if the yearList does not contain the given days year, add it.
        if (!yearList.contains(day.getYear()))
        {
            yearList.add(day.getYear());
        }

        year = day.getYear();
        stationID = day.getStationID();
    }

    /**
     * gets a datamonth object
     * @return DataMonth the datamonth at i
     * @param month to get
     */
    protected DataMonth getItem(Integer month)
    {
        //prevent index out of bounds
        //get month ASSUMES 0-ORIGIN COUNTING

        return months.get(month);
        //^^ used to be month-1 if there is an error check above line 1st
        //not checking for invalid month format here anymore...
    }

    /**
     * returns the yearList
     * @return ArrayList yearList
     */
    public static ArrayList<Integer> getYearList()
    { 
        return new ArrayList<Integer>(yearList);
    }

    /**
     * toString method gives formatted data
     * @return String string representation of this object
     */
    public String toString()
    {
        return String.format("%s, %s", year, stationID);
    }

    /**
     * @return iterated months
     */
    public Iterator<Integer> iterator()
    {
        //give an iterator over the keys of the treemap
        return months.navigableKeySet().iterator();
    }

    /**
     * 
     * @return structure
     */
    public String getStructure()
    {
        //converts TreeMap to arrayList of months
        ArrayList<DataMonth> allMonths = new ArrayList<DataMonth>();
        for (Entry<Integer, DataMonth> entry : months.entrySet())
        {
            allMonths.add(entry.getValue());
        }

        //adds year data to return
        String returnStr = "\t" + "Year: " + toString() + "\n";

        //adds months to the return string
        for (int i = 0; i < allMonths.size(); ++i)
        {
            returnStr += allMonths.get(i).getStructure();
        }

        //returns
        return returnStr;  
    }
}
