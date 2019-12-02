/**
 * 
 * @author Cameron
 * @version 10082016
 * Fate cards
 */
public enum Fate {
    /** Revolution value */
    REVOLUTION("You are the Plebeian"),
    /** Patrician value */
    RICHES("You are the Emperor");
    
    private String playersFate;
    
    /**
     * Character Enum constructor.
     * @param playersFate  The respective string of the 
     *                  character card being made
     */
    private Fate(String playersFate)
    {
        this.playersFate = playersFate;
    }
    
    /**
     * Turn the Enum into a string
     * 
     * @return String representation of the character
     */
    public String toString()
    {
        return playersFate;
    }

}
