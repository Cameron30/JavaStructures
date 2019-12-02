import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

/**
 * tests station definition list
 * @author cameron / justin
 * @version 10262016
 */
public class StationDefinitionListTest {

    /**
     * unit test method for contructor
     * @throws IOException if error occurs
     */
    @Test
    public void constructorTest() throws IOException
    {
        StationDefinitionList statDef = new StationDefinitionList(
                "data/geoinfo.csv");
//        System.out.println(statDef.);
        
        Assert.assertEquals("BOWL : BOWL Bowlegs Bowlegs 35.171560"
                + " -96.631210", statDef.toString());
    }
}
