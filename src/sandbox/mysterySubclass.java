package sandbox;

public class mysterySubclass extends mystery {
	
	public void mysterySubclass() {}
	public void addToArray2() {
		aList.add("bar");
	}
	
	public void printArray2() {
		System.out.println( "printArray2 " + super.aList.get(0) +"" );
	}

}
