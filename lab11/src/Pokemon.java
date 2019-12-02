import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

/**
 * @author CS2334. Modified by: ?????
 *         <P>
 * @version 2016-11-01 <BR>
 *         Lab 11
 *         <P>
 * 
 *         Class for Pokemon representation for frame and game construction
 */
public class Pokemon
{
    // Type and name of the pokemon - used for file retreival
    private String type;
    private String name;

    // Is this pokemon a legendary creature?
    private boolean legendary;

    // Fight length and difficulty
    private int fightLength;
    private int difficultySpeed;

    /**
     * Constructor for Pokemon
     * 
     * @param name
     *            Name of the pokemon
     * @param type
     *            Type of the pokemon
     * @param legendary
     *            true if the pokemon is a legendary creature
     * @param fightLength
     *            how many frames the fight is
     * @param difficultySpeed
     *            how quickly should the frame redraw
     */
    public Pokemon(String name, String type, boolean legendary,
            int fightLength, int difficultySpeed)
    {
        this.name = name;
        this.type = type;
        this.legendary = legendary;
        this.fightLength = fightLength;
        this.difficultySpeed = difficultySpeed;
    }

    /**
     * Image representation of the pokemon
     * 
     * @return ImageIcon of the pokemon
     */
    public ImageIcon getBattleImage()
    {
        return new ImageIcon("resources/" + name + ".png");
    }

    /**
     * Image of the attack related to the Pokemon's type
     * 
     * @return Image of the pokemon's type
     */
    public Image getBattleAttack()
    {
        return Toolkit.getDefaultToolkit().getImage(
                "resources/" + type + ".png");
    }

    /**
     * Is the pokemon legendary?
     * 
     * @return true if the pokemon is a legendary creature
     */
    public boolean isLegendary()
    {
        return legendary;
    }

    /**
     * String representation of the pokemon
     * 
     * @return name of the pokemon
     */
    public String getName()
    {
        return name;
    }

    /**
     * How long of a fight does this pokemon put up?
     * 
     * @return length of the pokemon's fight in frames
     */
    public int getFightLength()
    {
        return fightLength;
    }

    /**
     * How quickly should the thread sleep time decrease
     * 
     * @return how many milliseconds the thread sleep time decreases
     */
    public int getdifficultySpeed()
    {
        return difficultySpeed;
    }
}
