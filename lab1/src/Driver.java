import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Cameron
 * @version 8/25/16
 * Lab 1
 * 
 * Gathers input from user, then calls on Planning to create an output.
 * */
public class Driver
{

    /**
     * Gets input from the user, then calls upon an instance
     *  of Planning to create a string, then outputs it.
     * 
     * @param args takes String array
     * @throws IOException Magic!
     */
    public static void main(String[] args) throws IOException
    {
        //Gets input from user
        BufferedReader br = new BufferedReader(new 
                InputStreamReader(System.in));
        String input = br.readLine();
        
        //calls upon plan to concatenate the string
        Planning plan = new Planning(input);     
        System.out.println(plan.toString());
        
        br.close();
    }

}
