import java.awt.Color;
import java.awt.Graphics;

/**
 * Polygon class
 * @author  Cameron
 * @version 10282016
 *
 */
public abstract class Polygon extends Shape
{

    /**
     * constructor
     * @param color of polygon
     * @param filled boolean
     */
    public Polygon(Color color, boolean filled)
    {
        super(color, filled);
    }

    /**
     * @param g graphics
     */
    @Override
    public void draw(Graphics g)
    {
        int[] xCoor = new int[location.length];
        int[] yCoor = new int[location.length];
        
        for (int i = 0; i < location.length; ++i)
        {
            xCoor[i] = location[i].x;
            yCoor[i] = location[i].y;
        }
        
        g.setColor(this.getColor());
        
        if (this.isFilled())
        {
            g.fillPolygon(xCoor, yCoor, location.length);
        } 
        else
        {
            g.drawPolygon(xCoor, yCoor, location.length);
        }
    }

}
