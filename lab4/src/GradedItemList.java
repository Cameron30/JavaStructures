import java.util.ArrayList;

/**
 * 
 * @author Cameron
 * @version 09162016
 */
public class GradedItemList 
{
    /**
     * An arrayList of graded items.
     */
    private ArrayList<GradedItem> gradedItem = new ArrayList<GradedItem>();
    
    /**
     * A graded item is added to the array list
     * @param item of GradedItem class
     */
    public void addItem(GradedItem item) 
    {
        //adds item to array list
        gradedItem.add(item);
    }
    
    /**
     * Averages grades
     * @return number corresponding to the average grade
     */
    public double averageGrade() 
    {
        double average = 0;
        int amount = 0;
        int total = 0;
        //loops to add amount of items and total of items
        for (int i = 0; i < gradedItem.size(); ++i)
        {
            amount += 1;
            total += gradedItem.get(i).getGrade();
        }
        //finds and returns average
        if (amount != 0)
        {
            average = total / amount;
        } 
        else
        {
            average = total;
        }
        
        return (average);
    }

    /**
     * Lists items row after row
     * @return List of Graded Items.
     */
    public String toString() 
    {
        String answer = "";
        //loops to make proper output
        for (int i = 0; i < gradedItem.size(); ++i)
        {
            answer += gradedItem.get(i).toString();
            answer += "\n";           
        }
        //returns output
        return (answer);
    }
    
}
