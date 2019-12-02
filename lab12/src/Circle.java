import java.awt.Color;
import java.awt.Point;

/**
 * @author CS2334
 * @version 20161103 This class is for a circle.
 */

public class Circle extends Oval
{

    /**
     * Make Eclipse happy.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor which calls Oval's constructor
     * 
     * @param pointUL Upper left corner of the bounding box
     * @param diameter Diameter of the circle
     * @param color Desired color for the circle
     * @param filled True if the circle should be filled solid
     */
    public Circle(Point pointUL, int diameter, Color color, boolean filled)
    {
        // call to Oval constructor with diameter1 and diameter2 the same
        super(pointUL, diameter, diameter, color, filled);
    }

    /**
     * Get the diameter of the circle
     * 
     * @return diameter1 The diameter
     */
    public int getDiameter()
    {
        return getDiameter1();
    }
}
