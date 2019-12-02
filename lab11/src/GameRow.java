/**
 * @author CS2334. Modified by: ?????
 *         <P>
 * @version 2016-11-01 <BR>
 *         Lab 11
 *         <P>
 * 
 *         This class represents a row in the game
 */
public class GameRow
{
    // Is this row empty?
    private boolean isEmptySpace;

    // Is this the final row to be created?
    private boolean isFinalRow;

    // Where is the empty position in this row?
    private int freePosition;

    /**
     * Constructor
     */
    public GameRow()
    {
        // create an empty row
        this.isEmptySpace = true;
        this.freePosition = -1;
        this.isFinalRow = false;
    }

    /**
     * Construct a row with a freePosition
     * 
     * @param freePosition
     *            a free position in the row of images
     * @param finalRow
     *            True if the row is to be the final one in the game
     */
    public GameRow(int freePosition, boolean finalRow)
    {
        this.isEmptySpace = false;
        this.isFinalRow = finalRow;
        this.freePosition = freePosition;
    }

    /**
     * Is this an empty row?
     * 
     * @return true if empty
     */
    public boolean isEmptySpace()
    {
        return isEmptySpace;
    }

    /**
     * Where is the free position?
     * 
     * @return true if position is free
     */
    public int getFreePosition()
    {
        return freePosition;
    }

    /**
     * Is this the final row?
     * 
     * @return true if this game row is the final row
     */
    public boolean isFinalRow()
    {
        return isFinalRow;
    }
}
