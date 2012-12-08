package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import cubeTypes.AdaptiveCube;
import cubeTypes.HypnoCube;
import cubeTypes.SeekwayCube;
import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;



public class SnakeGame {
	// Create a log4j instance
	public static Logger logger = Logger.getLogger(SnakeGame.class);
	
	//TODO: Should this be static and public?
	public static Map<String, Object> 	aListOfCubeTypes;
	public static List<String>              aLIstOfSerialPorts;
	
	public static String activeCubeType;
	
	static model.Game aGame;
        
        static view.SnakeGui theGui;
        
        static Controller aController;
	

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
		aListOfCubeTypes.put("Hypno Cube", 	new HypnoCube() 	);
		aListOfCubeTypes.put("Seekway Cube",  	new SeekwayCube() 	);
		
                /*
                 * Create a Controllers Object
                 * A Controllers is a collection of Controller
                 * Contains a list of all the gamepads on system
                */
                try {
                    Controllers.create();
                }catch (
                    Exception e) {
                    logger.fatal("Unable to create Controllers Object, Likely JInput not found");
                    e.printStackTrace();
                } 
                logger.warn("Found " + Controllers.getControllerCount() + " controllers on system");
                
                    
		theGui = new view.SnakeGui();
		
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
		aGame = null;
		aGame = new model.Game(numberOfPlayers, gameMode);

		String redHex 		= "FF0000";
		String blueHex 		= "0000FF";
		String greenHex 	= "00FF00";
		String purpleHex 	= "FF00FF";
		
		//Create a bunch of apples for testing
		aGame.createApple( ConvertLedType.hexToInt( redHex ) );
		aGame.createApple( ConvertLedType.hexToInt( blueHex ) );
		aGame.createApple( ConvertLedType.hexToInt( greenHex ) );
		aGame.createApple( ConvertLedType.hexToInt( purpleHex ) );

	
		aGame.createSnakes( numberOfPlayers );
	}

	public static void startGame() {
		//Create a new Game object with the parameters specified by the user
		logger.info("Unpausing game");
		aGame.setGamePaused(false);
		
                boolean anyPlayerStillAlive = true;
                
                //Hide the setup Gui when starting the game
                theGui.setVisible(false);
                
                
                
                //As long as there is a player still alive, loop this code
		do {
                    
                    //Update information for every controller in system
                     Controllers.poll();
                     
                     while (Controllers.next()) {
                        //Controller number
                        int controllerNumber =  Controllers.getEventSource().getIndex();
                        //Button number
                        int buttonNumber     = Controllers.getEventControlIndex();
                        /*
                         * Pressing a button on an xBox controller slightly alters the analog values
                         * This causes multiple unwanted events on button push
                         * By checking to see if the event was a button we can strip out the uneeded events
                         */
                        if ( Controllers.isEventButton() == true ) {
                         handleButtonPush( controllerNumber, buttonNumber, aGame.getaListOfSnakes() );  
                        }
                         
                     }
                        //Look at each snake
			for(model.Snake atempSnake : aGame.getaListOfSnakes() ) {

                                //See if it is time to update the snake
				if ( aGame.checkTimeout(atempSnake) == true ) {
					atempSnake.advanceForward();
					System.out.println("Snake " + atempSnake.getColor() + " is now at " + atempSnake.getBodyPositions().get(0) ); 
					System.out.println("");
					
					logger.debug("Searching entire arrayList to see if snake has eaten apple");
					if ( atempSnake.appleCheck( aGame.getaListOfApples() ) == true ) {
						atempSnake.setScore(100);
						logger.error("Added 100 points to snake " + atempSnake.getColor() );

						//Find the apple, delete it and create a new one
						for(model.Apple appleToDestroy : aGame.getaListOfApples() ) {
							logger.debug("In for loop checking apple " + appleToDestroy.getColor() );
							
							//See if the current snake head location is the same as an apple location
							if ( appleToDestroy.getAbsolutePosition() == atempSnake.getBodyPositions().get(0) ) {
								logger.debug("Snake has found an apple at " + appleToDestroy.getAbsolutePosition() );
								
								//Save the color of the apple to destroy for when we create a new one
								int appleColor = appleToDestroy.getColor();
								logger.debug("About to delete the apple with color " + appleColor);
								
								
								//Remove the apple from the arrayList 
								aGame.destroyApple(appleToDestroy);
								
								//Create a new apple
								aGame.createApple(appleColor);	
								
								//No need to add the apple to the array since that is handled in the createApple method
							}
							
						}//end for each apple loop

					}//end if snake.applecheck == true
					
				}//end checkTimeout
				
			}//end for each snake loop
			
		}while (anyPlayerStillAlive == true);
                
                //TODO: Show gui when game over
                theGui.setVisible(true);
                
		
	}

	public static void showScores() {

	}
        
        
         /**
        * Converts the button number, to the game event
        * Example: Pressing button 3 on controller means player turns right
        * This is pro propritary to xbox controllers and snake game
        * 
        * @param controllerNumber The number of the controller, starts at 0
        * @param buttonNumber The button number on the controller usually 0 - 22
        */
        public static void handleButtonPush( int controllerNumber, int buttonNumber , List<model.Snake> aListOfSnakes) {

            // System.out.println("Controller " + controllerNumber + " button " + buttonNumber);
            for (model.Snake aSnake : aListOfSnakes ) {
              
                if ( aSnake.getControllerNumber() == controllerNumber ) {
                  
                    switch (buttonNumber) {

                    case 0: logger.debug("User " + controllerNumber + " turned North");
                            aSnake.setTravelDirection(0);
                        break;
                    case 1: logger.debug("User " + controllerNumber + " turned South");
                            aSnake.setTravelDirection(2);
                        break;
                    case 2: logger.debug("User " + controllerNumber + " turned West");
                            aSnake.setTravelDirection(3);
                        break;
                    case 3: logger.debug("User " + controllerNumber + " turned East");
                            aSnake.setTravelDirection(1);
                        break;
                    }//end switch buttonNumber
                
                }//end if controllernumber=

            }//end for each snake
                    
                    
        }//end handleButtonPush




}
