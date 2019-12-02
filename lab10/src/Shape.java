import java.awt.Color;
import java.awt.Point;

/**
 * @author CS2334. 
 * @version 20161018
 *         This class holds the location and color of the shape, as well as
 *         whether the shape is filled.
 *         
 *         This class is complete.  Do not change it.
 */

public abstract class Shape implements Drawable
{
    /**
     * The array of points that define the location of the shape object.
     */
    protected Point[] location;
    /**
     * The color of the shape object.
     */
    private Color color;
    /**
     * The boolean indicating if the shape is filled or just an outline.
     */
    private boolean filled;

    /**
     * Constructor
     * 
     * @param color Color of the shape.
     * @param filled Boolean value determining whether the shape is filled.
     */
    public Shape(Color color, boolean filled)
    {
        this.color = color;
        this.filled = filled;
    }

    /**
     * Get the color of the shape
     * 
     * @return color The shape's color
     */
    public Color getColor()
    {
        return color;
    }

    /**
     * See whether the shape is filled with color or not
     * 
     * @return filled True if the shape if filled.
     */
    public boolean isFilled()
    {
        return filled;
    }

    /**
     * Get the location of the shape
     * 
     * @return location The array representing the shape's location
     */
    public Point[] getLocation()
    {
        return location;
    }
}
