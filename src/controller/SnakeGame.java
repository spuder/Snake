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
		
		ArrayList<Integer> aArray = new ArrayList<Integer>();
		aArray.add(13);
		aArray.add(14);
		aArray.add(15);
		
		 
		model.Snake aSnake = new model.Snake(255,3, aArray, 1000);
		
		
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
	}
		
		
		
		
		
	}

}
