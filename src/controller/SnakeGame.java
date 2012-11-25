package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import cubeTypes.AdaptiveCube;
import cubeTypes.HypnoCube;
import cubeTypes.SeekwayCube;



public class SnakeGame {
	// Create a log4j instance
	public static Logger logger = Logger.getLogger(SnakeGame.class);
	
	
	public static Map<String, Object> 	aListOfCubeTypes;
	public static List<String> 			aLIstOfSerialPorts;
	
	public static String activeCubeType;
	
	static model.Game aGame;
	

	public static void main(String[] args) {
		/*
		 * Create a hashmap with every type of cube we support
		 * we can get the Adaptive Object by simply calling the 
		 * hashmap.get with key "Adaptive". We can get a Hypno object
		 * by calling the hashmap with key "Hypno". Since both classes
		 * implement the SerialInterface we can then call .getSerialBaudrate
		 * or any other method. This makes the code extremely modular
		 * because we only need to change 1 string to completely alter
		 * the type of cube we are using. It could even be changed on the fly
		 * (not that you would ever need to).
		 * 
		 * Note** you will need to cast the object returned to a SerialInterface to 
		 * implement the methods. 
		 * 
		 * Example
		 * System.out.println("Baudrate is " + ( (SerialInterface) aListOfCubeTypes.get("Hypno")).getSerialBaudrate() ); 
		 */
		aListOfCubeTypes = new HashMap<String, Object>();
		aListOfCubeTypes.put("Adaptive Cube",	new AdaptiveCube() 	);
		aListOfCubeTypes.put("Hypno Cube", 		new HypnoCube() 	);
		aListOfCubeTypes.put("Seekway Cube",  	new SeekwayCube() 	);
		

		view.SnakeGui theGui = new view.SnakeGui();
		
		//This is not needed since it is set when the gui is created
//		activeCubeType = "Adaptive Cube";

//		String numberOfPlayers = "4";
//		int numberOfPlayersToInt = Integer.parseInt(numberOfPlayers);
//
//		logger.info("Creating " + numberOfPlayers + " snakes");
//		aGame.createSnakes(numberOfPlayersToInt);
//
//		logger.info("Creating " + numberOfPlayers + " apples");
//		for (model.Snake aSnake : aGame.getaListOfSnakes()) {
//			int snakeColor = aSnake.getColor();
//			aGame.createApple(snakeColor);
//			logger.debug("Creating Apple with color " + snakeColor);
//
//		}

	}// end main

	public static void setupGame(	int numberOfPlayers, 
								 	int gameMode, 
								 	String serialPort, 
								 	int serialBaudRate) {
		logger.info("Creating new game");
		aGame = new model.Game(numberOfPlayers, gameMode);
		aGame.createSnakes(numberOfPlayers);
		aGame.createApple(255);
	
	}

	public static void startGame() {
		//Create a new Game object with the parameters specified by the user
		logger.info("Unpausing game");
		aGame.setGamePaused(false);
		
	}

	public static void showScores() {

	}


	/*
	 * // TODO Create Game model.Game aGame = new model.Game();
	 * 
	 * ArrayList<Integer> snake1Position = new ArrayList<Integer>();
	 * logger.info("Created snake1Position"); snake1Position.add(13);
	 * logger.info("added 13 to snake1Position arrayList");
	 * snake1Position.add(14);
	 * logger.info("added 14 to snake1Position arrayList");
	 * snake1Position.add(15);
	 * logger.info("added 15 to snake1Position arrayList");
	 * 
	 * 
	 * ArrayList<Integer> snake2Position = new ArrayList<Integer>();
	 * snake2Position.add(4093); snake2Position.add(4094);
	 * snake2Position.add(4095);
	 * 
	 * 
	 * model.Snake aSnake = new model.Snake(255,3, snake1Position, 1000);
	 * model.Snake aSnake2 = new model.Snake(115,3, snake2Position, 500);
	 * 
	 * 
	 * Arena.createApple(); // Arena.createApple(); SnakeController
	 * aSnakeController = new SnakeController();
	 * 
	 * 
	 * //Check to see if it is time to take action if (
	 * aSnakeController.checkTimeout(aSnake) == true) {
	 * aSnakeController.advanceForward(aSnake);
	 * aSnakeController.appleCheck(aSnake); //
	 * aSnakeController.wallCheck(aSnake); //
	 * aSnakeController.bodyCheck(aSnake); }
	 * 
	 * //Check to see if it is time to take action if (
	 * aSnakeController.checkTimeout(aSnake2) == true) {
	 * aSnakeController.advanceForward(aSnake2);
	 * aSnakeController.appleCheck(aSnake2); //
	 * aSnakeController.wallCheck(aSnake2); //
	 * aSnakeController.bodyCheck(aSnake2); }
	 */

}
