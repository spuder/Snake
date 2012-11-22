package controller;

import java.util.List;

public class HypnoCube implements SerialInterface {

	int serialBaudRate 	= 9600;
	int ledsPerCube 	= 512;
	int xNumberOfLeds 	= 8;
	int yNumberOfLeds 	= 8;
	int zNumberOfLeds 	= 8;
	int base0or1 		= 0; // Some cubes consider 1,1,1 the origin, others consider
						// 0,0,0 the origin
	String comPort;
	

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


	@Override
	public int getxNumberOfLeds() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getyNumberOfLeds() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getzNumberOfLeds() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getLedsPerCube() {
		// TODO Auto-generated method stub
		return 0;
	}

}
