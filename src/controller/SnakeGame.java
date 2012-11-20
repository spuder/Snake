package controller;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



import model.CubeAttributes;
import model.Snake;



public class SnakeGame {
	//Create a log4j instance
	public static Logger logger = Logger.getLogger(SnakeGame.class);


	public static void main(String[] args) {
		//Setup log4j
		//BasicConfigurator.configure();
		
//		controller.GameController theGameController = new controller.GameController();
//		controller.ArenaController theArenaController = new controller.ArenaController();

		
		model.CubeAttributes.setxNumberOfLedsPerRow(16);
		model.CubeAttributes.setyNumberOfRowsPerPanel(16);
		model.CubeAttributes.setzNumberOfPanelsPerCube(16);
		CubeAttributes.xNumberOfLedsPerRow = 16;
		CubeAttributes.yNumberOfRowsPerPanel = 16;
		CubeAttributes.zNumberOfPanelsPerCube = 16;
		
//		model.Arena.xMaximum = 15;
//		model.Arena.yMaximum = 15;
//		model.Arena.zMaximum = 15;
		
		model.Game aGame = new model.Game();
		
		String numberOfPlayers = JOptionPane.showInputDialog("Enter Number of Players");
		int numberOfPlayersToInt = Integer.parseInt( numberOfPlayers );
		
		logger.info("Creating " + numberOfPlayers + " snakes");
		aGame.createSnakes(numberOfPlayersToInt);
		
		logger.info("Creating " + numberOfPlayers + " apples");
		for (Snake aSnake : aGame.getaListOfSnakes())
		{
			int snakeColor = aSnake.getColor();
			aGame.createApple(snakeColor);
			logger.debug("Creating Apple with color " + snakeColor);
			
		}
		
		
		
		
		
		logger.debug("Entering SnakeGame.while loop");
//		while(model.Game.isGamePaused() == false)
//		{
//			
//			
//			
//
//		}
		
		
		
		
		
	}// end main
	
	public static void setupGame()
	{
		
	}
	
	public static void startGame()
	{
		
	}
	
	public static void showScores()
	{
		
	}

	
	
	
	/*
	 * 		// TODO Create Game
		model.Game aGame = new model.Game();
		
		
		
		
		ArrayList<Integer> snake1Position = new ArrayList<Integer>();
			logger.info("Created snake1Position");
		snake1Position.add(13);
			logger.info("added 13 to snake1Position arrayList");
		snake1Position.add(14);
			logger.info("added 14 to snake1Position arrayList");
		snake1Position.add(15);
			logger.info("added 15 to snake1Position arrayList");
		
		
		ArrayList<Integer> snake2Position = new ArrayList<Integer>();
		snake2Position.add(4093);
		snake2Position.add(4094);
		snake2Position.add(4095);
		
		 
		model.Snake aSnake = new model.Snake(255,3, snake1Position, 1000);
		model.Snake aSnake2 = new model.Snake(115,3, snake2Position, 500);
		
		
		Arena.createApple();
//		Arena.createApple();
		SnakeController aSnakeController = new SnakeController();
		
		
					//Check to see if it is time to take action
			if ( aSnakeController.checkTimeout(aSnake) == true)
			{
				aSnakeController.advanceForward(aSnake);
				aSnakeController.appleCheck(aSnake);
	//			aSnakeController.wallCheck(aSnake);
	//			aSnakeController.bodyCheck(aSnake);
			}
			
			//Check to see if it is time to take action
			if ( aSnakeController.checkTimeout(aSnake2) == true)
			{
				aSnakeController.advanceForward(aSnake2);
				aSnakeController.appleCheck(aSnake2);
//					aSnakeController.wallCheck(aSnake2);
//					aSnakeController.bodyCheck(aSnake2);
			}
		
	 */

}
