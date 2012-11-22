package controller;

import java.util.List;

public class SeekwayCube implements SerialInterface {
	
	int serialBaudRate 	= 9999;
	int ledsPerCube 	= 4096;
	int xNumberOfLeds 	= 16;
	int yNumberOfLeds 	= 16;
	int zNumberOfLeds 	= 16;
	int base0or1 		= 0;
	

	public int getSerialBaudrate() {
		return serialBaudRate;
	}

	public int getBase0or1() {
		return base0or1;
	}

	public void writeToSerial(List ledsToWrite) {
		// TODO Auto-generated method stub

	}

	public List getCurrentCubeDisplay() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getComPort() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setComPort(String comPort) {
		// TODO Auto-generated method stub

	}

}
