import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * station definition list class
 * @author cameron / justin
 * @version 10262016
 */
public class StationDefinitionList 
{

    private HashMap<String, StationDefinition> stationMap = new HashMap<
            String, StationDefinition>();

    /**
     * constructor
     * @param fileName name of file
     * @throws IOException if error occurs
     */
    public StationDefinitionList(String fileName) throws IOException
    {
        //initialize string
        String line = "";

        //initialize bufferedReader
        BufferedReader br = new BufferedReader(new FileReader(fileName));


        //throw away header and read first line of data
        line = br.readLine();
        line = br.readLine();
        String[] str;

        //keep reading until the end of the file is reached
        while (line != null)
        {
            str = line.split(",");

            StationDefinition statDef = new StationDefinition(str[0], str[1],
                    str[2], Double.parseDouble(str[3]),
                    Double.parseDouble(str[4]));

            if (!str[0].isEmpty())
            {
                stationMap.put(str[0], statDef);
            }
            line = br.readLine();
        }

        br.close();
    }

    /**
     * 
     * @param stationId for name of station
     * @return the definition
     */
    public StationDefinition getStationInfo(String stationId)
    {
        return stationMap.get(stationId);
    }

    /**
     * @return properly formatted string
     */
    public String toString()
    {
        //initialize string
        String retStr = "";
        if (!stationMap.isEmpty())
        {
            //traverse the array and print entries
            for (Entry<String, StationDefinition> entry : 
                stationMap.entrySet()) 
            {
                retStr = entry.getKey() + " : " + entry.getValue();
            }
        }

        return retStr;
    }

    /**
     * adds day
     * @param day to add
     */
    private void addDay(DataDay day)
    {
        //add this day to the value in the hashmap that has its STID as a key.
        stationMap.get(day.getStationID().toUpperCase()).addDay(day);
    }

    /**
     * Load the file containing all of the observation data 
     * and place the individual days
     * into this station list structure.
     * <P>
     * Note that the first line in this file gives us the names
     *  of all of the fields contained
     * in the file
     * 
     * @param fileName File to open
     * @throws FileNotFoundException If the specified file is not found
     * @throws IOException If an error occurs in reading bytes from the file
     */
    public void loadData(String fileName) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(
                fileName));
        // The first line gives us the field list
        String strg = br.readLine();
        String[] fields = strg.split(",");

        // Tell the DataDay class what the fields are
        DataDay.setDataFields(fields);

        // Now read the lines
        strg = br.readLine();
        while (strg != null) {
            // Split up the line
            String[] subs = strg.split(",");
            // Create the day object
            DataDay day = new DataDay(subs, new KeyConstraints());
            //System.out.println(day.getDate());
            // Add the day to this station list
            addDay(day);
            strg = br.readLine();
        }
        // Close the file
        br.close();
    } 

    /**
     * gets ids
     * @return array list with ids
     */
    public ArrayList<String> getStationIds()
    {
        //might need later:
        //ArrayList<String> aList = new ArrayList<String>();

        //iterate and populate the arraylist
        ArrayList<String> aList = new ArrayList<String>();
        for (String i : stationMap.keySet())
        {
            aList.add(i);
        }
        return aList;
    }

    /**
     * gets average
     * @param stationId name of station
     * @param variableId name of variable
     * @return sample
     * @param k null
     */
    public Sample getStatisticAverage(String stationId, 
            String variableId, KeyConstraints k)
    {
        //get the average from StationDefinition.getAvg
        return stationMap.get(stationId.toUpperCase())
                .getStatisticAverage(variableId.toUpperCase(), k);
    }

    /**
     * gets max day
     * @param stationId name of station
     * @param variableId name of variable
     * @return the max day
     * @param k null
     */
    public DataDay getStatisticMaxDay(String stationId,
            String variableId, KeyConstraints k)
    {
        return stationMap.get(stationId.toUpperCase())
                .getStatisticMaxDay(variableId.toUpperCase(), k);
    }

    /**
     * gets min day
     * @param stationId name of station
     * @param variableId name of variable
     * @return the min day
     * @param k null
     */
    public DataDay getStatisticMinDay(String stationId, 
            String variableId, KeyConstraints k)
    {
        return stationMap.get(stationId.toUpperCase())
                .getStatisticMinDay(variableId.toUpperCase(), k);
    }

    /**
     * gets the structure
     */
    public void getStructure()
    {
        //REMOVE, FOR TESTING PURPOSES.
        for (String key : stationMap.keySet())
        {
            System.out.println(stationMap.get(key).getStructure());
        }
    }
}
