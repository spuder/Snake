package model;
import java.util.ArrayList; 

/**
 * Write a description of class Arena here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public  class Arena
{
	//This is the singleton patter which assures only 1 instance can and is created
	private static final Arena instance = new Arena();
	public static Arena getInstance()
	{
		return instance;
	}
	
    // instance variables - replace the example below with your own
    public static int xMaximum;
    public static int yMaximum;
    public static int zMaximum;
    
    public static boolean solidWalls = false;
    


	public static ArrayList<Apple> aListOfApples;
//    public ArrayList<AntiApple> aListOfAntiApples;

    //Since this is a singleton pattern, we make this method unaccessable on purpose
    private  Arena() {}

    /*
     * Method to create a new instance of an apple when an apple has been eaten or at begining of game
     */
    public static void createApple()
    {
        //Generate a random number between 0 and the cube max (4095), 
        //If the position is not currently inside a snake or an obstacle
        //If the position is not directly infront of the user
            //Then create an apple
        //Apple aApple = new Apple();
        
    }
    
    public static void destroyApple()
    {
        
    }
    
    public static boolean isSolidWalls() {
		return solidWalls;
	}

	public static void setSolidWalls(boolean solidWalls) {
		Arena.solidWalls = solidWalls;
	}
    
    
}