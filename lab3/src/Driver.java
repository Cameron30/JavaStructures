import java.io.IOException;

/**
 * 
 * @author Cameron
 *@version 09092016
 */
public class Driver 
{

    /**
     * 
     * @param args Magic
     * @throws IOException still magic to me
     * Creates a pokemon team then prints it.
     */
    public static void main(String[] args) throws IOException 
    {
        //creation of new pokemon team.
        PokemonTeam team = new PokemonTeam("Pokemon.csv");
        
        //calls upon PokemonTeam.toString()
        System.out.println(team);
    }

}
