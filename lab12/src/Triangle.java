import java.awt.Color;
import java.awt.Point;

/**
 * This class draws triangles.
 * 
 * @author Daniel
 * @version 20161103
 *
 */

public class Triangle extends MyPolygon
{

    /**
     * Make Eclipse happy
     */
    private static final long serialVersionUID = 1L;

    /**
     * Triangle constructor.
     * 
     * @param pointB A point on the base of an isosceles triangle.
     * @param base The width of the base.
     * @param height The height at the apex of the triangle.
     * @param color Desired color of the triangle.
     * @param filled Whether or not the trianlge should be filled.
     */
    public Triangle(Point pointB, int base, int height, Color color,
                    boolean filled)
    {
        // call to MyPolygon
        super(color, filled);
        // initialize location
        location = new Point[3];
        location[0] = pointB; // base corner of isosceles triangle
        location[1] = new Point(pointB.x + base, pointB.y); // other base pt
        // apex
        location[2] = new Point(pointB.x + base / 2, pointB.y + height);
    }
}
