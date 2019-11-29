import java.io.*;
import java.util.ArrayList;

/**
 * 
 * @author Cameron
 * @version 09092016
 */
public class PokemonTeam 
{
    //creatures is available to all methods within the class
    private ArrayList<Pokemon> creatures = new ArrayList<Pokemon>();
    
    /**
     * 
     * @param fileName name of csv file to be read
     * @throws IOException magic
     * Reads each line and inputs into a pokemon array
     */
    public PokemonTeam(String fileName) throws IOException 
    {
        //creates reader
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        
        //throws away first line of text
        String line = br.readLine();
        line = br.readLine();
        
        //adds line of text as a new pokemon object
        while (line != null) {
            Pokemon temp = new Pokemon(line);
            creatures.add(temp);
            line = br.readLine();
        }
        //closes reader for other users
        br.close();
    }
    
    /**
     * Sorts through pokemon for three different specifications.
     * @return the correctly sorted pokemon
     */
    public String toString() 
    {
        //Creates a temporary pokemon with correct specifications
        Pokemon temp = new Pokemon("4,Charmander,Fire,,309,39,52,43,60,50,65,"
                + "1,FALSE");
        
        //Starts the string
        String finale = "First Generation Legendary Pokemon:\n\n";
        
        //If firstGenLegendary, then adds to string
        for (int i = 0; i < creatures.size(); ++i) 
        {
            temp = creatures.get(i);
            if (temp.isFirstGenLegendary() ) {
                finale += temp.toString();
                finale += "\n";
            }
        }
        
        //title for next group
        finale += "\n\nThird Generation Psychic Pokemon:\n\n";
        
        //if thirdGenPsychic then add to string
        for (int i = 0; i < creatures.size(); ++i) 
        {
            temp = creatures.get(i);
            if (temp.isThirdGenPsychic() ) {
                finale += temp.toString();
                finale += "\n";
            }
        }
            
        //next title
        finale += "\n\nLegendary Water Pokemon:\n\n";
        
        //if legendaryWater then add to String
        for (int i = 0; i < creatures.size(); ++i) 
        {
            temp = creatures.get(i);
            if (temp.isLegendaryWater() ) {
                finale += temp.toString();
                finale += "\n";
            }
        }
        return finale;
    }

}
