import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author CS2334. Modified by: Cameron
 *         <P>
 * @version 2016-11-01 <BR>
 * 
 *         Lab 11
 *         <P>
 *         This is the Driver Class containing the main method
 */
public class Driver
{

    /**
     * main method
     * 
     * @param args
     *            Command line arguments (not used)
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException
    {
        // Load Professor Oak's image
        Image oak = Toolkit.getDefaultToolkit().getImage("resources/oak.png");

        // Create the array of button choices
        String[] buttons = { "Pikachu (Easy)", 
            "Machoke (Medium)", "Abra (Difficult)" };

        // Set-up for the switch statement
        Pokemon pokemon;

        // Switch on the button the user selects
        switch (JOptionPane.showOptionDialog(null, "Which Pokemon would you "
                + "like to catch?", "Select your difficulty",
                JOptionPane.WARNING_MESSAGE, 0, new ImageIcon(oak), buttons,
                buttons[0]))
        {
            case 0: // First button
                pokemon = new Pokemon("Pikachu", "electric", false, 20, 10);
                break;
            case 1: // Second button
                pokemon = new Pokemon("Machoke", "fighting", false, 30, 13);
                break;
            case 2: // Third button
                pokemon = new Pokemon("Abra", "psychic", false, 40, 15);
                break;
            default: // Secret choice
                pokemon = new Pokemon("Mew", "psychic", true, 55, 16);
                break;
        }

        // Base Game frame speed which the game will run at.
        int gameSpeed = 1000;

        // Width of screen in pixels
        int width = 800;

        // Height of screen in pixels
        int height = 600;

        // Initialize the pokemon frame
        PokemonFrame pokemonFrame = new PokemonFrame(pokemon.getBattleImage(),
                new Point(width, height));

        // Initialize the game frame
        GameFrame gameFrame = new GameFrame(pokemon, width, height);

        // Initialize the length and difficulty of the game
        int gameLength = pokemon.getFightLength();
        int frameReduction = pokemon.getdifficultySpeed();

        // game moves for gameLength frames or until game over
        for (int frameNum = 0; frameNum < gameLength; frameNum++)
        {
            // set the game speed.
            Thread.sleep(gameSpeed);
            // add a new row to the end of the queue
            gameFrame.getPanel().getGame().pushDown(frameNum);
            // is my player dead?
            if (gameFrame.getPanel().getGame().playerIsDead())
            {
                // Notify the player that the pokemon has fled
                JOptionPane.showMessageDialog(null, pokemon.getName()
                        + " fled!", "", 0, new ImageIcon(oak));
                // Quit
                System.exit(0);
            }

            // Repaint gameFrame
            gameFrame.repaint();

            // Decrease the sleep length to make the game progress faster
            gameSpeed -= frameReduction;
        }

        // after gameLength frames, the player captures the pokemon
        JOptionPane.showMessageDialog(null, "Congratulations, You Caught "
                + pokemon.getName() + "!");

        // Make Web-Cat happy
        pokemonFrame.toString();

        // Quit
        System.exit(0);
    }
}