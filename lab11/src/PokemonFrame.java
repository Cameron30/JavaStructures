import java.awt.Dimension;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author CS2334. Modified by: ?????
 *         <P>
 * @version 2016-11-01 <BR>
 *         Lab 11
 *         <P>
 * 
 *         This class creates the Pokemon display
 */
public class PokemonFrame extends JFrame
{
    /**
     * Useful for serialization purposes (coming soon!)
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor
     * 
     * @param img
     *            picture of the Pokemon the player is trying to catch
     * @param p
     *            point where the frame should be spawned
     */
    public PokemonFrame(ImageIcon img, Point p)
    {
        getContentPane().setPreferredSize(new Dimension(300, 300));
        // This location is arbitrary. It looked okay at this point.
        setLocation(p.x + 25, p.y / 2);
        add(new JLabel(img));
        setVisible(true);
        pack();
    }
}
