package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Snake;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SnakeTest {

	model.Snake aSnake;
	ArrayList<Integer> bodyPositions;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		// Create a list so we can create Snake objects to test
		bodyPositions = new ArrayList<Integer>();
		bodyPositions.add(0);
		bodyPositions.add(1);
		bodyPositions.add(2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSnakeConstructor1() {

	}

	/*
	 * Test to verify that an exception is thrown if the constructor receives
	 * illegal parameters
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSnakeConstructorException1() {

	}

	@Test
	public void testSnakeConstructor2() {

	}

	@Test(expected = IllegalArgumentException.class)
	public void testSnakeConstructorException2() {

	}

	@Test
	public void testGetColor() {
		// Create a snake, give it a color, and verify the return is the color
		// expected
		aSnake = new Snake("FFFFFF",0, 0, bodyPositions, 500);
		assertEquals("FFFFFF", aSnake.getColor());
		// Clear out the object to free up ram and prepare for next test
		aSnake = null;

		// Make sure that 8 bit Hex is truncated to 6 bit hex
		aSnake = new Snake("AAFFFFFF",0, 0, bodyPositions, 500);
		assertEquals("FFFFFF", aSnake.getColor());
		// Clear out the object to free up ram and prepare for next test
		aSnake = null;

	}

	@Test
	public void setColorInt() {
		// Set the snake color with an int, then verify it retrieved it
		// This success depends on getColor working properly
		aSnake = new Snake("FFFFFF",0, 0, bodyPositions, 500);
		aSnake.setColor(42);
		assertEquals("2A", aSnake.getColor());
		// Clear out the object to free up ram and prepare for next test
		aSnake = null;
	}

	@Test
	public void setLength() {
		aSnake = new Snake("FFFFFF",0, 0, bodyPositions, 500);
		aSnake.setLength(5);
		assertEquals(5, aSnake.getLength());
	}

	/*
	 * A method to make sure we throw an exception when passing in negative
	 * values. ONLY PUT 1 TEST PER METHOD HERE!
	 */
	@Test(expected = IllegalArgumentException.class)
	public void setLengthTestException1() {
		aSnake = new Snake("FFFFFF",0, 0, bodyPositions, 500);
		aSnake.setLength(-1);// This should throw an exception
		// DONT ADD ANY OTHER TESTS TO THIS METHOD, MAKE A NEW ONE
	}

	/*
	 * A method to make sure we throw an exception when passing in negative
	 * values. ONLY PUT 1 TEST PER METHOD HERE!
	 */
	@Test(expected = IllegalArgumentException.class)
	public void setLengthTestException2() {
		aSnake = new Snake("FFFFFF",0, 0, bodyPositions, 500);
		aSnake.setLength(1000000000);// This should throw an exception
		// DONT ADD ANY OTHER TESTS TO THIS METHOD, MAKE A NEW ONE
	}

}
