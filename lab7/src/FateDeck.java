/**
 * 
 * @author Cameron
 * @version 10082016
 * Fate deck that extends deck
 */
public class FateDeck extends Deck<Fate, Card<Fate>>
{
    /**
     * Constructor for the Fate's Deck
     */
    public FateDeck()
    {
        super("The Deck of Fate");
    }

    /**
     * Build the Fate Deck.
     * 
     * This is specifically: 
     *          1x - Revolution Card 
     *          1x - Riches Card
     */
    @Override
    public void populateDeck()
    {
        destroyDeck();
        
        drawingStack.add(new Card<Fate>(Fate.RICHES));

        drawingStack.add(new Card<Fate>(Fate.REVOLUTION));
    }
}