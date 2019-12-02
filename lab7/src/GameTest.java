import org.junit.Test;
import org.junit.Assert;

/**
 * 
 * @author Cameron
 * @version 10082016
 *
 */
public class GameTest {
    

    /**
     * Tests running the game a single time
     * (has to score something)
     */
    @Test
    public void playTest()
    {
        Game game = new Game();
        int score = 0;
        
        score += game.playOnce();
        Assert.assertFalse(score != 0);
    }
    
}
