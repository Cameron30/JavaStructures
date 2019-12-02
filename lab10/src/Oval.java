import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * @author CS2334. Modified by: Cameron
 * @version 20161018
 *         This class is for an oval shape.
 */
public class Oval extends Shape
{
    private int diameter1;
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
        super(color, filled);
        this.diameter1 = diameter1;
        this.diameter2 = diameter2;
    }
    
    /**
     * returns diameter 1
     * @return int for diameter 1
     */
    public int getDiameter1()
    {
        return diameter1;
    }
    
    /**
     * returns diameter 2
     * @return int for diameter 2
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
        g.setColor(this.getColor());
        
        if (this.isFilled())
        {
            g.fillOval(location[0].x, location[0].y, diameter1, diameter2);
        } 
        else
        {
            g.drawOval(location[0].x, location[0].y, diameter1, diameter2);
        }
    }
}
