import java.awt.Color;
import java.awt.Point;

/**
 * @author CS2334. Modified by: Cameron Ray
 * @version 20161018
 *         This class is for a rectangle shape.
 */

public class Rectangle extends Polygon
{
    
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
        super(color, filled);
        this.location = new Point[4];
        this.location[0] = pointUL;
        this.location[2] = new Point(pointUL.x + height, pointUL.y + width);
        this.location[3] = new Point(pointUL.x, pointUL.y + width);
        this.location[1] = new Point(pointUL.x + height, pointUL.y);
    }
}