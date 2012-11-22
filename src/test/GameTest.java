package test;

import static org.junit.Assert.*;

import model.CubeAttributes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GameTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//Set the cube attributes
		
		model.CubeAttributes.setxNumberOfLedsPerRow(16);
		model.CubeAttributes.setyNumberOfRowsPerPanel(16);
		model.CubeAttributes.setzNumberOfPanelsPerCube(16);
		CubeAttributes.xNumberOfLedsPerRow = 16;
		CubeAttributes.yNumberOfRowsPerPanel = 16;
		CubeAttributes.zNumberOfPanelsPerCube = 16;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void destroyAppleTest() {
		model.Game aGame = new model.Game();
		aGame.createApple(255);
		assertEquals(1, aGame.getaListOfApples().size() );
		aGame.destroyApple(aGame.getaListOfApples().get(0));
		assertEquals(0, aGame.getaListOfApples().size() );
	}
	
	@Test(expected=NullPointerException.class)
	public void destroyAppleTesetException1() {
		
		//Destroying an apple should throw a handled null pointer exception
		model.Apple aNullApple = null;
		model.Game aGame = new model.Game();
		aGame.destroyApple(aNullApple);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
//	@Test
	public void destroyAppleTesetException2() {
		//Test what happens when an apple doesn't exist
		model.Apple aFakeApple = new model.Apple(4095, 255);
		//Create a game and add apples to it
		model.Game aGame = new model.Game();
		aGame.createApple(99);
		aGame.createApple(300);
		aGame.destroyApple(aFakeApple);
	}
	
}
