
/**
 * 
 * @author Cameron
 * @version 09162016
 */
public class Exam extends GradedItem
{
    /**problemSet is a list of problems*/
    private String problemSet;
    
    /**
     * CONSTRUCTOR
     * @param name      name of item
     * @param month     month of grade 
     * @param day       day of grade
     * @param hour      hour of grade
     * @param minute    minute of grade
     * @param problemSet string of the problems
     */
    public Exam(String name, int month, int day, int hour, 
            int minute, String problemSet)
    {
        //sets all variables according to constructor
        this.problemSet = problemSet;
        this.name = name;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }
    
    /**
     * Creates proper output
     * @return formatted output
     */
    public String tostring() 
    {
        //formats the output then returns it
        String answer = String.format("%s (date: %d-%d at %02d:%02d): grade ="
                + " %.2f: problem set = %s", name, month, day, hour, minute,
                grade, problemSet);
        return (answer);
    }
}
