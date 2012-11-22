package controller;

import java.util.List;

public interface SerialInterface 
{
	
	/**
	 * Returns the speed of the serial port
	 * Common values include 9600, 115200
	 * 
	 * @return baudrate of serial port
	 */
	int getSerialBaudrate();
	
	/**
	 * Returns whether the cube starts at 0,0,0 or 1,1,1
	 * 
	 * @return 1 or 0 
	 */
	int getBase0or1();
	
	/**
	 * Sends a List (usually of type array) to the cube
	 * 
	 * @param ledsToWrite
	 */
	void writeToSerial(List ledsToWrite);
	
	/**
	 * Returns a List (usually of type array) that contains all the leds currently lit up
	 * This is useful to compare the current frame vs the next frame to only send the difference
	 * if the cube supports that
	 * @return
	 */
	List getCurrentCubeDisplay();
	
	/**
	 * Returns the current com port
	 * Example would be "/dev/tty/Arduino0" or "COM3"
	 * @return The String representation of the com port
	 */
	String getComPort();
	
	/**
	 * Sets the currently used com port
	 * Example would be "/dev/tty/Arduino0" or "COM3"
	 * 
	 */
	void setComPort(String comPort);

	
}
