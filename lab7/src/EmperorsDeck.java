/**
 * @author Cameron
 * @version 10082016
 * Deck for the emperor
 */
public class EmperorsDeck extends Deck<Character, Card<Character>>
{
    /**
     * Constructor for the Emperors's Deck
     */
    public EmperorsDeck()
    {
        super("Emperor's Deck");
    }

    /**
     * Build the Emperor's Deck.
     * 
     * This is specifically: 
     *          1x - Emperor Card 
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

        drawingStack.add(new Card<Character>(Character.EMPEROR));
    }
}
