/**
 * @author Cameron
 * @version 8/25/16
 * Lab 1
 * 
 * Planning class
 * */
public class Planning
{

    private String[] info = new String[4];

    /**
     * 
     * @param input String input by user and passed from Driver.
     */
    public Planning(String input) 
    {
        //creates temporary array for splitting
        String[] tempArr = new String[3];
        tempArr = input.split(",");
        
        //gathers numbers from input
        int students = Integer.parseInt(tempArr[1]);
        int maxSize = Integer.parseInt(tempArr[2]);
        
        //creates a whole number amount of classes
        int classNum = (students + maxSize - 1) / maxSize;
            
        //puts proper forms of the strings into the array
        String classesStr = Integer.toString(classNum);
        tempArr[0].toUpperCase();
        info[0] = tempArr[0].toUpperCase();
        info[1] = tempArr[1];
        info[2] = tempArr[2];
        info[3] = classesStr;
    }

    /**
     * Forms the String required from the information given.
     * @return a string with the correct output
     */
    public String toString()
    {
        String output;
        output = String.format("CLASS: %s, Enrolled: %s, Max class size: %s, "
                + "Sections: %s", info[0], info[1], info[2], info[3]);
        return output;
        
    }
}
