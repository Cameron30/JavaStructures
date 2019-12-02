import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Lab 8
 *
 * Driver, runs user through
 * the process of selecting their first Pokemon.
 *
 * @author Nicholas, modified by Cameron
 * @version 2016-10-08
 */
public class Driver
{
    /**
     * Maps short strings to members of the Pokemon enumeration.
     */
    private static HashMap<String, Pokemon> pokemonMap = 
        new HashMap<String, Pokemon>();

    /**
     * Prompts the user to either choose a Pokemon or
     * list all Pokemon.  Prints out information about
     * the chosen Pokemon or all Pokemon in pokemonMap.
     *
     * @param args Command line arguments.
     * @throws IOException Error during I/O operation.
     */
    public static void main(String[] args) throws IOException 
    {
        // Setup program to read user input.
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        String input; // The user's input.
        String pokemonChoice; // The Pokemon chosen by the user.
        int menuChoice; // The menu option chosen by the user.

        // Populate the Pokémon HashMap
        pokemonMap.put("CHR", Pokemon.CHARMANDER);
        pokemonMap.put("SQR", Pokemon.SQUIRTLE);
        pokemonMap.put("BLB", Pokemon.BULBASAUR);
        
        

        //print the menu options
        System.out.println("Professor Oak, the Pokemon professor, presents"
            + " you with three pokeballs - and tells you that you can choose"
            + " one as your first Pokemon!\nPlease select an option:");

        System.out.println("1: Choose a Pokemon");
        System.out.println("2: List all Pokemon");

        while (true) // Loop until the user chooses a valid menu option.
        {
            try
            {
                input = br.readLine();
                menuChoice = Integer.parseInt(input);
                
                if (menuChoice <= 0 || menuChoice > 2)
                {
                    System.out.println("Please choose either 1 or 2.");
                }
                else
                {
                    break;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter an integer.");
            } 
        }
        
        switch(menuChoice)
        {
            case 1:
            {
                // List the Pokemon that the user can choose from.
                System.out.println(
                    "Please choose from the following Pokemon: " +
                    pokemonMap.keySet());

                pokemonChoice = br.readLine().toUpperCase();

                /* Loop until the user has entered something that
                 * is in the pokemonMap's set of keys.
                 */
                while (pokemonMap.get(pokemonChoice) == null)
                {
                    System.out.println(
                        "Please choose one of the Pokemon listed.");

                    pokemonChoice = br.readLine().toUpperCase();
                }
                
                /* Extract the information about the Pokemon & print out the 
                * information
                */
                Pokemon pokemon = pokemonMap.get(pokemonChoice);
                
                System.out.printf("You choose %s.\n", pokemon);

                PokemonType pokemonType = pokemon.getPokemonType();

                //prints effective types
                System.out.print(String.format("Your %s type Pokemon is weak "
                        + "against %s types and strong against %s types.\n",
                        pokemonType, pokemonType.weakAgainst(),
                        pokemonType.effectiveAgainst()));

                break;
            }

            case 2:
            {
                //print the pokemon available
                System.out.printf("SQR - %s\nBLB - %s\nCHR - %s", 
                        Pokemon.SQUIRTLE, Pokemon.BULBASAUR, 
                        Pokemon.CHARMANDER);
                break;
            }
            default:
            {
                //nothing happens in the default but eclipse sucks
                System.out.println("This will never be reached");
            }
        }
    }
}
