package controller;

import java.util.List;
import jssc.SerialPortList;

public class AdaptiveCube implements SerialInterface {

	int serialBaudRate 	= 11520;
	int ledsPerCube 	= 4096;
	int xNumberOfLeds 	= 16;
	int yNumberOfLeds 	= 16;
	int zNumberOfLeds 	= 16;
	int base0or1 = 1; // Some cubes consider 1,1,1 the origin, others consider
						// 0,0,0 the origin
	String comPort;

	public AdaptiveCube() {
		super();
		

	}

	public int getSerialBaudrate() {
		return serialBaudRate;
	}

	public int getBase0or1() {
		return base0or1;
	}
	
	public String getComPort() {
		return comPort;
	}
	
	public void setComPort(String comPort) {
		this.comPort = comPort;
	}

	public void writeToSerial(List ledsToWrite) {
		// TODO Auto-generated method stub

	}

	public List getCurrentCubeDisplay() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * 
	 * System.out.println("About to print serial ports"); // Example code to
	 * list out all the serial ports
	 * 
	 * String[] portNames = SerialPortList.getPortNames();
	 * System.out.println("portNames.length = " + portNames.length ); if
	 * (portNames.length <= 0) { System.out.println(
	 * "There do not appear to be any Serial Ports on this machine"); } else {
	 * for(int i = 0; i < portNames.length; i++){
	 * System.out.println(portNames[i]); } }
	 */

}
