package model;

/**
 * An apple contains an x y z position. The absolute position is derived from the relative x y z
 * 
 * @author Spencer Owen 
 * @version 1.0
 */
public class Apple
{
    
    //Absolute position is derived from the x y z. 15,15,15 would be 4095, 0,1,0 would be 16
    private int absolutePosition;

    //Every apple has a color, the color associates it with a snake
    private int appleColor;
    
    //Allow for game mode where apples disappear after a while
    private long appleCreationTime;
    
    public Apple( int absolutePosition, int appleColor )
    {
        this.absolutePosition = absolutePosition;
        this.appleColor = appleColor;
        this.appleCreationTime = System.currentTimeMillis();
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

	public int getColor() {
		return appleColor;
	}

	public void setColor(int color) {
		this.appleColor = color;
	}


	public long getAppleCreationTime() {
		return appleCreationTime;
	}


	public void setAppleCreationTime(long appleCreationTime) {
		this.appleCreationTime = appleCreationTime;
	}
    
    
}
