import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Panel in which drawing occurs.
 * 
 * @author CS2334. Modified by: Cameron Ray
 * @version 20161103
 */

public class DrawPanel extends JPanel
{
    /**
     * Makes Eclipse happy
     */
    private static final long serialVersionUID = 1L;
    /** The list of shapes to be drawn. */
    private ArrayList<Shape> shapeList = new ArrayList<Shape>();
    /** A temporary shape that is also drawn */
    private Shape tempShape;
    /** Index of chosen shape being edited */
    private int shapeIndex;

    /** Coordinates for button-down event. */
    private int x0;
    private int y0;
    /** Coordinates for button-up event. */
    private int x1;
    private int y1;
    /** Indicate if a shape is currently being drawn. */
    private boolean drawingFlag;

    /** Reference to the frame in which the panel is a member. */
    private DrawFrame frame;

    //////////////////////////////////////////////////////////////
    /**
     * Class defines the behavior inside of the drawing panel in response to
     * mouse events
     * 
     */
    public class MouseHandler extends MouseAdapter
    {
        /**
         * Respond to a button-down event.
         * 
         * @param e Mouse event
         */
        @Override
        public void mousePressed(MouseEvent e)
        {
            // Remember this starting coordinate
            x0 = e.getX();
            y0 = e.getY();

            // are we in edit mode?
            if (frame.isEditing())
            {
                // create point where the mouse was clicked
                Point mouseDown = new Point(x0, y0);

                // find which shape was clicked
                // loop through shapes in stack fashion, LIFO
                for (int i = 0; i < shapeList.size(); ++i)
                {
                    if (shapeList.get(i).contains(mouseDown))
                    {
                        // if the shape contains the point, set the shapeIndex
                        // to be the index in the shapeList
                        shapeIndex = i;
                    }
                }

                // find if the shape is filled
                // set fillBox to match the status of the shape
                frame.controlPanel.fillBox.setSelected(
                        shapeList.get(shapeIndex).isFilled());

                // get color of the shape
                // set the color of the frame to match the shape's color
                frame.controlPanel.colorChooser.setBackground(
                        shapeList.get(shapeIndex).getColor());
            }
            else if (frame.isDeleting()) // are we in delete mode?
            {
                // create point where the mouse was clicked
                Point mouseDown = new Point(e.getX(), e.getY());
                x0 = e.getX();
                y0 = e.getY();

                // find which shape was clicked
                // loop through shapes in stack fashion, LIFO
                for (int i = 0; i < shapeList.size(); ++i)
                {
                    // If the shape contains the point, prompt the user for
                    // a confirmation to delete
                    if (shapeList.get(i).contains(mouseDown))
                    {
                        int dialogButton = JOptionPane.YES_NO_OPTION;
                        int dialogResult = JOptionPane.showConfirmDialog(null, 
                                "Are you sure you want to delete this shape?",
                                "Confirmation", dialogButton);
                        
                        if (dialogResult == JOptionPane.YES_OPTION)
                        {
                            // Check answer
                            // If yes, remove the shape
                            shapeList.remove(i);
                        }
                    }
                }
            }
            else // we're drawing a shape
            {
                // Indicate that drawing of a shape has begun
                drawingFlag = true;
            }
        }

        /**
         * Respond to a button-up event.
         * 
         * @param e Mouse event
         */
        @Override
        public void mouseReleased(MouseEvent e)
        {

            // Are we currently drawing?
            if (drawingFlag)
            {
                // Yes - we are currently drawing

                // Coordinates of the cursor
                x1 = e.getX();
                y1 = e.getY();

                // Indicate that we are no longer drawing
                drawingFlag = false;

                // We no longer need a temporary shape
                tempShape = null;

                // Create the shape given the current state
                Shape newShape = createShape();
                

                // Add the shape to the panel list if the shape exists
                if (newShape != null)
                {
                    shapeList.add(newShape);
                }
                
                //repaint
                repaint();
            }
        }

        /**
         * Address a mouse movement event (movement only when the button is
         * down)
         * 
         * @param e Mouse event
         */
        @Override
        public void mouseDragged(MouseEvent e)
        {
            // Are we currently drawing a shape?
            if (drawingFlag)
            {
                // Yes
                // Note the current coordinates
                x1 = e.getX();
                y1 = e.getY();

                // Create a temporary shape
                tempShape = createShape();

                // repaint
                repaint();
            }
        }

        /**
         * Given the current state of the control panel and the selected points
         * in the draw panel, create a new shape.
         * 
         * @return The newly created shape
         */
        private Shape createShape()
        {
            // Identify the upper left and lower right coordinates
            int xUL = Math.min(x0, x1);
            int yUL = Math.min(y0, y1);
            int xLR = Math.max(x0, x1);
            int yLR = Math.max(y0, y1);

            // Create a new object, depending on what is selected
            if (frame.isOval())
            {
                // create and return an Oval
                Oval o = new Oval(new Point(xUL, yUL), 
                        xLR - xUL, yLR - yUL, frame.getColor(), 
                        frame.isFilled());
            }
            else if (frame.isRectangle())
            {
                // create and return a Rectangle
                Rectangle r = new Rectangle(new Point(xUL, yUL), 
                        xLR - xUL, yLR - yUL, frame.getColor(), 
                        frame.isFilled());
                return r;
            }
            else if (frame.isTriangle())
            {
                // create and return a Triangle
                Triangle t = new Triangle(new Point(xUL, yUL), 
                        xLR - xUL, yLR - yUL, frame.getColor(), 
                        frame.isFilled());
                return t;
            }
            else if (frame.isDiamond())
            {
                // 4 quadrants-ish; axis is y=|x| and y = -|x|
                // the coordinate frame is rotated 45 degrees

                // get the change in x and y directions
                int deltaX = x1 - x0;
                int deltaY = y1 - y0;

                // initialize a Point (has to have x,y values, set to zero here
                // but not significant - could be any numbers)
                Point start = new Point(0, 0);

                // initialize edge length to be zero, again, not significant -
                // just a placeholder
                int edgeLength = 0;

                if (deltaX >= 0 && Math.abs(deltaX) >= Math.abs(deltaY))
                {
                    // right quadrant

                    // start point is where the initial click was
                    start = new Point(x0, y0);
                    // calculate edge length
                    edgeLength = (int) ((x1 - x0) * Math.sqrt(2) / 2);
                }
                else if (deltaX < 0 && Math.abs(deltaX) >= Math.abs(deltaY))
                {
                    // left quadrant

                    // start point - same y, but x is where the mouse is
                    // released or at when being dragged
                    start = new Point(x1, y0);
                    // calculate edge length
                    edgeLength = (int) ((x0 - x1) * Math.sqrt(2) / 2);
                }
                else if (deltaY >= 0 && Math.abs(deltaY) >= Math.abs(deltaX))
                {
                    // bottom quadrant

                    // start point - x is initial x - 1/2 * change in y
                    // y is average of y values
                    start = new Point(x0 - (y1 - y0) / 2, (y1 + y0) / 2);
                    // calculate edge length
                    edgeLength = (int) ((y1 - y0) * Math.sqrt(2) / 2);
                }
                else if (deltaY < 0 && Math.abs(deltaY) >= Math.abs(deltaX))
                {
                    // top quadrant

                    // start point - x is initial x - 1/2 * change in y
                    // y is average of y values
                    start = new Point(x0 - (y0 - y1) / 2, (y1 + y0) / 2);
                    //calculate edge length
                    edgeLength = (int) ((y0 - y1) * Math.sqrt(2) / 2);
                }
                // create diamond
                Shape s = new Diamond(start, edgeLength, frame.getColor(),
                        frame.isFilled());
                // return shape
                return s;
            }
            // Should not get here, but be safe
            return null;
        }
    }

    //////////////////////////////////////////////////////////////
    /**
     * Constructor: Create the draw panel
     * 
     * @param frame The Frame in which the panel is embedded
     */
    public DrawPanel(DrawFrame frame)
    {
        this.frame = frame;

        // Border for the frame
        Border blackline = BorderFactory.createLineBorder(Color.black);
        this.setBorder(blackline);

        // Initially, we are currently not editing a shape
        drawingFlag = false;

        // Set the panel to be focusable: we will receive mouse events
        this.setFocusable(true);

        // Create a handler for the mouse events
        MouseHandler listener = new MouseHandler();

        // Listen for button events
        this.addMouseListener(listener);

        // Also listen for mouse movement events
        this.addMouseMotionListener(listener);
    }

    /**
     * This method adds shapes to the set of shapes.
     * 
     * @param shape The shape to be added to the list of shapes.
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
        if (shapeList != null)
        {
            for (int i = 0; i < shapeList.size(); ++i)
            {
                shapeList.get(i).draw(g);
            }
        }
        
        
        if (tempShape != null)
        {
            tempShape.draw(g);  
        }
        
    }

    /**
     * Return the list of shapes
     * 
     * @return The list of shapes
     */
    protected ArrayList<Shape> getShapeList()
    {
        return shapeList;
    }

    /**
     * Set the list of shapes to a new set
     * 
     * @param shapeList to copy into our panel
     */
    protected void setShapeList(ArrayList<Shape> shapeList)
    {
        if (shapeList != null)
        {
            this.shapeList = shapeList;
            repaint();
        }
    }

    /**
     * Remove all shapes from the list.
     */
    protected void clearShapeList()
    {
        shapeList.clear();
        repaint();
    }

    /**
     * Removed the selected shape from the shape list.
     * 
     * @param index The index of the selected shape.
     */
    protected void removeShape(int index)
    {
        shapeList.remove(index);
        repaint();
    }

    /**
     * Getter for shape index.
     * 
     * @return Index of the shape chosen by the user.
     */
    public int getShapeIndex()
    {
        return shapeIndex;
    }

}
