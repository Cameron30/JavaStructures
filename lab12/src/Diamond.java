import java.awt.Color;
import java.awt.Point;

/**
 * This is the diamond class. The diamond it draws is a square rotated 45
 * degrees. The point provided for the diamond is the left point.
 * 
 * @author Daniel
 * @version 20161103
 *
 */
public class Diamond extends MyPolygon
{

    /**
     * Make Eclipse happy.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor for the diamond class.
     * 
     * @param leftCorner Point that represents the left hand point.
     * @param edgeLength The length of all four edges.
     * @param color The color of the diamond.
     * @param filled Indicates filled/unfilled for the diamond.
     */
    public Diamond(Point leftCorner, int edgeLength, Color color,
                    boolean filled)
    {
        // call to MyPolygon constructor
        super(color, filled);
        // initialize location
        location = new Point[4];
        // calculate the inner length of the of one of the isosceles triangles
        // making up the diamond.  This is half of the distance between
        // opposite points in the diamond
        int delta = (int) (edgeLength / Math.sqrt(2));
        // left point
        location[0] = leftCorner;
        // lower point
        location[1] = new Point(leftCorner.x + delta, leftCorner.y + delta);
        // right point
        location[2] = new Point(leftCorner.x + 2 * delta, leftCorner.y);
        // upper point
        location[3] = new Point(leftCorner.x + delta, leftCorner.y - delta);
    }
}
