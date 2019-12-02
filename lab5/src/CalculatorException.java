/**
 * 
 * @author CS2334.  Modified by Cameron Ray
 * @version 2016-09-22
 * Lab 5
 *  
 * Exception class for representing exceptions that can
 * occur within a calculator.  
 * 
 * This class extends Exception, adding a boolean "quit" flag
 * that indicates that the user has typed "quit" (in any casing)
 *
 */
public class CalculatorException extends Exception 
{
    /**quit is a boolean for whether or not the program should quit. */
    private boolean quit;
    
    /**message is the error for calculators*/
    private String message;
    
    /**
     * constructor with no boolean
     * @param message string for error
     */
    public CalculatorException(String message)
    {
        //sets message and quit
        this.message = message;
        System.out.println(this.message);
        quit = false;
    }
    
    /**
     * constructor with boolean
     * @param message string for error
     * @param quit boolean whether to quit or not
     */
    public CalculatorException(String message, boolean quit)
    {
        //sets message and quit
        this.message = message;
        this.quit = quit;
        System.out.println(this.message);
    }
    
    /**
     * gets quit
     * @return boolean to quit
     */
    public boolean isQuit()
    {
        return quit;
    }
    
    /**
     * gets message
     * @return string with error
     */
    public String getMessage()
    {
        return this.message;
    }
}
