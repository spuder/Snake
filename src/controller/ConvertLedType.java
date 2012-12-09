package controller;

import java.util.Locale;

import org.apache.log4j.Logger;

public class ConvertLedType extends GameEnvironment{
	//Create a new logger for this class
	

	/**
	 * http://en.wikipedia.org/wiki/Singleton_pattern	
	 * There are two common implementations, lazy and eager. This code represents eager 
	 */
	//There should not ever be an instance of this class since it is a utility class
	//private static final ConvertLedType instance = new ConvertLedType();
	
	private ConvertLedType(){throw new IllegalStateException("The constructor of ConvertLedType was called, should not have been possible");}
	/*There should not ever be an instance of this class since it is a utility class
//		public static ConvertLedType getInstance()
//		{
//			return instance;
//		}
	*/
	
	
	public static int absoluteToXPositionInRow(int xNumberOfLedsPerRow, int yNumberOfRowsPerPanel, int zNumberOfPanelsPerCube, int absoluteLedNumber)
	{
		/**
		 * Retrieves the absolute led number of the first led in the same row then subtracts this led number
		 * to give the location in the row. On a 16x16x16 cube with 0,0,0 as the origin, this number will always be less than 15
		 */
		if (absoluteLedNumber < 0) throw new IllegalArgumentException("absoluteLedNumber must be greater than 0, received: " + absoluteLedNumber);
		

		int ledTotalRowNumber 		= (absoluteLedNumber / xNumberOfLedsPerRow); // 48 would return 3rd row TODO:Consider renaming locationInY
	    int ledPanelNumber 			= (absoluteLedNumber / xNumberOfLedsPerRow / yNumberOfRowsPerPanel); //4095 would return panel 15, 300 returns panel 1 TODO:Consider renaming to locationINZ 
	    int ledVerticalRowNumber 	= (ledTotalRowNumber - (yNumberOfRowsPerPanel * ledPanelNumber)); //we need to know how high from the ground, not how many rows there are total
	    int firstLedInRow 			= ((1 + ledVerticalRowNumber + ledPanelNumber * zNumberOfPanelsPerCube ) * yNumberOfRowsPerPanel - xNumberOfLedsPerRow);
	    return (absoluteLedNumber - firstLedInRow);

	}
	

	
	public static int absoluteToYPositionInPanel(int xNumberOfLedsPerRow, int yNumberOfRowsPerPanel, int zNumberOfPanelsPerCube, int absoluteLedNumber)
	{
		/**
		 * Takes an integer value representing the absolute location (eg. 4095) 
		 * and returns the relative y coordinate [x,y,z]. Assumes origin is base 0 [0,0,0]
		 * 
		 */
//		int ledsPerCube = ((SerialInterface) aListOfCubeTypes.get(activeCubeType)).getLedsPerCube();
		if (absoluteLedNumber < 0) 
			throw new IllegalArgumentException("absoluteLedNumber must be greater than 0, received: " + absoluteLedNumber);
//		if (absoluteLedNumber > ( (SerialInterface) aListOfCubeTypes.get(activeCubeType) ).getLedsPerCube() ) 
//			throw new IllegalArgumentException("absoluteLedNumber must be less than the maximum number of leds. Max led is " + ledsPerCube + " received: " + absoluteLedNumber ); 
//		
//		int xNumberOfLedsPerRow 	= ( (SerialInterface) aListOfCubeTypes.get(activeCubeType) ).getxNumberOfLeds();
//		int yNumberOfRowsPerPanel 	= ( (SerialInterface) aListOfCubeTypes.get(activeCubeType) ).getyNumberOfLeds();
//		int zNumberOfPanelsPerCube 	= ( (SerialInterface) aListOfCubeTypes.get(activeCubeType) ).getzNumberOfLeds();
		
		int ledTotalRowNumber     = (absoluteLedNumber / xNumberOfLedsPerRow);
		
		//4095 would return panel 15, 300 returns panel 1 
    	int ledPanelNumber        = (absoluteLedNumber / xNumberOfLedsPerRow / yNumberOfRowsPerPanel); 
    	
    	//We need to know how high from the ground, not how many rows there are total
        int ledVerticalRowNumber  = (ledTotalRowNumber - (yNumberOfRowsPerPanel * ledPanelNumber)); 
     	
		return ledVerticalRowNumber;
		
	}
	
	public static int absoluteToZPositionInCube(int xNumberOfLedsPerRow, int yNumberOfRowsPerPanel, int zNumberOfPanelsPerCube, int absoluteLedNumber)
	{
//		int ledsPerCube = ((SerialInterface) aListOfCubeTypes.get(activeCubeType)).getLedsPerCube();
//		
//		if (absoluteLedNumber < 0) 
//			throw new IllegalArgumentException("absoluteLedNumber must be greater than 0, received: " + absoluteLedNumber);
//		if (absoluteLedNumber > ledsPerCube) 
//			throw new IllegalArgumentException("absoluteLedNumber must be less than the maximum number of leds. Max led is " + ledsPerCube + " received: " + absoluteLedNumber ); 
//		
//		int xNumberOfLedsPerRow 	= ( (SerialInterface) aListOfCubeTypes.get(activeCubeType) ).getxNumberOfLeds();
//		int yNumberOfRowsPerPanel 	= ( (SerialInterface) aListOfCubeTypes.get(activeCubeType) ).getyNumberOfLeds();
//		int zNumberOfPanelsPerCube 	= ( (SerialInterface) aListOfCubeTypes.get(activeCubeType) ).getzNumberOfLeds();
		
		int ledTotalRowNumber     = (absoluteLedNumber / xNumberOfLedsPerRow);      
		//4095 would return panel 15, 300 returns panel 1 TODO:Consider renaming to locationINZ 
  	    int ledPanelNumber        = (absoluteLedNumber / xNumberOfLedsPerRow / yNumberOfRowsPerPanel); 
  	    
        //System.out.println("getPanelThatContainsLed was given " + absoluteLedNumber + " and is returning " + ledPanelNumber);
		return ledPanelNumber;

		
	}
	
	/**
	 * Takes the coordinates of an LED in relative format and returns the absolute value
	 * Passing in 15,15,15 would return 4095 assuming 0,0,0 is the origin (base 0)
	 * 
	 * 
	 * @param xPosition
	 * @param yPosition
	 * @param zPosition
	 * @return An integer value of the led number in the cube. Example (4095)
	 * @see relativeToAbsolute[x,y,z]
	 */
	public static int relativeToAbsolute(int xNumberOfLedsPerRow, int yNumberOfRowsPerPanel, int zNumberOfPanelsPerCube, int xPosition, int yPosition, int zPosition)
	{
//		if ( xPosition < 0 ) 
//			throw new IllegalArgumentException("absoluteLedNumber must be greater than 0, received: " + xPosition);
//		if ( yPosition < 0 ) 
//			throw new IllegalArgumentException("absoluteLedNumber must be greater than 0, received: " + yPosition);
//		if ( zPosition < 0 ) 
//			throw new IllegalArgumentException("absoluteLedNumber must be greater than 0, received: " + zPosition);
//		
//
//		int xNumberOfLedsPerRow 	= ( (SerialInterface) aListOfCubeTypes.get(activeCubeType) ).getxNumberOfLeds();
//		int yNumberOfRowsPerPanel 	= ( (SerialInterface) aListOfCubeTypes.get(activeCubeType) ).getyNumberOfLeds();
//		int zNumberOfPanelsPerCube 	= ( (SerialInterface) aListOfCubeTypes.get(activeCubeType) ).getzNumberOfLeds();
		
		/*
		 * This formula was provided by Thomas and Desmond Makkugi 
		 * L = n*n*x + n*y + 1 
		 */
		int answerPart1 =  (zPosition  * (xNumberOfLedsPerRow * yNumberOfRowsPerPanel ) );
		int answerPart2 =  (yPosition  * xNumberOfLedsPerRow );
		int answerPart3 =  (xPosition  * 1 );
		return  (answerPart1 + answerPart2 + answerPart3) ;
	}
	
	/**
	 * Takes the coordinates of an LED in relative format and returns the absolute value
	 * Passing in [15,15,15] would return 4095 assuming 0,0,0 is the origin (base 0)
	 * 
	 * @param arrayOfLeds
	 * @return An integer value of the led number in the cube. Example (4095)
	 * @see relativeToAbsolute
	 */
	public static int relativeToAbsolute(int xNumberOfLedsPerRow, int yNumberOfRowsPerPanel, int zNumberOfPanelsPerCube, int[] arrayOfLeds)
	{
		
		return relativeToAbsolute( xNumberOfLedsPerRow,  yNumberOfRowsPerPanel,  zNumberOfPanelsPerCube, arrayOfLeds[0], arrayOfLeds[1], arrayOfLeds[2]);
		
	}
	
	/**
	 * Converts an integer representation of a 6 hex value and returns a 6 hex String
	 * Example intToHex(16777215) returns "FFFFFF"
	 * 
	 * If the hex is longer than 6 characters, only the tailing 6 digits are returned
	 * This is because some values can return a hex 8 digits long. The two leading characters
	 * represent the alpha channel. This information is not needed. 
	 * 
	 * @param int color
	 * @return string
	 * @see hextToInt
	 */
	public static String intToHex(int color)
	{ 
		
		String answer = Integer.toHexString(color);
		
		//Only return the last 6 digits of an 8 digit Hex
		if (answer.length() > 6)
			answer.substring(answer.length() - 6);
		return answer.toUpperCase();	
		
		//TODO: strings starting with 00 are truncated, 00FF00 returns just FF00, see github issue #1
		

	}
	
	/**
	 * Takes a String representation of a hex color and returns an integer
	 * Example hexToInt("FFFFFF") returns 16777215
	 * 
	 * If the parameter is longer than 6 characters long, it is truncated to the tailing 6 characters
	 * Some colors have 8 characters. The leading 2 characters represent the alpha channel in the color specturm. 
	 * The alpha channel is not needed. 
	 * 
	 * @param sixOrEightDigitHexString
	 * @return
	 * @see intToHex
	 */
	public static int hexToInt(String sixOrEightDigitHexString)
	{
		if (sixOrEightDigitHexString.length() > 6)
		{
			sixOrEightDigitHexString.substring(sixOrEightDigitHexString.length() - 6);
		}
			
		
		return Integer.parseInt(sixOrEightDigitHexString, 16);
	}
	
	/**
         * Takes the number of leds per x y z and returns how many leds are in the cube
	 * It basically does x*y*z however it can ignore a 0. 
	 * 
	 */
	public static int totalNumberOfLedsPerCube(int xNumberOfLedsPerRow, int yNumberOfRowsPerPanel, int zNumberOfPanelsPerCube)
	{
		// This is derived (x*y*z) allowing for 0's 
		int numberOfLedsPerCube = xNumberOfLedsPerRow * yNumberOfRowsPerPanel;
		if ( zNumberOfPanelsPerCube > 0)
		{
			numberOfLedsPerCube = numberOfLedsPerCube * zNumberOfPanelsPerCube;
		}
		return numberOfLedsPerCube;
	}

}
