import java.util.ArrayList;

/**
 * 
 * @author Justin / Cameron
 * @version 20161116
 * Key constraints class
 */
public class KeyConstraints extends ArrayList<Integer>
{

    /**
     * serializable
     */
    private static final long serialVersionUID = 1L;

    private KeyConstraints next;

    /**
     * Constructor method
     */
    public KeyConstraints()
    {
        //Empty af
    }

    /**
     * accessor for the field
     * @return KeyConstraints next
     */
    public KeyConstraints getNext()
    {
        //getter method, return field variable
        return next;
    }

    /**
     * add an element
     * @param elem element to be added
     */
    public void addEnd(KeyConstraints elem)
    {
        //get a reference to this
        KeyConstraints temp = this;
        
        //does this have a reference to the next element
        //or, is this the last element
        while (temp.getNext() != null)
        {
            //this has a next, get it for recursion kind of
            temp = temp.getNext();
        }
        
        //last element, add end
        temp.next = elem;
    }
}
