import javax.swing.*;
import java.awt.*;

/**
 * @author CS2334. Modified by: ?????
 *         <P>
 * @version 2016-11-01 <BR>
 *         Lab 11
 *         <P>
 *         The Game Panel
 */
public class GamePanel extends JPanel
{

    /**
     * Useful for serialization purposes (coming soon!)
     */
    private static final long serialVersionUID = 1L;

    // the collection of components that make the game
    private GameView model;

    /**
     * game panel
     * 
     * @param width
     *            panel width in pixels
     * @param height
     *            panel height in pixels
     * @param pokemon
     *            Pokemon to be captured
     */
    public GamePanel(int width, int height, Pokemon pokemon)
    {
        model = new GameView(8, 6, width, height, pokemon);
        this.setSize(width, height);
    }

    /**
     * This method draws images
     * 
     * @param g
     *            The Graphics object
     */
    protected void paintComponent(Graphics g)
    {
        model.draw(g);
    }

    /**
     * 
     * @return model
     */
    public GameView getGame()
    {
        return model;
    }
}
