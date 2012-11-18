package controller;

import static org.junit.Assert.*;

import model.Arena;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArenaControllerTest {

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
	public void createAppleTest()
	{
		Arena.xMaximum = 16;
		//Create an apple with color 255
		Arena.createApple(255);
	}


}
