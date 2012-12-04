package cubeTypes;

import java.util.List;

import controller.SerialInterface;
import jssc.SerialPortList;

public class AdaptiveCube implements SerialInterface  {

	private int serialBaudRate 	= 11520;
	private int ledsPerCube 	= 4096;
	private int xNumberOfLeds 	= 16;
	private int yNumberOfLeds 	= 16;
	private int zNumberOfLeds 	= 16;
	private int base0or1 		= 1; // Some cubes consider 1,1,1 the origin, others consider
						// 0,0,0 the origin
	private List currentCubeDisplay;
	
	

	public AdaptiveCube() {

	}

	

	public int getSerialBaudrate() {
		return serialBaudRate;
	}

	public int getBase0or1() {
		return base0or1;
	}
	

	public void writeToSerial(List ledsToWrite) {
		//Take each item in array
		//Construct a message
		//Send over Serial
		

	}

	public List getCurrentCubeDisplay() {
		return currentCubeDisplay;
	}



	public int getxNumberOfLeds() {
		return xNumberOfLeds;
	}


	public int getyNumberOfLeds() {
		return yNumberOfLeds;
	}


	public int getzNumberOfLeds() {
		return zNumberOfLeds;
	}


	public int getLedsPerCube() {
		return ledsPerCube;
	}

	public String toString() {
		return "Adaptive Cube";
	}

}
