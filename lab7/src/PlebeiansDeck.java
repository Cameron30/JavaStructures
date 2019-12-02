/**
 * The Plebeian's Deck which holds cards of type Character.
 * 
 * @author Taner
 * @version 30092016
 * 
 *          Fix where there is a play Once and a RNG
 */
public class PlebeiansDeck extends Deck<Character, Card<Character>>
{
    /**
     * Constructor for the Plebeians's Deck
     */
    public PlebeiansDeck()
    {
        super("Plebeian's Deck");
    }

    /**
     * Build the Plebeian's Deck.
     * 
     * This is specifically: 
     *          1x - Plebeian Card 
     *          4x - Patrician Card
     */
    @Override
    public void populateDeck()
    {
        destroyDeck();

        for (int i = 0; i < 4; i++)
        {
            drawingStack.add(new Card<Character>(Character.PATRICIAN));
        }

        drawingStack.add(new Card<Character>(Character.PLEBEIAN));
    }
}
