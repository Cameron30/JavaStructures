/**
 * 
 * @author Cameron
 * @version 10142016
 * Nature enum
 */
public enum Nature {

    /**
     * The brave nature.
     */
    BRAVE,

    /**
     * The quiet nature.
     */
    QUIET,

    /**
     * The relaxed nature.
     */
    RELAXED;
    
    /**
     * @return the lower case name
     */
    public String toString()
    {
        return name().toLowerCase();
    }
}
