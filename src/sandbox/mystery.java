package sandbox;

import java.util.ArrayList;
import java.util.List;

public class mystery {
	
	protected List<String> aList;

	public mystery() {
		aList = new ArrayList<String>();
	}
	
	public void addToArray() {
		//"foo" is successfully added to the arraylist
		aList.add("foo");
	}
	
	public void printArray() {
		System.out.println( "printArray " + aList.get(0) +"" );
	}
	public static void main(String[] args) {
		mystery prob1 = new mysterySubclass();
		//mystery prob1 = new mystery();
		//mysterySubclass prob2 = new mysterySubclass();
		mysterySubclass prob2 = (mysterySubclass)prob1;
		//add "foo" to array
		prob1.addToArray();
		//add "bar" to array
		prob2.addToArray2();

		//expect to print "foo", works as expected
		prob1.printArray();
		//expect to print "foo", but actually prints "bar"
		prob2.printArray();
		//expect to print "foo", but actually prints "bar"
		prob2.printArray2();
	}
	
}
