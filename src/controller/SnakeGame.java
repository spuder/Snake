package controller;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import model.Arena;



public class SnakeGame {
	static Logger logger = Logger.getLogger(SnakeGame.class);

	public static void main(String[] args) {
		
		
		controller.GameController theGameController = new controller.GameController();
		
		model.CubeAttributes.setxNumberOfLedsPerRow(16);
		model.CubeAttributes.setyNumberOfRowsPerPanel(16);
		model.CubeAttributes.setzNumberOfPanelsPerCube(16);
		
		
		String numberOfPlayers = JOptionPane.showInputDialog("Enter Number of Players");
		int numberOfPlayersToInt = Integer.parseInt( numberOfPlayers );
		
		theGameController.createSnakes(numberOfPlayersToInt);
		
		
		
		
		logger.debug("Entering SnakeGame.while loop");
//		while(model.Game.isGamePaused() == false)
//		{
//			
//			
//			
//
//		}
		
		
		
		
		
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
