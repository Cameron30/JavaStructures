import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the Calculator class
 * @author Cameron
 * @version 09232016
 */
public class CalculatorTest 
{
    
    /**
     * Tests compute without mess ups
     * @throws CalculatorException if an error occurs
     */
    @Test
    public void validInputTest() throws CalculatorException 
    {
        //tests the normal inputs
        Assert.assertEquals(9, Calculator.compute(new String[]{"4", "+", 
            "5"}));
        Assert.assertEquals(-1, Calculator.compute(new String[]{"4", "-",
            "5"}));
        Assert.assertEquals(20, Calculator.compute(new String[]{"4", "*",
            "5"}));
        Assert.assertEquals(0, Calculator.compute(new String[]{"4", "/",
            "5"}));
        Assert.assertEquals(4, Calculator.compute(new String[]{"4", "%",
            "5"}));
    }

    /**
     * Tests the division and mod by zero
     * @throws CalculatorException when error occurs
     */
    @Test
    public void divideByZeroTest() throws CalculatorException
    {
        //Tries dividing by zero
        try 
        {
            Calculator.compute(new String[]{"9", "/", "0"});
        } 
        catch (CalculatorException e) {
            Assert.assertEquals("Divide by zero error.", e.getMessage());
        }
        
        //tries modding by 0
        try 
        {
            Calculator.compute(new String[]{"9", "%", "0"});
        } 
        catch (CalculatorException e) {
            Assert.assertEquals("Mod by zero error.", e.getMessage());
        }
    }
    
    /**
     * Computes too many or few
     * @throws CalculatorException when error occurs
     */
    @Test
    public void notCorrectAmountTest() throws CalculatorException
    {
        try 
        {
            Calculator.compute(new String[]{"9", "%", "0", "9"});
        } 
        catch (CalculatorException e) {
            Assert.assertEquals("Illegal input.", e.getMessage());
        }
    }
    
    /**
     * Tests quitting program
     * @throws CalculatorException if error occurs
     */
    @Test
    public void quitTest() throws CalculatorException
    {
        try 
        {
            Calculator.compute(new String[]{"noQuIt"});
        } 
        catch (CalculatorException e) {
            Assert.assertEquals("Illegal input.", e.getMessage());
        }
        
        try 
        {
            Calculator.compute(new String[]{"qUIt"});
        } 
        catch (CalculatorException e) {
            Assert.assertEquals("Exit.", e.getMessage());
        }
    }
    
    /**
     * Tests for all possibilities in two tokens
     * @throws CalculatorException when error occurs
     */
    @Test
    public void twoTokenTest() throws CalculatorException 
    {
        try 
        {
            Calculator.compute(new String[]{"*", "1"});
        } 
        catch (CalculatorException e) {
            Assert.assertEquals("Illegal operator.", e.getMessage());
        }
        
        Assert.assertEquals(-100, Calculator.compute(new String[]{"-", 
            "100"}));
    }
    
    /**
     * tests the parseAndCompute function
     */
    @Test
    public void parseAndComputeTest()
    {
        Assert.assertEquals(false, Calculator.parseAndCompute("9 + 10"));
    }
}

