import java.awt.Color;
import java.awt.Point;

/**
 * This class creates triangles.
 * 
 * @author Daniel
 * @version 20161018
 *
 */

public class Triangle extends Polygon
{

    /**
     * Triangle constructor.
     * 
     * @param pointB A point on the base of an isosceles triangle.
     * @param base The width of the base.
     * @param height The height at the apex of the triangle.
     * @param color Desired color of the triangle.
     * @param filled Whether or not the triangle should be filled.
     */
    public Triangle(Point pointB, int base, int height, Color color,
                    boolean filled)
    {
        super(color, filled);
        
        this.location = new Point[3];
        this.location[0] = pointB;
        this.location[1] = new Point(pointB.x + (base / 2), pointB.y + height);
        this.location[2] = new Point(pointB.x + base, pointB.y);
        
    }
}
