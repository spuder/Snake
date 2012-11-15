package model;
import java.util.ArrayList; 

/**
 * Snake has a position, speed, length
 * 
 * @author Spencer Owen 
 * @version 1.0
 */
public class Snake 
{
    // instance variables - replace the example below with your own
    private int length = 3;
    private int speed;
    private int currentHeadXPosition;
    private int currentHeadYPosition;
    private int currentHeadZPosition;
    
    //This should be derived in the getter method
//    private int currentHeadAbsolutePosition;
    
    /*
     * We need to know the next head position for the first levels where the snake moves very slowly, 
     * basically we need to buffer where the user wants to go for several milliseconds until the snake 
     * actually moves. 
     */
    
    private int nextHeadXPosition;
    private int nextHeadYPosition;
    private int nextHeadZPosition;
    
    private int nextHeadAbsolutePosition;
    
    /*Keep all the locations of where a snake is inside an array, Use arraylist because it is much 
    * easier to append to the end, 
    */
    private ArrayList<Integer> snakeBodyPosition; 
    

    /*
     * Constructor for objects of class Snake
     */
    public Snake()
    {
        snakeBodyPosition = new ArrayList<Integer>();
    }

    /*
     * An iteration has occurred, move the snake forward one
     */
    public void advanceForward()
    {
       
        //Move snake forward one
    	//Dont do any checking here. The checks should be done outside this class

        bodyCollisionCheck();
    }
    
    /*
     * See if we have hit any walls, out own body, other snakes or an apple / antiapple
     */
    public void bodyCollisionCheck()
    {
        
    }
    
    /*
     * See if we have hit an apple, if the apple is my own color give points, if other color, give less points
     * 
     */
    public void appleCheck()
    {
        //If we hit an apple, add points and make length longer
    }
    
   
    public void updateBodyPosition()
    {
    	//No changing of the array list length should take place here, that will be handled outside this class
    	//By definition java beans are only data storage classes with basic getters and setters
    	
    	//Push array[0] to array[1] ect...
       //Take nextHeadPosition and set to array[0]
       
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
    public boolean hasCollidedWithWall()
    {
    	//Arena.getInstance();
		//If the mode has wall collisions , check
        if ( Arena.isSolidWalls() == true)
        {
        	if( currentHeadXPosition >= 0 &&  currentHeadXPosition <= Arena.xMaximum && 
        		currentHeadYPosition >= 0 &&  currentHeadXPosition <= Arena.yMaximum &&
        		currentHeadZPosition >= 0 &&  currentHeadZPosition <= Arena.zMaximum	)
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
    
    /**
     * Increases the speed of the snake by 1
     * @see decreaseSpeed
     */
    public void increaseSpeed()
    {
        this.speed++;
    }
    
    /**
     * Decreases the speed of the snake by 1
     * The minimum value is 0 and can not go past that
     * @see increaseSpeed
     */
    public void decreaseSpeed()
    {
        //If speed is 0, don't decrease it any further
        if( this.speed > 0 )
        {
            this.speed--;
        }
    }
    
    public void increaseLength()
    {
        this.length++;
    }
    
    public void decreaseLength()
    {
        if ( !( this.length <= 3)  )
        { 
            this.length--;
        }
    }

	public int getCurrentHeadXPosition() {
		return currentHeadXPosition;
	}

	public void setCurrentHeadXPosition(int currentHeadXPosition) {
		this.currentHeadXPosition = currentHeadXPosition;
	}

	public int getCurrentHeadYPosition() {
		return currentHeadYPosition;
	}

	public void setCurrentHeadYPosition(int currentHeadYPosition) {
		this.currentHeadYPosition = currentHeadYPosition;
	}

	public int getCurrentHeadZPosition() {
		return currentHeadZPosition;
	}

	public void setCurrentHeadZPosition(int currentHeadZPosition) {
		this.currentHeadZPosition = currentHeadZPosition;
	}
}
