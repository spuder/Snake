package test;

import static org.junit.Assert.*;

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
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
	public void destroyAppleTeset() {
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
	
//	@Test(expected=IllegalArgumentException.class)
	public void destroyAppleTesetException2() {
		//Test what happens when an apple doesn't exist
	}
	
}
