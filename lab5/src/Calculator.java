
/**
 * 
 * @author CS2334, modified by Cameron Ray
 * 
 * @version 2016-09-22
 * Lab 5
 * 
 * The Calculator class provides functionality for parsing input strings
 * that contain simple expressions and for computing the result of the 
 * expression.
 *
 */
public class Calculator {
    /**
     * Compute the result of the expression encoded in a sequence of tokens.
     * 
     * Here are the different cases:
     * 0 tokens: CalculatorException: "Illegal input."
     * 1 token: 
     *      "quit" (any casing): CalculatorException: "Exit." with quit = 
     *      true
     *      All other cases: CalculatorException: "Illegal input."
     * 2 tokens:
     *      "-" and any number: return negative of number
     *      "-" and not a number: CalculatorException: "Illegal argument."
     *      other string and any string: CalculatorException: "Illegal 
     *      operator."
     * 3 tokens:
     *      number1, "+", number2: return sum of two numbers
     *      number1, "-", number2: return difference of two numbers 
     *      (number1 - number2)
     *      number1, "*", number2: return product of two numbers
     *      number1, "/", zero: CalculatorException: "Divide by zero error."
     *      number1, "/", not zero: return number1/number2
     *      number1, "%", zero: CalculatorException: "Mod by zero error."
     *      number1, "%", not zero: return number1%number2
     *      
     *      not a number, anything, anything: CalculatorException: 
     *      "Illegal argument."
     *      number1, anything, not a number: CalculatorException: 
     *      "Illegal argument."
     *      number1, not an operator, number2: CalculatorException: 
     *      "Illegal operator."
     * 4 or more tokens: CalculatorException: "Illegal input."
     *      
     * 
     * @param tokens The array of tokens to evaluate
     * @return int result of evaluating the expression
     * @throws CalculatorException If some form of error has been generated or
     * "quit" has been typed
     */
    public static int compute(String[] tokens) throws CalculatorException
    {
        //answer is declared
        int answer;
        // Condition on the number of tokens
        switch(tokens.length)
        {
            case 0: 
                //no input throw
                throw new CalculatorException("Illegal input.");
        
            case 1: 
                //if "quit" then exit, otherwise throw error
                if (tokens[0].equalsIgnoreCase("quit"))  
                {    
                    throw new CalculatorException("Exit.", true);
                } 
                else
                {
                    throw new CalculatorException("Illegal input.");
                }
        
            case 2: 
                //if proper operator, do math, or else throw error
                if (tokens[0].equals("-"))
                {
                    answer = 0 - Integer.parseInt(tokens[1]);
                    //returns the answer if no exceptions thrown
                    return answer;
                } 
                else
                {
                    throw new CalculatorException("Illegal operator.");
                }
            
            case 3: 
                //if parsing fails, throw NumberExceptionError
                int num1 = Integer.parseInt(tokens[0]);
                int num2 = Integer.parseInt(tokens[2]);
                //Embedded switch to tell operators
                switch(tokens[1])
                {
                    case "+":
                        //adds ints
                        answer = num1 + num2;
                        break;
                    case "-":
                        //subtracts ints
                        answer = num1 - num2;
                        break;
                    case "*":
                        //multiplies ints
                        answer = num1 * num2;
                        break;
                    case "/":
                        //divides ints
                        if (num2 != 0)
                        {
                            answer = num1 / num2;
                            break;    
                        }
                        throw new CalculatorException("Divide by zero error.");
                    //mods ints
                    case "%":
                        if (num2 != 0)
                        {
                            answer = num1 % num2;
                            break;    
                        }
                        throw new CalculatorException("Mod by zero error.");
                    //else throw error   
                    default:
                        throw new CalculatorException("Invalid operator.");
                }
                //returns answer
                return (answer);
                //if too many tokens, error
            default:
                // 4 or more tokens
                System.out.println("WHOA");
                throw new CalculatorException("Illegal input.");
            
        }

    }

    /**
     * Parse the input string as an expression and evaluate it.
     * 
     * If the input is a legal expression, then the result is printed
     * 
     * Otherwise a CalculatorException has occurred.  Print the exception
     * message.
     * 
     * @param input A String possibly containing a mathematical expression
     * @return true if the String is equal to "quit"; false otherwise
     */
    public static boolean parseAndCompute(String input)
    {
        // Pull out the tokens
        String[] tokens = input.split(" ");
        //tries to compute
        try 
        {
            int answer = compute(tokens);
            if (answer < 0 || answer >= 0) 
            {
                System.out.println(answer);  
            }
        }
        //catches error if improper numbers
        catch (NumberFormatException e) 
        {
            System.out.println("Invalid argument.");

        }
        //catches any other errors
        catch (CalculatorException e)
        {
            return e.isQuit();
        } 
        

        // Quit has not been specified
        return false;
    }
}
