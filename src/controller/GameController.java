package controller;

import java.util.ArrayList;

import org.apache.log4j.Logger;

public class GameController {
		Logger logger =  Logger.getLogger( this.getClass() );
		
		
	model.Game aGame;
	
	public GameController()
	{
		
		aGame = new model.Game();
	}
	
	

	
	   public void createSnakes(int NumberOfSnakesToCreate)
	   {
		   model.Snake aReusableSnake;
		   
		   if (NumberOfSnakesToCreate >= 1)
		   {
			   logger.info("Creating snake #1 of " + NumberOfSnakesToCreate);
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
			  
		   }	
		   
		   if (NumberOfSnakesToCreate >= 2)
		   {
			   logger.info("Creating snake #4 of " + NumberOfSnakesToCreate);
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
		
		   }
		   
		   if (NumberOfSnakesToCreate >= 3)
		   {
			   logger.info("Creating snake #3 of " + NumberOfSnakesToCreate);
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
			   
		   }
		   
		   if (NumberOfSnakesToCreate == 4)
		   {
			   logger.info("Creating snake #4 of " + NumberOfSnakesToCreate);
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
