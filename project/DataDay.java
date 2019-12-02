import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author CS2334.  Modified by: Cameron Ray / Justin Huebner
 * @version 09192016
 * <P>
 * Date: 2015-09-10 <BR>
 * Project 1
 * <P>
 * This class represents a summary of one day's data from a single Mesonet 
 * station.
 *
 */
public class DataDay extends StatisticsAbstract
{
    /** Year in which the data were sampled */
    private int year;
    /** Month in which the data were sampled */
    private int month;
    /** The day on which the data were sampled (1=January, 2=February, etc */
    private int day;
    /** Station Identification*/
    private String stationID;

    private HashMap<String, Sample> samples;

    private static DataDefinitionList dataDefinitionList;

    private static ArrayList<String> dataFields = new ArrayList<String>();

    private static int yearIndex;

    private static int monthIndex;

    private static int dayIndex;

    private static int stationIDIndex; 

    /**
     * DataDay constructor
     * 
     * @param args Set of values from the one row in a data file
     * @param k KeyConstraints all keys to constrain
     */
    public DataDay(String[] args, KeyConstraints k) {
        // Call the default constructor to initialize the object
        this();
        
        System.out.println(k);
        // The non-statistic values that we know will 
        //exist somewhere in the list
        year = Integer.parseInt(args[yearIndex]);
        month = Integer.parseInt(args[monthIndex]);
        day = Integer.parseInt(args[dayIndex]);
        stationID = args[stationIDIndex];
        
        // Loop over all of the string arguments
        for (int i = 0; i < args.length; ++i)
        {           
            // Does i correspond to a measured statistic?
            if (dataDefinitionList.isValidStat(dataFields.get(i)))
            {
                // Yes - parse to a double and add it to our representation
                samples.put(dataFields.get(i), 
                        new Sample(Double.parseDouble(args[i])));
            }
        }
    }
    
    /**
     * DataDay constructor
     * 
     * @param args Set of values from the one row in a data file
     */
    public DataDay(String[] args) {
        // Call the default constructor to initialize the object
        this();
        
        // The non-statistic values that we know will 
        //exist somewhere in the list
        year = Integer.parseInt(args[yearIndex]);
        month = Integer.parseInt(args[monthIndex]);
        day = Integer.parseInt(args[dayIndex]);
        stationID = args[stationIDIndex];
        
        // Loop over all of the string arguments
        for (int i = 0; i < args.length; ++i)
        {
            // Does i correspond to a measured statistic?
            if (dataDefinitionList.isValidStat(dataFields.get(i)))
            {
                // Yes - parse to a double and add it to our representation
                samples.put(dataFields.get(i), 
                        new Sample(Double.parseDouble(args[i])));
            }
        }
    }

    /**
     * Default constructor
     * 
     * Initializes the day to be an invalid one (year/month/day are left at 
     * values of zero, the stationId is left at null and the hashmap is empty)
     * 
     */
    public DataDay()
    {
        samples = new HashMap<String, Sample>();
    }

    /**
     * gets the year of the data
     * @return year
     */
    public int getYear() 
    {
        return year;
    }



    /**
     * gets the month of the data
     * @return month
     */
    public int getMonth() 
    {
        return month;
    }



    /**
     * gets the day of the data
     * @return day
     */
    public int getDay() 
    {
        return day;
    }



    /**
     * gets stationID
     * @return stationID
     */
    public String getStationID() 
    {
        return stationID;
    }

    /**
     * Describe the data for the day
     * 
     * @return String describing the day
     */
    public String toString()
    {
        return String.format("%s-%s-%s, %s", year, month, day, stationID);
    }

    /**
     *  sets data definition list
     * @param dataDefinitions is the corresponding definitions
     */
    public static void setDataDefinitionList(DataDefinitionList dataDefinitions)
    {
        dataDefinitionList = dataDefinitions;
    }

    /**
     * Set the data field ArrayList and index variables
     * 
     * @param dataFieldList An array of field array names (from the 
     * first line in a data file).
     * 
     */
    public static void setDataFields(String[] dataFieldList)
    {
        // New array list to store the field names in
        dataFields = new ArrayList<String>();
                
        // Loop through the array and add the items to the array list
        for (int i = 0; i < dataFieldList.length; ++i)
        {
            dataFields.add(dataFieldList[i]);
        }
        
        // We expect year, month, day and station ID to be in the list:
        //  find and store their indices
        yearIndex = dataFields.indexOf("YEAR");
        monthIndex = dataFields.indexOf("MONTH");
        dayIndex = dataFields.indexOf("DAY");
        stationIDIndex = dataFields.indexOf("STID");
    }

    /**
     * returns current day
     * @return this day
     * @param statisticId name of stat
     * @param k KeyConstrains all years to constrain
     */
    @Override
    public DataDay getStatisticMinDay(String statisticId, KeyConstraints k) {
        // returns this DataDay, because it must be the min.
        return this;
    }

    /**
     * returns current day
     * @return this day
     * @param statisticId name of stat
     * @param k KeyConstraints all years to constrain
     */
    @Override
    public DataDay getStatisticMaxDay(String statisticId, KeyConstraints k) {
        // returns this DataDay, because it must be the max.
        return this;
    }

    /**
     * returns statistic
     * @return this statistic
     * @param statisticId name of stat
     * @param k null
     */
    @Override
    public Sample getStatisticAverage(String statisticId, KeyConstraints k) {
        // get a temp
        Sample s = samples.get(statisticId);
        
        //check for a null sample
        if (s != null)
        {
            return s;
        }
        //invalid Sample
        return new Sample();
    }
    
    /**
     * data day date
     * @return String representation of this day's date
     */
    public String getDate()
    {
        return String.format("%s-%s-%s", year, month, day);
    }


}
