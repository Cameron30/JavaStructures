/**
 * Character enumerated data type
 * 
 * Contains three characters:
 *      EMPEROR - wins against PATRICIAN
 *      PATRICIAN - wins against PLEBEIAN
 *      PLEBEIAN   - wins against EMPEROR
 * 
 * @author Taner
 * @version 29092016
 *
 */
public enum Character 
{
    /** Emperor value */
    EMPEROR("Emperor"),
    /** Patrician value */
    PATRICIAN("Patrician"),
    /** Plebeian value */
    PLEBEIAN("Plebeian");
    
    private String cardName;
    
    /**
     * Character Enum constructor.
     * @param cardName  The respective string of the 
     *                  character card being made
     */
    private Character(String cardName)
    {
        this.cardName = cardName;
    }
    
    /**
     * Turn the Enum into a string
     * 
     * @return String representation of the character
     */
    public String toString()
    {
        return cardName;
    }
}
