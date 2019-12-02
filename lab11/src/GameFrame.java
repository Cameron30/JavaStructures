import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author CS2334. Modified by: Cameron
 *         <P>
 * @version 2016-11-01 <BR>
 *         Lab 11
 *         <P>
 * 
 *         Creates the frame and contains the key event
 */
public class GameFrame extends JFrame
{

    /**
     * Useful for serialization purposes (coming soon!)
     */
    private static final long serialVersionUID = 1L;

    // panel where the game exists
    private GamePanel panel;

    // width and height in pixels of the game panel
    private int width;
    private int height;

    /**
     * constructor
     * 
     * @param pokemon
     *            Reference to the pokemon being caught
     * @param width
     *            Width of frame in pixels
     * @param height
     *            Height of frame in pixels
     */
    public GameFrame(Pokemon pokemon, int width, int height)
    {
        this.width = width;
        this.height = height;

        panel = new GamePanel(width, height, pokemon);
        add(panel);

        // Set information about the JFrame
        getContentPane().setPreferredSize(new Dimension(width, height));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pokemon: Gotta Catch 'em All!");
        pack();
        setVisible(true);

        // If the key pressed was left or right,
        // and the player can move, move the player accordingly
        // and repaint the frame
        addKeyListener(new KeyListener() 
        {
            public void keyTyped(KeyEvent e) 
            {
                //does nothing
            }
            public void keyPressed(KeyEvent e) 
            {
                int keyCode = e.getKeyCode();
                switch( keyCode ) { 
                case KeyEvent.VK_LEFT:
                    // handle left
                    if (panel.getGame().playerCanMove())
                    {
                        panel.getGame().movePlayerLeft();
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (panel.getGame().playerCanMove())
                    {
                        panel.getGame().movePlayerRight(); 
                    }
                    break;
                default:
                    //does nothing

                }
                repaint();
            }
            public void keyReleased(KeyEvent e) 
            {   
                //does nothing
            }
        });
    }

    /**
     * get the bottom right point of the frame
     * 
     * @return new point from width and height
     */
    public Point getBottomRightPoint()
    {
        return new Point(width, height);
    }

    /**
     * get panel
     * 
     * @return panel
     */
    public GamePanel getPanel()
    {
        return panel;
    }
}
