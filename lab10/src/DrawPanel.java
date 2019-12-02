import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * @author CS2334. Modified by: Cameron
 * @version 20161018
 *         This class is a type of component.
 */
public class DrawPanel extends JPanel
{

    private static final long serialVersionUID = 1L;
    private ArrayList<Shape> shapeList = new ArrayList<Shape>();

    /**
     * This method adds shapes to the set of shapes.
     * 
     * @param shape The shape to be added to the set of shapes.
     */
    public void addShape(Shape shape)
    {
        shapeList.add(shape);
    }

    /**
     * This method draws the shapes in the set of shapes.
     * 
     * @param g A Graphics object
     */
    protected void paintComponent(Graphics g)
    {
        for (int i = 0; i < shapeList.size(); ++i)
        {
            shapeList.get(i).draw(g);
        }
    }
}
