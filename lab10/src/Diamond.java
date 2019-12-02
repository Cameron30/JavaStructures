import java.awt.Color;
import java.awt.Point;

/**
 * 
 * @author Cameron
 * @version 10282016
 */
public class Diamond extends Polygon
{

    /**
     * constructor
     * @param leftCorner of diamond
     * @param edgeLength of diamond
     * @param color of diamond
     * @param filled boolean
     */
    public Diamond(Point leftCorner, int edgeLength, Color color,
                    boolean filled)
    {
        super(color, filled);
        this.location = new Point[4];
        this.location[0] = leftCorner;
        this.location[2] = new Point(leftCorner.x + edgeLength, leftCorner.y);
        this.location[3] = new Point(leftCorner.x + (edgeLength / 2),
                leftCorner.y + (edgeLength / 2));
        this.location[1] = new Point(leftCorner.x + (edgeLength / 2),
                leftCorner.y - (edgeLength / 2));
    }
}
