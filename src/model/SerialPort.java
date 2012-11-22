package model;

import jssc.SerialPortList;

/**
 * 
 * @author spencerowen
 *
 */
public class SerialPort {

	
	private String[] aListOfSerialPorts;
	
	private static final SerialPort instance = new SerialPort();
	
	// This class has a private constructor so additional instances and child
	// classes can not be created
	private SerialPort(){}
	
	public static SerialPort getInstance() {
		return instance;
	}
	
	/**
	 * Returns a string array of all serial ports on computer
	 * If no serial ports are found then array index 0 contains 
	 * text "No Serial Ports on this machine"
	 * 
	 * @return The list of serial ports on computer
	 */
	public static String[] getaListOfSerialPorts() {
 
		 String[] aListOfSerialPorts = SerialPortList.getPortNames();
		  
		  if (aListOfSerialPorts.length <= 0) 
		  {
			  String[] listOfNoSerialPorts = new String[1];
			  listOfNoSerialPorts[0] ="No Serial Ports on this machine";
			  return listOfNoSerialPorts;
		  }
		 
		  return aListOfSerialPorts;	
	}

	
}
