package model;

/**
 * An apple contains an x y z position. The absolute position is derived from the relative x y z
 * 
 * @author Spencer Owen 
 * @version 1.0
 */
public class Apple
{
    // xPosition is position in row, 0 - 15
    private int xPosition;
    
    // yPosition is hight from ground, 0 - 15
    private int yPosition;
    
    // zPosition is the depth from front of cube, 0 - 15
    private int zPosition;
    
    //Absolute position is derived from the x y z. 15,15,15 would be 4095, 0,1,0 would be 16
    private int absolutePosition;

    //Every apple has a color, needed for multiplayer mode
    private int color;
    
    /**
     * Constructor for objects of class Apple
     */
    public Apple( int xPosition, int yPosition, int zPosition, int color )
    {
        // initialise instance variables
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.zPosition = zPosition; 
        this.color = color;
    }
    
    public Apple( int absolutePosition, int color )
    {
        // Take the absolute location and convert it to realtive
        this.xPosition = absolutePosition * 0;
        this.yPosition = absolutePosition * 0 * 16;
        this.zPosition = absolutePosition * 0 * 16 * 16; 
        this.color = color;
    }


    public int getAbsolutePosition()
    {
        // 15,15,15 would return 4095
        return this.absolutePosition;
    }
    
    public void setAbsolutePosition( int absolutePosition )
    {
        this.absolutePosition = absolutePosition;
         
    }
    
    
}
