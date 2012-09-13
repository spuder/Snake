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
    
    private int currentHeadAbsolutePosition;
    
    /**
     * We need to know the next head position for the first levels where the snake moves very slowly, 
     * basically we need to buffer where the user wants to go for several milliseconds until the snake 
     * actually moves. 
     **/
    
    private int nextHeadXPosition;
    private int nextHeadYPosition;
    private int nextHeadZPosition;
    
    private int nextHeadAbsolutePosition;
    
    /*Keep all the locations of where a snake is inside an array, Use arraylist because it is much 
    * easier to append to the end, 
    */
    private ArrayList<Integer> snakeBodyPosition; 
    

    /**
     * Constructor for objects of class Snake
     */
    public Snake()
    {
        snakeBodyPosition = new ArrayList<Integer>();
    }

    /*
     * An iteration has occured, move the snake forward one
     */
    public void advanceForward()
    {
       
        //Move snake forward one
        //Check if we hit an apple
        //Check if we hit an antiApple
        //Check if we hit an Obstacle
        //Check if we hit a snake body
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
    
    /*
     *  Move each body part forward one, If we hit an apple, then make us longer, if we hit anti apple, make us shorter
     */
    public void updateBodyPosition()
    {
        
    }
    
    /*
     * If snake hits a wall, set alive to false 
     */
    public boolean wallCollisionCheck()
    {
    	//If the mode has wall collisions , check
        if ( Arena.solidWalls == true)
        {
        	if( currentHeadXPosition >= 0 &&  currentHeadXPosition <= Arena.xMaximum && 
        		currentHeadYPosition >= 0 &&  currentHeadXPosition <= Arena.yMaximum &&
        		currentHeadZPosition >= 0 &&  currentHeadZPosition <= Arena.zMaximum	)
        	{
        		//Player is inside all bounds
        		return true;
        		
        	}
        	else return false;
        	
        }
        //If the walls are turned off
        else 
        {
        	//If the walls are invisible, then we cant possibly die by hitting them now can we. 
        	return true;
        }
        
        
    }//end wallCollisionCheck()
    
    
    public void increaseSpeed()
    {
        this.speed++;
    }
    
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
}
