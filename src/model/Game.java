package model;

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
    
    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
    	 this.numberOfPlayers = numberOfPlayers;
         this.cubeType = cubeType;; 
         this.gameMode = gameMode;
         this.gamePaused = true;
    }
    
    public Game( int numberOfPlayers, int cubeType, int gameMode)
    {

        this.numberOfPlayers = numberOfPlayers;
        this.cubeType = cubeType;; 
        this.gameMode = gameMode;
        this.gamePaused = true;
                
    }


   public boolean isGamePaused()
   {
       return this.gamePaused;
   }

   public void setGamePaused(boolean gamePaused)
   {
       this.gamePaused = gamePaused;
   }
   

   
   
   
   
}
