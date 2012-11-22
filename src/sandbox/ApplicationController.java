package sandbox;

import java.util.HashMap;
import java.util.Map;

public class ApplicationController {

	private static Map<String, Handler> controlHash = new HashMap<String, Handler>();
	static{

	
	//can we use reflection to set the types of these items in the hashmap so that we don't have to work so hard to get them
	
	AdaptiveHandler theAdaptiveHandler = new AdaptiveHandler();
	controlHash.put("Adaptive", theAdaptiveHandler);
	
	HypnoHandler theHypnoHandler = new HypnoHandler();
	controlHash.put("Hypno", theHypnoHandler);
	

	
	}	

	public static void handleRequest(String command, Object ... parameters) {
		//instead of setting to handler can we use reflection to set the Type of anOperation
		//to the type of the result of controlHash.get(command); thereby giving us flexibility
		Handler anOperation = controlHash.get(command);
		anOperation.handleIt(parameters);
	}
}
