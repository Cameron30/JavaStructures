/**
 * 
 * @author Cameron
 * @version 09162016
 */
public class Assignment extends GradedItem
{
    /**specification for the assignment*/
    private String specification;
    /**data for the assignment*/
    private String data;

    /**
     * CONSTRUCTOR
     * @param name      name of item
     * @param month     month of grade 
     * @param day       day of grade
     * @param hour      hour of grade
     * @param minute    minute of grade
     * @param specification specification for the data
     * @param data      data for the assignment
     */
    public Assignment(String name, int month, int day, int hour, int minute, 
            String specification, String data)
    {
        //assigns variables
        this.name = name;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.specification = specification;
        this.data = data;
    }
    
    /**
     * creates output
     * @return formatted string
     */
    public String toString()
    {
        //formats string
        String answer = String.format("%s (date: %d-%d at %02d:%02d): grade ="
                + " %.2f: specification = %s; data source = %s", name, month, 
                day, hour, minute, grade, specification, data);
        return (answer);
    }
    
    
    
}
