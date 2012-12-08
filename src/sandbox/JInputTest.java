/* Test code to find enviornment and list out the controllers
 * This code uses JInput exclusivly, see TestControllers for a better solution
 * which uses lwjgl as a wrapper around JInput
 * 
 * 
 */
package sandbox;
import java.io.File;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.*;

	


import net.java.games.input.*;

public class JInputTest {
    
    Controller aController;
    

 	public static void main(String[] args) { 
            
            System.out.println(new File(".").getAbsolutePath());
            
           //
            System.out.println("Alright spencer your working directory is: " + new File(".").getAbsolutePath() );
		System.out.println("JInput version: " + Version.getVersion()); 
		
                ControllerEnvironment ce = ControllerEnvironment.getDefaultEnvironment(); 
		Controller[] cs = ce.getControllers(); 
		
                for (int i = 0; i < cs.length; i++) 
			System.out.println(i + ". " + cs[i].getName() + ", " + cs[i].getType() ); 
                
        }	  
        
        
       
    
        
                
}	
		