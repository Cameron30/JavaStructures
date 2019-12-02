import java.awt.Color;
import java.awt.Point;

/**
 * @author CS2334. Modified by: ?????
 * @version 20161103 This class is for a rectangle shape.
 */

public class Rectangle extends MyPolygon
{

    /**
     * Make Eclipse happy
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor for the Rectangle class
     * 
     * @param pointUL Upper left corner of the rectangle
     * @param width Width of the rectangle
     * @param height Height of the rectangle
     * @param color Desired color for the rectangle
     * @param filled Whether or not the rectangle should be filled solid
     */
    public Rectangle(Point pointUL, int width, int height, Color color,
                    boolean filled)
    {
        // call to MyPolygon constructor
        super(color, filled);
        // initialize location
        this.location = new Point[4];
        // upper left
        this.location[0] = pointUL;
        // lower left
        this.location[1] = new Point(pointUL.x, pointUL.y + height);
        // lower right
        this.location[2] = new Point(pointUL.x + width, pointUL.y + height);
        // upper right
        this.location[3] = new Point(pointUL.x + width, pointUL.y);
    }
}