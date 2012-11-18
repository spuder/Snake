package model;
import java.util.ArrayList; 
import java.util.Random;

/**
 * Write a description of class Arena here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public  class Arena
{
	//This is the singleton pattern which assures only 1 instance can and is created
	private static final Arena instance = new Arena();
	public static Arena getInstance()
	{
		return instance;
	}
	
 
	
    public static int xMaximum;
    public static int yMaximum;
    public static int zMaximum;
    
    public static boolean solidWalls = false;
    


	public static ArrayList<Apple> aListOfApples = new ArrayList<Apple>();
	public static ArrayList<Snake> aListOfSnakes = new ArrayList<Snake>();
	
    //Since this is a singleton pattern, we make this method unaccessible on purpose
    private  Arena() {}

    /*
     * Method to create a new instance of an apple when an apple has been eaten or at beginning of game
     */
   
    
    public static boolean isSolidWalls() {
		return solidWalls;
	}

	public static void setSolidWalls(boolean solidWalls) {
		Arena.solidWalls = solidWalls;
	}
    
    
}
