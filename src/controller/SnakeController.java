package controller;

import java.util.ArrayList;

import model.Arena;

public class SnakeController {

	
	public SnakeController()
	{
	}
	
	
	public boolean checkTimeout(model.Snake aSnake)
	{
	//Get the current Time in milliseconds
	long currentTime = System.currentTimeMillis();
	
	//Get the snake last advance time
	long lastMove = aSnake.getLastMoveTime();
	
	//Get the snake speed
	int snakeSpeed = aSnake.getSpeed();
	
	//If it has  been a while since the snake moved...
		if ( currentTime > lastMove + snakeSpeed )
		{
			System.out.println("We have waited for " + snakeSpeed +" milliseconds");
			aSnake.setLastMoveTime(System.currentTimeMillis());
			return true;
		}
		else
		{
			//It hasn't been long enough
			return false;
		}
		
		
			
	}
	
	public void advanceForward(model.Snake aSnake)
	{
		//TODO: Logic to shift arrayList
		ArrayList<Integer> anArrayList = aSnake.getBodyPositions();
		int headPosition = anArrayList.get(0);
		int headPositionX = controller.ConvertLedType.absoluteToXPositionInRow(headPosition);
		int headPositionY = controller.ConvertLedType.absoluteToYPositionInPanel(headPosition);
		int headPositionZ = controller.ConvertLedType.absoluteToZPositionInCube(headPosition);
		
		/*
		 * Travel Direction
		 * 0 = north 	//z++
		 * 1 = east 	//x++
		 * 2 = south 	//z--
		 * 3 = west 	//x--
		 * 4 = up 		//y++
		 * 5 = down 	//y--
		 */
		int direction = aSnake.getTravelDirection();
		if( direction == 0)
		{
			//add 1 to z because we are moving north
			headPositionZ++;
		}
		else if(direction == 1)
		{
			//add 1 to x because we are moving east
			headPositionX++;
		}
		else if(direction == 2)
		{
			//subtract 1 from z because we are moving south
			headPositionZ--;
		}
		else if(direction == 3)
		{
			//subtract 1 from x because we are moving west
			headPositionX--;
		}
		else if(direction == 4)
		{
			//add 1 to y because we are moving up
			headPositionY++;
		}
		else if(direction == 5)
		{
			//subtract 1 from y because we are moving down
			headPositionY++;

		}
		else
		{
			throw new IllegalStateException("advanceForward must receive a direction between 0 and 5, received: " + direction );
		}
			
			//Save new position to array after we convert it back
			anArrayList.add( 0, ConvertLedType.relativeToAbsolute( headPositionX, headPositionY, headPositionZ ));
			System.out.println("Snake is now at "+ anArrayList.get(0));
			//Save new array to Snake Bean
			aSnake.setBodyPositions( anArrayList );
			//Mark the arrayList null so it will be cleaned up by the garbage collector
			anArrayList = null;
			
			
		
	}
	
	public void appleCheck(model.Snake aSnake)
	{
		ArrayList<Integer> anArray = aSnake.getBodyPositions();
		
		int headPosition = anArray.get(0);
		System.out.println("headposition is " + headPosition);
		
		int numberOfApples = model.Arena.aListOfApples.size();
		System.out.println("numberOfApples is now: "+ numberOfApples);
		
//		System.out.println("Apple Position is "+ model.Arena.aListOfApples.get(0).getAbsolutePosition() );
		
		for ( numberOfApples = model.Arena.aListOfApples.size() - 1; numberOfApples >=0; numberOfApples--)
		{
			if ( model.Arena.aListOfApples.get(numberOfApples).getAbsolutePosition() == headPosition )
			{
				System.out.println("We have hit an apple!!!!!!!!");
				//Check to see if we got our own apple or someone else's
				if(model.Arena.aListOfApples.get(numberOfApples).getColor() != aSnake.getColor() )
				{
					//Add 100 points to the score;
					aSnake.setScore(100);
					
				}
				else 
					aSnake.setScore(200);
				
				
					//TODO:Delete the Apple
				
				
				
				
			}
			else
			{
				System.out.println("Didn't find an apple here");
			}
			System.out.println("We have finished evaluating stuff");
			System.out.println("" );
		}
		
		
				
	}
	
	
	 /**
     * Returns whether the snake has collided with a wall
     * Checks the Arena.isSolidWalls to see if wall collisions kill the snake
     * If the snake attempts to go past the wall and  Arena.isSolidWalls = true; the snake is dead
     * If Arena.isSolidWalls = false this method always returns false since the snake can 
     * never die from a wall collision in that situation.
     * 
     * A snake dies if the head position goes to -1 or greater than there are leds, either 8 or 16 for most cubes
     * The cube is always assumed to be base 0. The first led in the cube is 0,0,0
     *
     *@return true
     *@return false
     *@see bodyCollisionCheck
     *@see appleCheck
     */

/*
    public boolean hasCollidedWithWall()
    {
    	//Arena.getInstance();
		//If the mode has wall collisions , check
        if ( Arena.isSolidWalls() == true)
        {
        	if( ConvertLedType.absoluteToXPositionInRow(currentHeadPosition) >= 0 &&  ConvertLedType.absoluteToXPositionInRow(currentHeadPosition) <= Arena.xMaximum && 
        		ConvertLedType.absoluteToYPositionInPanel(currentHeadPosition) >= 0 &&  ConvertLedType.absoluteToYPositionInPanel(currentHeadPosition) <= Arena.yMaximum &&
        		ConvertLedType.absoluteToZPositionInCube(currentHeadPosition) >= 0 &&  ConvertLedType.absoluteToZPositionInCube(currentHeadPosition) <= Arena.zMaximum	)
        	{
        		
        		//Player is inside all bounds
        		return false;
        		
        	}
        	//Player has attempted to go outside walls, player is dead
        	else return true;
        	
        }
        //If the walls are turned off
        else 
        {
        	//If the walls are invisible, then we cant possibly die by hitting them now can we. 
        	return false;
        }
        
        
    }//end wallCollisionCheck()
 */   
}
