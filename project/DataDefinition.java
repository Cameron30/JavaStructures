/**
 * DataDefinition class
 * @author Cameron / Justin
 * @version 10262016
 */
public class DataDefinition 
{
    
    private String variableName;
    
    private String variableId;
    
    private String unit;
    
    private boolean positive;
    
    private String description;
    
    /**
     * Constructor
     * @param variableName name
     * @param id variable id
     * @param unit of measurement
     * @param positive or negative
     * @param description of variable
     */
    public DataDefinition(String variableName, String id, String unit, 
            boolean positive, String description)
    {
        this.variableName = variableName;
        variableId = id;
        this.unit = unit;
        this.description = description; 
    }

    /**
     * @return name
     */
    public String getVariableName() 
    {
        return variableName;
    }

    /**
     * 
     * @return id
     */
    public String getVariableId() 
    {
        return variableId;
    }

    /**
     * 
     * @return unit
     */
    public String getUnit() 
    {
        return unit;
    }

    /**
     * 
     * @return boolean for positive
     */
    public boolean isPositive() 
    {
        return positive;
    }

    /**
     * 
     * @return description
     */
    public String getDescription() 
    {
        return description;
    }

    /**
     * @return formatted string
     */
    public String toString()
    {
        return String.format("%s, %s (%s)", variableId, variableName, unit);
    }
    
    

}
