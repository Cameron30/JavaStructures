
import java.awt.Color;
import java.awt.Point;

import javax.swing.JFrame;

/**
 * @author CS2334. Modified by: Cameron
 * @version 21061018
 *         This class extends JFrame and contains the main method.
 */
public class DrawFrame extends JFrame
{
    private static final long serialVersionUID = 1L;
    private static DrawPanel drawPanel;

    /**
     * The DrawFrame constructor.
     * @param title The title of the frame.
     */
    public DrawFrame(String title)
    {
        super(title);

        // build the shapes
        //TODO Create the shapes that will represent Pikachu
        Rectangle sky = new Rectangle(new Point(0, 0), 600, 
                800, Color.blue, true);
        Rectangle ground = new Rectangle(new Point(0, 400), 
                200, 800, Color.green, true);
        
        Triangle ear1 = new Triangle(new Point(350, 250), 15,
                -60, Color.YELLOW, true);
        Triangle ear2 = new Triangle(new Point(400, 250), 15,
                -60, Color.YELLOW, true);
        
        
        Diamond top = new Diamond(new Point(500, 300), 50, 
                Color.ORANGE, true);
        Diamond bottom = new Diamond(new Point(500, 350), 
                50, Color.YELLOW, true);
        
        Oval head = new Oval(new Point(400, 300), 50, 50, Color.YELLOW, true);
        Oval body = new Oval(new Point(400, 300), 50, 50, Color.YELLOW, true);
        /*
        Circle cheek1 = new Circle(new Point(400, 300), 50, Color.RED, false);
        Circle cheek2 = new Circle(new Point(400, 300), 50, Color.RED, false);
        
        Circle eye1 = new Circle(new Point(400, 300), 50, Color.BLACK, false);
        Circle eye2 = new Circle(new Point(400, 300), 50, Color.BLACK, false);
        */
        // create the panel and add the shapes to it
        
        drawPanel = new DrawPanel();
        
        drawPanel.addShape(sky);
        drawPanel.addShape(ground);
        
        drawPanel.addShape(ear1);
        drawPanel.addShape(ear2);
     
        drawPanel.addShape(top);
        drawPanel.addShape(bottom);
        
        drawPanel.addShape(head);
        drawPanel.addShape(body);
        /*
        drawPanel.addShape(cheek1);
        drawPanel.addShape(cheek2);
        
        drawPanel.addShape(eye1);
        drawPanel.addShape(eye2);
        */
        
        
        // add panel to frame
        add(drawPanel);

        // finish setting up frame
        this.setSize(800, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        
        drawPanel.paintComponent(super.getGraphics());
    }
    
    /**
     * The main method of this lab.
     * @param args Command line arguments.
     */
    public static void main(String[] args)
    {
        DrawFrame frame = new DrawFrame("Pikachu");
        // Force Web-Cat to not be unhappy with not using
        // the "frame" variable
        frame.getTitle();
    }

}
