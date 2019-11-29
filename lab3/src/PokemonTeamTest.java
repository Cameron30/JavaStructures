
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

/**
 * Simple team test class.  
 * 
 * Checks the output given a small number of matching Pokemon
 * 
 * @author Cameron
 * @version 09092016
 */
public class PokemonTeamTest 
{

    /**
     * Test team with simple file.
     * 
     * @throws IOException If an error occurs during parsing
     */
    @Test
    public void testTeamSimple() throws IOException
    {
        // Create the team object
        PokemonTeam team = new PokemonTeam("PokemonTest.csv");
        
        // Assemble the expected output
        String expectedOutput = "First Generation Legendary Pokemon:\n\n";
        expectedOutput += "MewtwoMega Mewtwo Y       Psychic";
        expectedOutput += "                   Generation: 1     Legendary\n";
        expectedOutput += "\n\nThird Generation Psychic Pokemon:\n\n";
        expectedOutput += "\n\nLegendary Water Pokemon:\n\n";
        
        // Check expected against what is produced
        Assert.assertEquals(expectedOutput, team.toString());
        
    }

}
