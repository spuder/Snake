package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SnakeTest {

	model.Snake aSnake;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSnakeConstructor() {
		
		
	}
	
	@Test
	public void testAdvanceForward()
	{
		
	}
	
	@Test 
	public void testBodyCollisionCheck()
	{
		
	}
	
	@Test
	public void testAppleCheck()
	{
		
	}
	
	@Test
	public void testUpdateBodyPosition()
	{
		
	}
	
	@Test
	public void testHasCollidedWithWall()
	{
		
		//Set the area attributes, since Arena is a singleton,
		//we access it statically
		Arena.setSolidWalls(true);
		
		//Create a snake with valid parameters
		aSnake = new Snake();
		aSnake.setCurrentHeadYPosition(0);
		aSnake.setCurrentHeadYPosition(0);
		aSnake.setCurrentHeadZPosition(0);
		
		//The snake should return that they are not hitting a walls
		/*
		 * This is our optimistic test, aka happy path
		 * other tests are much more evil then this (negatives, nulls sql injection, ect)
		 */
		assertEquals(false, aSnake.hasCollidedWithWall() );
		
		
	//Test 2***************************************************	
		//Set the area attributes, since Arena is a singleton,
		//we access it statically
		Arena.setSolidWalls(false);
		
		//Create a snake with valid parameters
		aSnake = new Snake();
		aSnake.setCurrentHeadYPosition(-1);
		aSnake.setCurrentHeadYPosition(-1);
		aSnake.setCurrentHeadZPosition(-1);
		
		assertEquals(false, aSnake.hasCollidedWithWall() );
		
		
		
	}

}
