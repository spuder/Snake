import java.util.ArrayList; 
/**
 * Game has a mode, a paused status, number of players and cube type
 * 
 * @author Spencer Owen
 * @version 1.0
 */
public class Game
{

    private int numberOfPlayers;
    private int cubeType;
    private int gameMode; 
    private boolean gamePaused;
    
    private ArrayList<Player> aListOfPlayers;

    /**
     * Constructor for objects of class Game
     */
    public Game( int numberOfPlayers, int cubeType, int gameMode)
    {
        // initialise instance variables
        this.numberOfPlayers = numberOfPlayers;
        this.cubeType = cubeType;; 
        this.gameMode = gameMode;
        this.gamePaused = true;
        
        this.aListOfPlayers = new ArrayList<Player>();
        
        for (int playerCounter = 0; playerCounter < numberOfPlayers; playerCounter++)
        {
            //Create new player objects,
            //addPlayer( int playerNumber, int startingLocation, int startingDirection, int color)
            addPlayer(playerCounter, 0, 0 , 0 );
        }
        
        
    }


   public boolean getGamePaused()
   {
       return this.gamePaused;
   }

   public void setGamePaused(boolean gamePaused)
   {
       this.gamePaused = gamePaused;
   }
   
   public void addPlayer(int playerNumber, int startingLocation, int startingDirection, int color)
   {
       //Create a new player
       Player aPlayer = new Player(playerNumber, startingLocation, startingDirection, color);
       
       //Add the player to the collection of players
       aListOfPlayers.add( aPlayer );
   }
   
}
