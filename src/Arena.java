import java.util.ArrayList; 
/**
 * Write a description of class Arena here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public  class Arena
{
    // instance variables - replace the example below with your own
    public static int xMaximum;
    public static int yMaximum;
    public static int zMaximum;
    
    public static boolean solidWalls = false;
    
    public ArrayList<Apple> aListOfApples;
    public ArrayList<AntiApple> aListOfAntiApples;

    /**
     * Constructor for objects of class Arena
     */
    public Arena()
    {
        aListOfApples = new ArrayList<Apple>();
        aListOfAntiApples = new ArrayList<AntiApple>();
    }

    /*
     * Method to create a new instance of an apple when an apple has been eaten or at begining of game
     */
    public void createApple()
    {
        //Generate a random number between 0 and the cube max (4095), 
        //If the position is not currently inside a snake or an obstacle
        //If the position is not directly infront of the user
            //Then create an apple
        //Apple aApple = new Apple();
        
    }
    
    public void destroyApple()
    {
        
    }
    
    
}
