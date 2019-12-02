import java.awt.Color;
import java.awt.Point;

/**
 * @author CS2334. Modified by: Cameron
 * @version 20161018
 */
public class Circle extends Oval
{

    /**
     * constructor
     * @param pointUL beginning point
     * @param diameter of circle
     * @param color of circle
     * @param filled boolean
     */
    public Circle(Point pointUL, int diameter, Color color,
                    boolean filled)
    {
        super(pointUL, diameter, diameter, color, filled);
        this.location = new Point[4];
        
        this.location[0] = pointUL;
        this.location[2] = new Point(pointUL.x + diameter, pointUL.y);
        this.location[3] = new Point(pointUL.x + diameter, pointUL.y - 
                diameter);
        this.location[1] = new Point(pointUL.x, pointUL.y - diameter);
    }
    
    /**
     * @return int for diameter
     */
    public int getDiameter()
    {
        return super.getDiameter1();
    }
}
