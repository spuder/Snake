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
    
//    private ArrayList<Player> aListOfPlayers;

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
   

   public void createSnakes(int NumberOfSnakesToCreate)
   {
	   model.Snake aReusableSnake;
	   
	   if (NumberOfSnakesToCreate >= 1)
	   {
		   //Create 4 snake objects, the 4 players are hard coded
		   int playerOneColor = controller.ConvertLedType.hexToInt("0000FF");
		   int playerOneDirection = 3; //Snake is traveling west
		   ArrayList<Integer> playerOneBodyPositions = new ArrayList<Integer>();
		   playerOneBodyPositions.add(13);
		   playerOneBodyPositions.add(14);
		   playerOneBodyPositions.add(15);
		   int playerOneSpeed = 750;
		   
		   aReusableSnake = new model.Snake(playerOneColor, playerOneDirection, playerOneBodyPositions, playerOneSpeed);
		   model.Arena.aListOfSnakes.add(aReusableSnake);
		   System.out.println("Made snake 1");
	   }	
	   
	   if (NumberOfSnakesToCreate >= 2)
	   {
		   //Create 4 snake objects, the 4 players are hard coded
		   int playerTwoColor = controller.ConvertLedType.hexToInt("00FF00");
		   int playerTwoDirection = 0; //Snake is traveling north
		   ArrayList<Integer> playerTwoBodyPositions = new ArrayList<Integer>();
		   playerTwoBodyPositions.add(512);
		   playerTwoBodyPositions.add(256);
		   playerTwoBodyPositions.add(0);
		   int playerTwoSpeed = 750;
		   aReusableSnake = new model.Snake(playerTwoColor, playerTwoDirection, playerTwoBodyPositions, playerTwoSpeed);
		   model.Arena.aListOfSnakes.add(aReusableSnake);
		   System.out.println("Made snake 2");
	   }
	   
	   if (NumberOfSnakesToCreate >= 3)
	   {
		   //Create 4 snake objects, the 4 players are hard coded
		   int playerThreeColor = controller.ConvertLedType.hexToInt("FF00FF");
		   int playerThreeDirection = 0; //Snake is traveling north
		   ArrayList<Integer> playerThreeBodyPositions = new ArrayList<Integer>();
		   playerThreeBodyPositions.add(3840);
		   playerThreeBodyPositions.add(3841);
		   playerThreeBodyPositions.add(3842);
		   int playerThreeSpeed = 750;
		   aReusableSnake = new model.Snake(playerThreeColor, playerThreeDirection, playerThreeBodyPositions, playerThreeSpeed);
		   model.Arena.aListOfSnakes.add(aReusableSnake);
		   System.out.println("Made snake 3");
	   }
	   
	   if (NumberOfSnakesToCreate == 4)
	   {
		   //Create 4 snake objects, the 4 players are hard coded
		   int playerFourColor = controller.ConvertLedType.hexToInt("FF0000");
		   int playerFourDirection = 0; //Snake is traveling north
		   ArrayList<Integer> playerFourBodyPositions = new ArrayList<Integer>();
		   playerFourBodyPositions.add(3855);
		   playerFourBodyPositions.add(3601);
		   playerFourBodyPositions.add(3346);
		   int playerFourSpeed = 750;
		   aReusableSnake = new model.Snake(playerFourColor, playerFourDirection, playerFourBodyPositions, playerFourSpeed);
		   model.Arena.aListOfSnakes.add(aReusableSnake);
		   System.out.println("Made snake 4");
	   }
	   
	   if( NumberOfSnakesToCreate <1 || NumberOfSnakesToCreate >4)
	   {
		  // controller.SnakeGame.logger.fatal("Game.createSnakes can only receive numbers between 1 and 4, received: " + NumberOfSnakesToCreate);
		   throw new IllegalArgumentException("Game.createSnakes can only receive numbers between 1 and 4, received: " + NumberOfSnakesToCreate);

	   }
	   
	   //Null out the object to mark it for garbage collection
	   aReusableSnake = null;
	   
	   
	   
   }
   
}
