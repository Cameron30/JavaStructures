import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author CS2334. Modified by: Cameron
 *         <P>
 * @version 2016-11-01 <BR>
 *         Lab 11
 *         <P>
 * 
 *         This class creates the game display
 */
public class GameView
{

    // nBlocksWide and nBlocksTall in number of 'blocks'
    private int nBlocksWide;
    private int nBlocksTall;

    // Width and nBlocksTall in pixels
    private int nPixelsWide;
    private int nPixelsTall;

    // a double ended queue
    private ArrayList<GameRow> rows;

    // the players current horizontal position (in blocks)
    private int playerPos;

    // the length of the game in frames
    private int gameLength;

    // all game images
    private Image background;
    private Image trainer;
    private Image obstacle;
    private Image pokeball;

    /**
     * Constructor
     * 
     * @param nBlocksWide
     *            Width in blocks
     * @param nBlocksTall
     *            Height in blocks
     * @param nPixelsWide
     *            Width in pixels
     * @param nPixelsTall
     *            Height in pixels
     * @param pokemon
     *            Pokemon to be captured
     */
    public GameView(int nBlocksWide, int nBlocksTall, int nPixelsWide,
            int nPixelsTall, Pokemon pokemon)
    {
        // set nBlocksWide and nBlocksTall
        this.nBlocksWide = nBlocksWide;
        this.nBlocksTall = nBlocksTall;

        // Pixel size
        this.nPixelsWide = nPixelsWide;
        this.nPixelsTall = nPixelsTall;

        // set game length
        gameLength = pokemon.getFightLength();

        // create the images
        trainer = Toolkit.getDefaultToolkit().getImage(
                "resources/trainer.png");
        pokeball = Toolkit.getDefaultToolkit().getImage(
                "resources/pokeball.png");
        obstacle = pokemon.getBattleAttack();

        // If this is the legendary fight, set the legendary background
        if (pokemon.isLegendary())
        {
            background = Toolkit.getDefaultToolkit().getImage(
                    "resources/battleBackground_mew.png");
        }
        else
        // normal battle
        {
            background = Toolkit.getDefaultToolkit().getImage(
                    "resources/battleBackground.png");
        }

        // create nBlocksTall blank rows
        rows = new ArrayList<GameRow>();

        for (int i = 0; i < this.nBlocksTall; i++)
        {
            rows.add(new GameRow());
        }

        // where does the player start? (horizontal position)
        playerPos = 2;
    }

    /**
     * draw the game
     * 
     * @param g
     *            A Graphics object
     */
    public void draw(Graphics g)
    {
        // draw the background image first
        g.drawImage(background, 0, 0, this.nPixelsWide, 
                this.nPixelsTall, null);

        // how big is each 'block' in pixels?
        int blockWidth = this.nPixelsWide / this.nBlocksWide;
        int blockHeight = this.nPixelsTall / this.nBlocksTall;

        for (int i = 0; i < rows.size(); ++i)
        {
            drawRow(nBlocksTall - i, blockWidth, blockHeight, rows.get(i), g);
        }
        
        drawPlayer(blockWidth, blockHeight, g);
        
    }

    /**
     * draw a row of images
     * 
     * @param y
     *            y-coordinate of the image
     * @param blockWidth
     *            nBlocksWide of the row image in pixels
     * @param blockHeight
     *            nBlocksTall of the row image in pixels
     * @param row
     *            one row of images
     * @param g
     *            The Graphics object
     */
    private void drawRow(int y, int blockWidth, int blockHeight, GameRow row,
            Graphics g)
    {
        //If it's the empty row, don't draw anything
        if (row.isEmptySpace())
        {
            return;
        }

        //If it's not the final row, draw the row without a pokeball
        if (!row.isFinalRow())
        {
            for (int i = 0; i < nBlocksWide; ++i)
            {
                if (row.getFreePosition() != i)
                {
                    g.drawImage(obstacle, i * blockWidth, y * 
                            blockHeight, null);
                }
            }
            
        }
        else
        //final row with a pokeball in the empty space
        {
            for (int i = 0; i < nBlocksWide; ++i)
            {
                if (row.getFreePosition() != i)
                {
                    g.drawImage(obstacle, i * blockWidth, y * 
                            blockHeight, null);
                }
                else
                {
                    g.drawImage(pokeball, i * blockWidth, y * 
                            blockHeight, null);
                }
            }
        }
    }

    /**
     * draw player image
     * 
     * @param blockWidth
     *            nBlocksWide of the player image in pixels
     * @param blockHeight
     *            nBlocksTall of the player image in pixels
     * @param g
     *            A Graphics object
     */
    private void drawPlayer(int blockWidth, int blockHeight, Graphics g)
    {
        g.drawImage(trainer, playerPos * blockWidth, 500, null);   
    }

    /**
     * 
     * @return bottom row
     */
    public GameRow getBottomRow()
    {
        return rows.get(0);
    }

    /**
     * Create and add a new row to the end of the queue
     * 
     * @param frameNum Current step in the game (in terms of 
     * vertical moves).
     */
    public void pushDown(int frameNum)
    {
        // is the last row empty and should I add another row?
        if ((frameNum + nBlocksTall <= gameLength)
                && rows.get(rows.size() - 1).isEmptySpace())
        {
            // where should the empty space be?
            Random random = new Random();
            int space = Math.abs(random.nextInt()) % nBlocksWide;
            if (frameNum + nBlocksTall < gameLength) // Add a row without a
                                                     // pokeball
            {
                rows.add(new GameRow(space, false));
            }
            else
            // Add a pokeball
            {
                rows.add(new GameRow(space, true));
            }
        }
        else
        {
            // create and add a new empty row
            rows.add(new GameRow());
        }

        // remove off bottom row
        rows.remove(0);
    }

    /**
     * move player to the right
     * 
     * @return new position after player moves right
     */
    public int movePlayerRight()
    {
        if (playerPos < 7)
        {
            playerPos += 1; 
        }
        else
        {
            playerPos = 0;
        }    
        // return playerPos
        return playerPos;
    }

    /**
     * move player to the left
     * 
     * @return new position after player moves left
     */
    public int movePlayerLeft()
    {
        if (playerPos == 0)
        {
            playerPos = 7;
        }
        else
        {
            playerPos -= 1;
        }
        // return playerPos
        return playerPos;
    }

    /**
     * check if the player is dead
     * 
     * @return true if player is dead i.e. in the wrong free space
     */
    public boolean playerIsDead()
    {
        // is the row empty? if so still alive
        if (rows.get(0).isEmptySpace())
        {
            return false;
        }

        // is the player in the correct free space?
        return playerPos != rows.get(0).getFreePosition();
    }

    /**
     * get the player's position
     * 
     * @return the player's position
     */
    public int getPlayerPos()
    {
        return playerPos;
    }

    /**
     * the player can only move if the bottom row is empty
     * 
     * @return true if the bottom row is empty
     */
    public boolean playerCanMove()
    {
        // the player can move if the bottom row is empty
        return rows.get(0).isEmptySpace();
    }

    /**
     * @return the trainer
     */
    public Image getTrainer()
    {
        return trainer;
    }

    /**
     * @return the obstacle
     */
    public Image getObstacle()
    {
        return obstacle;
    }

}
