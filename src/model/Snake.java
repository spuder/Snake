package model;
import java.util.ArrayList; 

import controller.ConvertLedType;

/**
 * Snake has a position, speed, length
 * 
 * @author Spencer Owen 
 * @version 1.0
 */
public class Snake 
{
    
	private int color;
	private int length;
	private int speed;
	private long lastMoveTime;
	
	/*Travel Direction
	 * 0 = north
	 * 1 = east
	 * 2 = south
	 * 3 = west
	 * 4 = up
	 * 5 = down
	 */
	private int travelDirection;
	private int score;
	private ArrayList<Integer> bodyPositions;
	private boolean alive;



    /*
     * Constructor for objects of class Snake
     */
    public Snake(int color, int travelDirection, ArrayList<Integer> bodyPositions, int speed)
    {
    	this.color = color;
    	this.length = 3;
    	this.speed = speed;
    	this.lastMoveTime = System.currentTimeMillis();
    	this.travelDirection = travelDirection;
    	this.score = 0;
    	this.bodyPositions = bodyPositions;
    	this.alive = true;
        
    }

    public Snake(String color, int travelDirection, ArrayList<Integer> bodyPositions, int speed)
    {
    	//Allow user to pass in "FFFFFF" and then convert it to the number
    	//integers are faster to compute than strings
    	this.color = ConvertLedType.hexToInt(color);
    	this.length = 3;
    	this.speed = speed;
    	this.lastMoveTime = System.currentTimeMillis();
    	this.travelDirection = travelDirection;
    	this.score = 0;
    	this.bodyPositions = bodyPositions;
    	this.alive = true;
        
    }


	public int getColor() {
		return color;
	}



	public void setColor(int color) {
		this.color = color;
	}
	
	
	public void setColor(String	 color) {
		this.color = ConvertLedType.hexToInt(color);
	}
	


	public int getLength() {
		return length;
	}



	public void setLength(int length) {
		//TODO: This should not be negative, or greater than the number of leds per cube (4096) in our case;
		this.length = length;
	}



	public int getSpeed() {
		return speed;
	}



	public void setSpeed(int speed) {
		//TODO:This should not be negative
		this.speed = speed;
	}



	public int getTravelDirection() {
		return travelDirection;
	}



	public void setTravelDirection(int travelDirection) {
		//TODO: Should not be any number except 0 - 5
		/*
		 * Travel Direction
		 * 0 = north 	//z++
		 * 1 = east 	//x++
		 * 2 = south 	//z--
		 * 3 = west 	//x--
		 * 4 = up 		//y++
		 * 5 = down 	//y--
		 */
		
		/*
		 * The user should not be able to set their direction to 180 degrees opposite
		 * If they try to, ignore it, but add it to the logs
		 * Example; Travel Direction = north, user can not set direction to south
		 * Example; Travel Direction = west, user can not set direction to east
		 */
		this.travelDirection = travelDirection;
	}



	public int getScore() {
		return score;
	}



	public void setScore(int score) {
		//TODO: allow negative scores
		//TODO: test that we are within 65,000 the maximum of Integer
		
		//Add the additional points to the existing score
		this.score = this.score + score;
	}



	/**
	 * Returns an arrayList of the positions of the snake
	 * All positions are in absolute values and assume origin = 0 (not 1)
	 * Example a snake 4 long might return -> bodyPositions[31,32,33,34]
	 * @return
	 */
	public ArrayList<Integer> getBodyPositions() {
		return bodyPositions;
	}



	public void setBodyPositions(ArrayList<Integer> bodyPositions) {
		//TODO: non of the items should be negative
		//Is is it really worth checking this? It would be expensive
		this.bodyPositions = bodyPositions;
	}


	/**
	 * Returns true if user is alive, false if user is dead
	 * 
	 * @return alive
	 */
	public boolean isAlive() {
		return alive;
	}



	public void setAlive(boolean alive) {
		//TODO: if we try and set the state to a state we are already in, we should log it
		
		this.alive = alive;
	}

	public long getLastMoveTime() {
		return lastMoveTime;
	}

	public void setLastMoveTime(long lastMoveTime) {
		this.lastMoveTime = lastMoveTime;
	}



    
 

	
}
