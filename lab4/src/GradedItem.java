/**
 * 
 * @author Cameron
 * @version 09162016
 */
public class GradedItem 
{
    /**Name of item*/
    protected String name;
    /**actual grade*/
    protected double grade;
    /**Month of Grade*/
    protected int month;
    /**Day of Grade*/
    protected int day;
    /**Hour of Grade*/
    protected int hour;
    /**Minute of grade*/
    protected int minute;
    
    /**
     * Default constructor
     */
    public GradedItem()
    {
        //default constructor needed for the sub classes
    }
    
    /**
     * Assigns variables
     * @param name      name of item   
     * @param month     month of grade
     * @param day       day of grade
     * @param hour      hour of grade
     * @param minute    minute of grade
     */
    public GradedItem(String name, int month, int day, int hour, int minute)
    {
        //all variables assigned when object created properly
        this.name = name;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    /**
     * Gets grade
     * @return double for grade
     */
    public double getGrade() 
    {
        return grade;
    }

    /**
     * Changes grade
     * @param grade  double corresponding to grade
     */
    public void setGrade(double grade) 
    {
        this.grade = grade;
    }

    /**
     * Gets name
     * @return String for name
     */
    public String getName() 
    {
        return name;
    }

    /**
     * Gets month
     * @return int for month
     */
    public int getMonth() 
    {
        return month;
    }

    /**
     * Gets day
     * @return int for day
     */
    public int getDay() 
    {
        return day;
    }

    /**
     * Gets hour
     * @return int for hour
     */
    public int getHour() 
    {
        return hour;
    }

    /**
     * Gets minute
     * @return int for minute
     */
    public int getMinute() 
    {
        return minute;
    }
    
    /**
     * Creates output
     * @return proper string output
     */
    public String toString() 
    {
        //forms formatted output
        String answer = String.format("%s (date: %d-%d at %02d:%02d): grade = "
                + "%.2f", name, month, day, hour, minute, grade);
        return (answer);
    }
}
