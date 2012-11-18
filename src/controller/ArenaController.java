package controller;

import java.util.Random;

import model.Apple;
import model.Snake;

public class ArenaController {
	
	ArenaController()
	{
		
		
	}
	 public void createApple(int appleColor)
	    {
	    	
	    	//TODO:Delete this test code
//	    	model.Apple anApple = new model.Apple(10,255);
//	    	model.Arena.aListOfApples.add(anApple);
//	    	
//	    	model.Apple anApple2 = new model.Apple(9,255);
//	    	model.Arena.aListOfApples.add(anApple);
	    	
	    	int temporaryAppleLocation;
	    	int minumumLed = 0;
	    	int maximumLed = controller.ConvertLedType.relativeToAbsolute(xMaximum, yMaximum, zMaximum);
	    	
	    	//Create a random number between 0 and the maximum number of LEDs
	    	Random aRandomNumber = new Random();
	    	temporaryAppleLocation = aRandomNumber.nextInt(maximumLed - minumumLed) + minumumLed;
	        System.out.println("Created a random apple at " +  temporaryAppleLocation);
	        
	        
	        boolean appleCollisionCheck = false;
	        boolean snakeCollisionCheck = false;
	        
	        //Keep creating new Apples until we have determined it is random
	        //do while statement are different then while because they do the evaluation at the end of the loop
	        do {
	        	//Assume the Apple is good unless we find a bad one
	        	appleCollisionCheck = true;
	        	
	        	//Look at every other apple in the arena and see if it is a duplicate 
	        	for( Apple otherApples : aListOfApples )
	        	{
	        		//If 
	        		if(temporaryAppleLocation == otherApples.getAbsolutePosition() )
	        		{
	        			appleCollisionCheck = false;
	        		}
	        		
	        	}
	        	
	        	//Assume the snake is good unless we find a bad one
	        	snakeCollisionCheck = true;
	        	
	        	for( Snake otherSnakes : aListOfSnakes )
	        	{
	        		for(Integer bodyPositionsToCheck : otherSnakes.getBodyPositions())
	        		{
		        		//Check each part of the snake
		        		if(temporaryAppleLocation == bodyPositionsToCheck )
		        		{
		        			snakeCollisionCheck = false;
		        		}
	        		}
	        	}
	        	
	        	
	        	
	        	if (appleCollisionCheck == false || snakeCollisionCheck == false)
	        	{
	        		System.out.println("Creating a new Apple since there was a collision");
	        		temporaryAppleLocation = aRandomNumber.nextInt(maximumLed - minumumLed) + minumumLed;
	        		
	        		//Since we had a collision, reset both of the checks to false
	        		appleCollisionCheck = false;
	        		snakeCollisionCheck = false;
	        		
	        	}
	        	
	        }while ( appleCollisionCheck == false && snakeCollisionCheck == false);
	        
	        Apple anApple = new Apple(temporaryAppleLocation, appleColor);
	        System.out.println("Added a new apple with color:  " + appleColor + temporaryAppleLocation);
	        aListOfApples.add(anApple);

	        
	    }
	    
	    public static void destroyApple()
	    {
	        
	    }

}
