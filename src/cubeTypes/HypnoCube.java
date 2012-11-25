package cubeTypes;

import java.util.List;

import controller.SerialInterface;

public class HypnoCube implements SerialInterface {

	int serialBaudRate 	= 9600;
	int ledsPerCube 	= 512;
	int xNumberOfLeds 	= 8;
	int yNumberOfLeds 	= 8;
	int zNumberOfLeds 	= 8;
	int base0or1 		= 0; // Some cubes consider 1,1,1 the origin, others consider
						// 0,0,0 the origin

	

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
	public int getxNumberOfLeds() {
		return xNumberOfLeds;
	}


	@Override
	public int getyNumberOfLeds() {
		return yNumberOfLeds;
	}


	@Override
	public int getzNumberOfLeds() {
		return zNumberOfLeds;
	}


	@Override
	public int getLedsPerCube() {
		return ledsPerCube;
	}

	public String toString() {
		return "Hypno Cube";
	}
}
