
/**
 * 
 * @author CS2334.  Modified by: Cameron Ray / Justin Huebner
 * @version 20160919
 * <P>
 * Date: 2016-09-10 <BR>
 * Project 1
 * <P>
 * This class represents individual, real-valued samples.  This class
 * explicitly addresses the fact that some samples are invalid.
 *
 */
public class Sample 
{
    /** The observed value. */
    private double value;
    
    /** Indicates whether the observation is a valid one */
    private boolean valid;
    
    /**
     * default constructor, defaults valid to false
     */
    public Sample() 
    {
        valid = false;
    }
    
    /**
     * constructor, validates the given double value
     * @param value double
     */
    public Sample(double value)
    {
        this.value = value;
        
        //validates value
        if (value > -900)
        {
            valid = true;
        }
        else
        {
            valid = false;
        }
    }

    /**
     * gets value
     * @return value double
     */
    public double getValue() 
    {
        return value;
    }

    /**
     * returns the value of valid
     * @return valid double
     */
    public boolean isValid() 
    {
        
        return valid;
    }
    
    /**
     * returns a properly formatted string describing this object
     * @return a proper formatted String
     */
    public String toString() 
    {
        String returnStr = "";
        //return value if valid and "invalid" otherwise
        if (valid) 
        {
            returnStr = String.format("%.4f", this.value);
        }
        else
        { 
            returnStr = "invalid";
        }
        return (returnStr);
    }
    
    /**
     * Compare this Sample with another Sample
     *     
     * @param s Sample to compare with
     * @return true if both Samples are valid AND this is strictly larger than s
     *                OR if this is valid and s is not valid
     */
    public boolean isGreaterThan(Sample s)
    {
        // Replace s if it is invalid
        if (!s.valid)
        {
            return true;
        }
        // Otherwise, do not replace if *this* is invalid
        if (!this.valid)
        {
            return false;
        }
        
        // At this point: both are valid.  We can compare values
        if (this.value > s.value)
        {
            // Greater than
            return true;
        }

        // Not greater than
        return false;
    }
    
    /**
     * Compare this Sample with another Sample
     *     
     * @param s Sample to compare with
     * @return true if both Samples are valid AND this is strictly less than s
     *                OR if this is valid and s is not valid
     */
    public boolean isLessThan(Sample s)
    {
        // Replace s if it is invalid
        if (!s.valid)
        {
            return true;
        }
        // Otherwise, do not replace if *this* is invalid
        if (!this.valid)
        {
            return false;
        }
        
        // At this point: both are valid.  We can compare values
        if (this.value < s.value)
        {
            // Less than
            return true;
        }

        // Not less than
        return false;
    }
    
}
