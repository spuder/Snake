/*
 *This is my hacked attempt to get controllers working
 * While it does print them to the screen, it uses an ugly mix of JInput and lwjgl
 * See TestControllers for  a lwjgl exclustive solution
 */
package sandbox;


import java.util.HashMap;
import java.util.Map;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.Event;
import net.java.games.input.EventQueue;
import org.lwjgl.LWJGLException;
//import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.input.ControllerAdapter;


/**
 *
 * @author spencerowen+
 */ 
public class LwjlControllerTest {
    
    static Controller aController1;
    static Controller aController2;
    
    static Map<String, Controller> aMapOfControllers;
    
    //http://www.youtube.com/watch?v=lIdmpaWf9Eo
    //Create a controller

    
    
// public static boolean ControllerPoll(Controller atempController) {
//     if (atempController.isButtonPressed(0) == true) {
//         return true;
//     }
//     else return false;
// }
    
 public static void main(String[] args) {
     
     
     System.out.println(Display.getVersion() );
     
     aMapOfControllers = new HashMap<String, Controller>();
     
//     Controller joystick = null;
     
     
     //Create keys that identify the controller in the hashmap
     String[] listOfPlayers = new String[4];
     listOfPlayers[0] = "Player1";
     listOfPlayers[1] = "Player2";
     listOfPlayers[2] = "Player3";
     listOfPlayers[3] = "Player4";
     int currentPlayer = 0;
     
     //Look at every device connected, if it is of type controller, add it to the list of controllers
     for (Controller tempController : ControllerEnvironment.getDefaultEnvironment().getControllers() )
     {
         System.out.println("Found a device it is a : " + tempController.getType() );
         //See if controller is a joystick or gamepad
         if (tempController.getType() == Controller.Type.GAMEPAD) {
             
             if ( (currentPlayer + 1) > listOfPlayers.length ) {
                 throw new IllegalStateException("Limit is 4 players, cannot create 5th controlelr");
             }
             else {
                aMapOfControllers.put(listOfPlayers[currentPlayer], tempController);
                currentPlayer++;
             }
             
//             joystick = tempController;
//             System.out.println("Created gampad " + joystick.getName() );
                          System.out.println("Created gampad " + tempController.getName() );

         }
     }
     
     //If we have looked at every device, and none is type controller, then exit
     if (aMapOfControllers.size() < 1) {
         System.out.println("No Gamepad/Joystick found");
         System.exit(1);
     }
     
    //http://www.java-gaming.org/topics/getting-started-with-jinput/16866/view.html 
    

     
     /* TODO: This code is inflexible, It crashes if you have too many controlllers*/
     /* Its only purpose is to display out all the buttons on each controller  removing*/
     /*
    Component[] controller0Components =  aMapOfControllers.get("Player1").getComponents();
    Component[] controller1Components =  aMapOfControllers.get("Player2").getComponents();
    Component[] controller2Components =  aMapOfControllers.get("Player3").getComponents();
    Component[] controller3Components =  aMapOfControllers.get("Player4").getComponents();
    
    for (int padButtons = 0; padButtons < controller0Components.length; padButtons++) {
        System.out.println("Component " + padButtons + ": " + controller0Components[padButtons].getName() );
        controller0Components =  aMapOfControllers.get("Player1").getComponents();
        controller0Components =  aMapOfControllers.get("Player2").getComponents();
        controller0Components =  aMapOfControllers.get("Player3").getComponents();
        controller0Components =  aMapOfControllers.get("Player4").getComponents();
            
         
    } */
     
     
        try {
            Display.setDisplayMode(new DisplayMode(640, 480));
            Display.setTitle("Display Test");
            Display.create();   
            Display.update();
        } catch (LWJGLException e) {
            System.err.println("Display wasn't initialized correctly.");
            System.exit(1);
        }
 
        
        while (!Display.isCloseRequested()) {
            Display.update();
            Display.sync(60);
            
            
            
            if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
                System.out.println("you are pressing left");
            }
            
            
            /* *********Start of CodingUniverse Code
             
            
            joystick.poll();
            for (Component e : joystick.getComponents())
            {
                System.out.println(e.getName() + ": " + e.getPollData() );
      
            }
        }//end while display is requesetd 
            
          * 
             */  
            
///* *****************START OF CODE FOUND ON JAVAGAMMING *****************************

            EventQueue aQueue;
            Event anEvent = new Event();
            
            for( Map.Entry tempEntry : aMapOfControllers.entrySet() ) {
                Controller tempController =  (Controller) tempEntry.getValue();
                
                tempController.poll();
                aQueue = tempController.getEventQueue();
                
                
                
           
//            joystick.poll();

            
//            http://www.java-gaming.org/topics/getting-started-with-jinput/16866/view.html
            while(aQueue.getNextEvent(anEvent)) {
                
               //Create a buffer to print all the output at once 
               StringBuffer buffer = new StringBuffer(tempController.getName());
               //Add word "at" to buffer
               buffer.append(" at ");
               //Add nanoseconds which event occured to buffer
               buffer.append(anEvent.getNanos()).append(", ");
               /*Componenet = 1 button or trigger. 
                 dpads sometimes are 1 component with 4 values
                 xbox dpads are 4 components
                 triggers are 1 component
                 xbox triggers are analog
               */ 
               Component comp = anEvent.getComponent();
               buffer.append(comp.getName()).append(" changed to ");
               float value = anEvent.getValue(); 
               //Save the analog values to the buffer
               
               if(comp.isAnalog()) {
                  buffer.append(value);
               } 
               //Save the digital values to the buffer
               else {
                  if(value==1.0f) {
                     buffer.append("On");
                  } 
                  else {
                     buffer.append("Off");
                  }
               }
               if (comp.getName().equalsIgnoreCase("14") && value==1.0f ) {
                   System.out.println(tempEntry.getKey() + " Turning right");
               }
               if (comp.getName().equalsIgnoreCase("12") && value==1.0f ) {
                   System.out.println(tempEntry.getKey() + " Turning Down");
               }
               if (comp.getName().equalsIgnoreCase("13") && value==1.0f ) {
                   System.out.println(tempEntry.getKey() + " Turning left");
               }
               if (comp.getName().equalsIgnoreCase("11") && value==1.0f ) {
                   System.out.println(tempEntry.getKey() + " Turning up");
               }
               if (comp.getName().equalsIgnoreCase("8") && value==1.0f ) {
                   System.out.println(tempEntry.getKey() + " Start Button");
               }
               if (comp.getName().equalsIgnoreCase("9") && value==1.0f ) {
                   System.out.println(tempEntry.getKey() + " Pause Button");
               }
               if (comp.getName().equalsIgnoreCase("5") && value==1.0f ) {
                   System.out.println(tempEntry.getKey() + " Right Bumper");
               }
               if (comp.getName().equalsIgnoreCase("4") && value==1.0f ) {
                   System.out.println(tempEntry.getKey() + " Left Bumpter");
               }
              
               //Print all data to console
//               System.out.println(buffer.toString());
               
            }//end while there is still an event in the buffer
            
            }//end while anEvent
        }//end while Display.isCloseRequested
        
        try {
            Thread.sleep(20);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        
                
//********************** End of java gaming code ******/
                    
                    //This solution is old, version 2 has event queues making this unessisary
//            http://www.java-gaming.org/topics/getting-started-with-jinput/16866/view.html
//           Component[] components = joystick.getComponents();
//           StringBuffer buffer = new StringBuffer();
//           for ( int i=0; i<components.length;i++) {
//               if (i>0) {
//                   buffer.append(", ");
//               }
//               buffer.append(components[i].getName() );
//               buffer.append(": ");
//           }

        Display.destroy();
        System.exit(0);
    }
    
    
    
    
}
