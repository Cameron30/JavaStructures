import java.util.Stack;
import java.util.Collections;

/**
 * Deck for a generic type of cards
 * 
 * @author Taner
 * @version 30092016
 *
 * @param <T>   The Type of the Cards
 * @param <T2>  Card Class of some chosen type
 */
public abstract class Deck<T, T2 extends Card<T>> 
{
    /** Stack of cards that have been used already. */
    protected Stack<T2> discardStack;
    
    /** Stack of cards yet to be used. */
    protected Stack<T2> drawingStack;
    
    /**
     * Deck Constructor.
     * 
     * Creates a Discard Stack and Drawing Stack with initially
     * zero cards inside both. 
     * 
     * @param name The title or description of this deck
     */
    public Deck(String name)
    {
        
        drawingStack = new Stack<T2>();
        
        discardStack = new Stack<T2>();
    }
    
    /**
     * Add cards to the Stack to ensure the deck has some
     * cards to use for play.
     */
    public abstract void populateDeck();
    
    /**
     * Draw a card from the Drawing Stack if there is a card
     * to draw. If one is not available, the Discard Stack is 
     * popped completely into the Drawing Stack, and the Drawing 
     * Stack is shuffled. A card is then drawn.
     * 
     * Before this card's value is returned by the method, the 
     * card is first pushed onto the top of the Discard Stack.
     * 
     * @return  The value of the top card of the drawingStack
     */
    public T drawCard()
    {
        Card<T> myCard;
        if (drawingStack.isEmpty())
        {
            resetDeck();
        }
        
        discardStack.push(drawingStack.pop());
            
        myCard = discardStack.peek();
            
        return myCard.getCardValue();
    }
    
    /**
     * Shuffle the drawingStack
     */
    public void shuffleDeck()
    {
        Collections.shuffle(drawingStack);
    }
    
    /**
     * Push all of the cards in the Discard Stack onto the Drawing Stack and
     * shuffle
     */
    public void resetDeck()
    {
        for (int i = discardStack.size(); i > 0; --i)
        {
            drawingStack.add(discardStack.pop()); 
        }
        shuffleDeck();
    }
    
    /**
     * Remove all cards from both card Stacks
     */
    protected void destroyDeck()
    {
        drawingStack.clear();
        discardStack.clear();
    }
}
