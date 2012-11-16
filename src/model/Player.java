package model;


/**
 * Player Class creates a player, a player has a snake, starting position, starting direction and a score
 * 
 * @author Spencer Owen
 * @version 1.0
 */
public class Player
{

    //Every Player has a snake
    private Snake aSnake;
    private int playerNumber;
    private int theStartingLocation;
    private int theStatingDirection;
    private int score;
    private int color;
    private boolean alive = true;
    
    
    /*
     * These are the colors of the players
     */
    private static int blue = 0;
    private static int purple = 1;
    private static int yellow = 2;
    private static int white = 3;

    /**
     * Constructor for objects of class Player
     */
    public Player(int playerNumber, int startingLocation, int startingDirection, int color)
    {
        // Initialize instance variables
        this.playerNumber = playerNumber;
        this.theStartingLocation = startingLocation;
        this.theStatingDirection = startingDirection;
        this.score = 0;
        this.color = color;
        this.alive = true;
        aSnake = new Snake();
        
    }

    public void incrementScore( int pointsToAdd )
    {
        if ( pointsToAdd > 0 )
        {
            this.score = this.score + pointsToAdd;
        }
    }
    
    public void decrementScore( int pointsToSubtract )
    {
        //TODO: Should we let the points go negative?
        if ( pointsToSubtract > 0 )
        {
            this.score = this.score - pointsToSubtract;
        }
    }
    
    
} // end public class Player
