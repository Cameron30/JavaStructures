import java.awt.Color;
import java.awt.Point;

/**
 * @author CS2334
 * @version 20161103 This class is for a square.
 */

public class Square extends Rectangle
{

    /**
     * Make Eclipse happy
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor which calls Rectangle's constructor.
     * 
     * @param pointUL Upper left corner of the square
     * @param width Width (and height) of the square
     * @param color Desired color for the square
     * @param filled True if the square should be filled solid
     */
    public Square(Point pointUL, int width, Color color, boolean filled)
    {
        // call to Rectangle constructor with height and width being the same.
        super(pointUL, width, width, color, filled);
    }
}
