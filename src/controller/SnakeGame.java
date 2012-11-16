package controller;

import java.util.ArrayList;

import model.Arena;



public class SnakeGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		model.CubeAttributes.setxNumberOfLedsPerRow(16);
		model.CubeAttributes.setyNumberOfRowsPerPanel(16);
		model.CubeAttributes.setzNumberOfPanelsPerCube(16);
		
		ArrayList<Integer> snake1Position = new ArrayList<Integer>();
		snake1Position.add(13);
		snake1Position.add(14);
		snake1Position.add(15);
		
		ArrayList<Integer> snake2Position = new ArrayList<Integer>();
		snake2Position.add(4093);
		snake2Position.add(4094);
		snake2Position.add(4095);
		
		 
		model.Snake aSnake = new model.Snake(255,3, snake1Position, 1000);
		model.Snake aSnake2 = new model.Snake(115,3, snake2Position, 500);
		
		
		Arena.createApple();
//		Arena.createApple();
		SnakeController aSnakeController = new SnakeController();
		
		while(true)
		{
			
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
		}
		
		
		
		
		
	}

}
