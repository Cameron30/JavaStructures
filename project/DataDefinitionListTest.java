import java.io.IOException;

/**
 * tests data definition list
 * @author cameron / justin
 * @version 10262016
 */
public class DataDefinitionListTest 
{

    /**
     * tests constructor
     * @throws IOException if error occurs
     */
    public void constructorTest() throws IOException
    {
        DataDefinitionList statDef = new 
                DataDefinitionList("data/DataTranslation.csv");
        System.out.println(statDef);
    }
}
