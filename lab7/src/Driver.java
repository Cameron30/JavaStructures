/**
 * Simple driver class to run 50 iterations of the Fate game.
 * 
 * @author Taner
 * @version 30092016
 */
public class Driver
{
    // How many games, in total, the program should play
    private static final int NUMBER_OF_GAMES_TO_PLAY = 50;

    /**
     * Main method for the Fate Game system
     * 
     * @param args
     *            command-line arguments [not used]
     */
    public static void main(String[] args)
    {
        // Create a new game and a running player's score
        Game game = new Game();
        int score = 0;

        // Generate a header to define the first game in the console
        System.out.println("////////// FATE GAME START //////////");

        // Run 50 games.
        for (int i = 0; i < NUMBER_OF_GAMES_TO_PLAY; i++)
        {
            // Show the player their running total score
            System.out.println("Player's Current Total Score: " + score);

            // Play a single game, and add the score to the running sum.
            score += game.playOnce();
        }

        // Show the player their final score.
        System.out.println("////////// FATE GAME END //////////");
        System.out.println("Player's Final Score: " + score);
    }
}
