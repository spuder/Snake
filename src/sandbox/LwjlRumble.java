/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

//import org.lwjgl.input.Controller;
//import org.lwjgl.input.Controllers;
//import org.lwjgl.util.input.ControllerAdapter;
//
//import org.lwjgl.util.jinput.LWJGLEnvironmentPlugin;

import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.Rumbler;


/**
 *
 * @author spencerowen
 */
public class LwjlRumble  {

 
static Controller aController;
static Rumbler[] listOfRumblers;
    
    
    
public static void getControllers() {
    for (Controller tempController : ControllerEnvironment.getDefaultEnvironment().getControllers() )
     {
         if (tempController.getType() == Controller.Type.GAMEPAD) {
             System.out.print("Found a Controller");
             aController = tempController;
             listOfRumblers = tempController.getRumblers();
             System.out.println("Controller has " + tempController.getRumblers().length + " rumblers");
         }
         
         
     }
  
}



    
    public static void main(String[] args) {
     getControllers();
     for ( Rumbler tempRumbler : listOfRumblers ){
         tempRumbler.rumble(65000);
     }
     

    }
          

    
}
