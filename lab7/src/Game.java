/**
 * Full game implementation.
 * 
 * This game uses three decks of cards: 1x - Emperor's Deck 1x-Plebeian's Deck
 * 1x - Fate Deck
 * 
 * RULES: 1) At the beginning of each game, the player draws a fate card. - if
 * the fate is of riches, the player uses the emperor deck - if the fate is of
 * revolution, the player uses the plebeian deck 2) Each player reveals the top
 * card of their deck - Emperor beats Patrician - Patrician beats Plebeian -
 * Plebeian beat Emperor 3) Repeat Rule 2 if both players reveal a patrician
 * 
 * Scoring: If the player wins using the Emperor Deck, they get 1 point. If the
 * player wins with the Plebeian Deck, they get 4 points.
 * 
 * @author Taner
 * @version 2016-10-05
 * 
 */
public class Game
{
    /** The Emperor Deck */
    private EmperorsDeck emperorsDeck;

    /** The Plebeian Deck */
    private PlebeiansDeck plebeianDeck;

    /**
     * The Fate Deck. Decides which player gets the Emperor Deck and which
     * player gets the Plebeian Deck.
     */
    private FateDeck fateDeck;

    /**
     * Used to invert the point-value constants for when the player loses.
     */
    private final int constPlayerLost = -1;

    /**
     * Total points won from playing a plebeian against an emperor Multiply by
     * constPlayerLost if the player played the Emperor
     */
    private final int constPlebeianEmperor = 4;

    /**
     * Total points won from playing a patrician against a non-patrician
     * Multiply by constPlayerLost if the patrician beats the player's card
     */
    private final int constPatricianNonPatrician = 1;

    /**
     * Game Constructor.
     * 
     * Create and populate all three decks.
     */
    public Game()
    {
        emperorsDeck = new EmperorsDeck();
        emperorsDeck.populateDeck();
        plebeianDeck = new PlebeiansDeck();
        plebeianDeck.populateDeck();
        fateDeck = new FateDeck();
        fateDeck.populateDeck();
    }

    /**
     * Ensures that all decks are ready to play, and passes the decks to the
     * play() method. This separation makes the stochastic nature of this game
     * easier to control during testing.
     * 
     * @return The total number of points the player either won or lost
     */
    public int playOnce()
    {
        ensureNewGame();
        return play(emperorsDeck, plebeianDeck, fateDeck);
    }

    /**
     * Play one round of Fate.
     * 
     * Returns the point value of the player's perspective when a win condition
     * based on rule 2 is achieved.
     * 
     * @param emperorDeck
     *            The shuffled-and-readied Emperor's Deck
     * @param plebeiansDeck
     *            The shuffled-and-readied Plebeian's Deck
     * @param fatesDeck
     *            The shuffled-and-readied Fate Deck
     * @return The number of points the player (not opponent) receives
     */
    public int play(EmperorsDeck emperorDeck, PlebeiansDeck plebeiansDeck, 
            FateDeck fatesDeck)
    {
        // Draw a Fate card to decide who gets which deck
        Fate fateCard = fatesDeck.drawCard();
        // Let the user know which deck they've been given with a print
        // statement
        System.out.println(fateCard);
        // The Top card that each player draws during each round.
        Character player;
        Character opponent;

        // The Fate card is the Riches card. The player gets the Emperor deck.
        if (fateCard == Fate.RICHES)
        {
            for (int i = 0; i < 5; ++i)
            {
                //draws cards
                player = emperorDeck.drawCard();
                opponent = plebeiansDeck.drawCard();
                
                //prints out the two cards
                System.out.println("You: " + player);
                System.out.println("Opp: " + opponent);
                
                //finds value to assign the win/loss
                if (player.toString().equals("Emperor"))
                {
                    if (opponent.toString().equals("Plebeian")) 
                    {
                        return (constPlayerLost * constPlebeianEmperor);
                    }
                    else
                    {
                        return constPatricianNonPatrician;
                    }  
                    
                }
                /*Returns either a loss or nothing according to opponent*/
                else if (opponent.toString().equals("Plebeian"))
                {
                    return (constPatricianNonPatrician);
                }
            }     
        }
        // The Fate card is the Revolution card. Player gets the Plebeian deck.
        else
        {
            for (int i = 0; i < 5; ++i)
            {
                player = plebeiansDeck.drawCard();
                opponent = emperorDeck.drawCard();
                
                System.out.println("You: " + player);
                System.out.println("Opp: " + opponent);
                
              //finds value to assign the win/loss
                if (opponent.toString().equals("Emperor"))
                {
                    if (player.toString().equals("Plebeian")) 
                    {
                        return (constPlebeianEmperor);
                    }
                    else
                    {
                        return constPlayerLost;
                    }  
                    
                }
                /*Returns either a loss or nothing according to opponent*/
                else if (player.toString().equals("Plebeian"))
                {
                    return (constPlayerLost);
                }
            }     
        }

        /*
         * Given that the Emperor Deck and the Plebeian Deck both have the same
         * number of cards and contain the pre-specified types and amount of
         * cards inside of them, this is unreachable. However, this makes
         * Eclipse happy that all paths return some int.
         */
        return 0;

    }

    /**
     * Ensure that all decks are reset to their respective drawing decks
     */
    private void ensureNewGame()
    {
        emperorsDeck.resetDeck();
        plebeianDeck.resetDeck();
        fateDeck.resetDeck();
    }
}