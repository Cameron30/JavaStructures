import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Data definition list
 * @author cameron / justin
 * @version 10262016
 *
 */
public class DataDefinitionList 
{

    private HashMap<String, DataDefinition> dataInfoMap = 
            new HashMap<String, DataDefinition>();
    
    /**
     * 
     * @param fileName being read
     * @throws IOException if error occurs
     */
    public DataDefinitionList(String fileName) throws IOException
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
            String name = str[0];
            String id = str[1];
            String unit = str[2];
            Boolean positive = Boolean.parseBoolean(str[3]);
            String description = str[4];
            
            dataInfoMap.put(str[1], new DataDefinition(name, id, unit,
                    positive, description));
            line = br.readLine();
        }
           
        br.close();
    }
    
    /**
     * gets Ids
     * @return a string array list
     */
    public ArrayList<String> getVariableIds()
    {
        ArrayList<String> ids = new ArrayList<String>();
        for (Entry<String, DataDefinition> entry : dataInfoMap.entrySet()) 
        {
            ids.add(entry.getKey());
        }
        return ids;
    }
    
    /**
     * checks validity
     * @param variableId specific Id
     * @return boolean
     */
    public boolean isValidStat(String variableId)
    {
        return dataInfoMap.containsKey(variableId);
    }
    
    /**
     * 
     * @param variableId name of variable
     * @return data definition
     */
    public DataDefinition getDataInfo(String variableId)
    {
        if (isValidStat(variableId))
        {
            return dataInfoMap.get(variableId);  
        }
        else
        {
            return new DataDefinition("", "", "", true, "");
        }
        
    }
    
    /**
     * @return formatted string
     */
    public String toString()
    {
        String returnStr = "";
        for (Entry<String, DataDefinition> entry : dataInfoMap.entrySet()) {
            returnStr += entry.getValue() + "\n";
        }
        return returnStr;
    }
    
    
}
