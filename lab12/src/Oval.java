import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

/**
 * @author CS2334
 * @version 20161103 This class is for an oval shape.
 */

public class Oval extends Shape
{
    /**
     * Make Eclipse happy
     */
    private static final long serialVersionUID = 1L;
    /** length of first diameter of ellipse */
    private int diameter1;
    /** length of second diameter of ellipse */
    private int diameter2;

    /**
     * Constructor for Oval shapes
     * 
     * @param pointUL Upper left corner of the bounding box
     * @param diameter1 Diameter from left to right
     * @param diameter2 Diameter from top to bottom
     * @param color Desired color of the oval
     * @param filled Whether or not the oval should be filled
     */
    public Oval(Point pointUL, int diameter1, int diameter2, Color color,
                    boolean filled)
    {
        // call to parent constructor
        super(color, filled);
        // set first and second diameters
        this.diameter1 = diameter1;
        this.diameter2 = diameter2;
        //initialize location
        this.location = new Point[1];
        //set upper left corner of ellipse
        this.location[0] = pointUL;
    }

    /**
     * Get the first diameter
     * 
     * @return diameter1 The diameter from left to right
     */
    public int getDiameter1()
    {
        return diameter1;
    }

    /**
     * Get the second diameter
     * 
     * @return diameter2 The diameter from top to bottom
     */
    public int getDiameter2()
    {
        return diameter2;
    }

    /**
     * This method determines whether to draw a filled shape or an outline, and
     * then creates the shape accordingly.
     * 
     * @param g A Graphics object
     */
    @Override
    public void draw(Graphics g)
    {
        // set the color
        g.setColor(this.getColor());
        if (this.isFilled())
        {
            // if it's filled, draw a filled oval
            g.fillOval(location[0].x, location[0].y, diameter1, diameter2);
        }
        else
        {
            // unfilled, draw an outline of an oval
            g.drawOval(location[0].x, location[0].y, diameter1, diameter2);
        }
    }

    @Override
    public boolean contains(Point p)
    {
        // construct an Ellipse2D.Double object with the same parameters
        Ellipse2D.Double ellipse = new Ellipse2D.Double(location[0].x,
                        location[0].y, diameter1, diameter2);
        // does the ellipse contain the point passed in?
        return ellipse.contains(p);
    }
}
