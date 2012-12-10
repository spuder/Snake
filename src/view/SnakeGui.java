package view;


import controller.GameEnvironment;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.apache.log4j.Logger;

//import controller.SerialInterface;
//import controller.GameEnvrionment;

/**
 * SnakeGui has 1 JFrame and 3 JPanels so the user can set the game preferences
 * 
 * @author Spuder
 * @version 2012-November-23
 */
//@SuppressWarnings("serial")
public class SnakeGui extends JFrame {
	public Logger logger = Logger.getLogger(this.getClass() );
	
	//An object that implements the API, it can be an adaptive cube or seekway cube object
	controller.SerialInterface theCube;
	
	JPanel backgroundJPanel;
	JPanel aSerialJPanel;
	JPanel aPlayerJPanel;
	
	//A title object that we reuse to make pretty black borders around panels
	TitledBorder title;
	
	//Combo Box to choose the cube type
	final JComboBox cubeTypeComboBox;
	
	final JLabel xLedsPerCubeField;
	final JLabel yLedsPerCubeField;
	final JLabel zLedsPerCubeField;
	
	//Radio Buttons to select the number of players
	final JRadioButton player1;
	final JRadioButton player2;
	final JRadioButton player3;
	final JRadioButton player4;
	final ButtonGroup playerButtonGroup;
	
	final JComboBox serialPortComboBox;
	final JLabel baudRate;
	
	final JButton startButton;
	


	/**
	 * The snake gui constructor creates a JFrame and 3 JPanels
	 * 2 of the JPanels are added to the background JPanel which
	 * is then added to the JFrame
	 * 
	 * Displays the options for users to change the cube type, number
	 * of players ect. 
	 * @throws HeadlessException
	 */
	public SnakeGui() throws HeadlessException {

		//Set the active cube type to Adaptive
		controller.GameEnvironment.instance.activeCubeType = "Adaptive Cube"; //TODO: There must be a better way to do this with .toString. See line 20 lower
		
		//Create an Object of any type
		theCube =  (controller.SerialInterface) controller.GameEnvironment.instance.aListOfCubeTypes.get( controller.GameEnvironment.instance.activeCubeType );
		
		
/* *******Background JPanel***************/
		backgroundJPanel 	= new JPanel( new GridLayout() );
		backgroundJPanel.setVisible(true);
		
		
/* *******Serial JPanel***************/		
		aSerialJPanel 		= new JPanel();
		aSerialJPanel.setLayout(new BoxLayout(aSerialJPanel,BoxLayout.Y_AXIS) );
		
		//Create a black border around the panel and set a title along the top
		title  = BorderFactory.createTitledBorder( BorderFactory.createLineBorder(Color.black), "Cube" );
		title.setTitleJustification(TitledBorder.CENTER);
		aSerialJPanel.setBorder(title);
		
		//Set the background color of the serial JPanel to blue
//		aSerialJPanel.setBackground(Color.blue);
		
		//Look up every type of cube we have in the hashmap and add each to the combo box
		cubeTypeComboBox 	= new JComboBox(controller.GameEnvironment.aListOfCubeTypes.keySet().toArray() );
		
		//Set the default to always be the Adaptive Cube		  
//		cubeTypeComboBox.setSelectedItem("Adaptive"); //TODO: There must be a better way with .toString. See line 20 up
		cubeTypeComboBox.setSelectedItem(theCube.toString() );
		System.out.println(theCube.toString() );
		
		//Add the combo box to the serial JPanel
		aSerialJPanel.add(cubeTypeComboBox);
		

		xLedsPerCubeField = new JLabel();
		xLedsPerCubeField.setText("x = " + theCube.getxNumberOfLeds() +""); 
//		xLedsPerCubeField.setEditable(false);
		
		yLedsPerCubeField = new JLabel();
		yLedsPerCubeField.setText("y = " + theCube.getyNumberOfLeds() +"");
//		yLedsPerCubeField.setEditable(false);
		
		zLedsPerCubeField = new JLabel();
		zLedsPerCubeField.setText("z = " + theCube.getzNumberOfLeds() +"");
//		zLedsPerCubeField.setEditable(false);
				   

		//Create the Serial Port ComboBox
		serialPortComboBox = new JComboBox( model.SerialPort.getaListOfSerialPorts() );
		
		//Set the serial port to default, 
		serialPortComboBox.setSelectedIndex(0);

		baudRate = new JLabel();
		baudRate.setText( theCube.getSerialBaudrate() +"");
//		baudRate.setEditable(false);
			
		aSerialJPanel.add(xLedsPerCubeField);
		aSerialJPanel.add(yLedsPerCubeField);
		aSerialJPanel.add(zLedsPerCubeField);
		
		//Add serialPort combo box to Serial JPanel
		aSerialJPanel.add(serialPortComboBox);
		aSerialJPanel.add(baudRate);
		
		
		
/* *******Player JPanel***************/		
		aPlayerJPanel 		= new JPanel();
		aPlayerJPanel.setLayout(new BoxLayout(aPlayerJPanel,BoxLayout.Y_AXIS )) ;
			title  = BorderFactory.createTitledBorder( BorderFactory.createLineBorder(Color.black), "Players" );
			title.setTitleJustification(TitledBorder.CENTER);
		aPlayerJPanel.setBorder(title );
		
		//Create a radio button for every player
		player1 = new JRadioButton("1 Player");
		player2 = new JRadioButton("2 Player");
		player3 = new JRadioButton("3 Player");
		player4 = new JRadioButton("4 Player");
		
		//Set 4 player game as default
		player4.setSelected(true);
		
		//Add each button to the button group
		playerButtonGroup = new ButtonGroup();
		playerButtonGroup.add(player1);
		playerButtonGroup.add(player2);
		playerButtonGroup.add(player3);
		playerButtonGroup.add(player4);
		
		startButton = new JButton("Start Game");
		
		
		aPlayerJPanel.add(player1);
		aPlayerJPanel.add(player2);
		aPlayerJPanel.add(player3);
		aPlayerJPanel.add(player4);
		
		aPlayerJPanel.add(startButton);
		
		
		
		
		
/* *******Main JFrame***************/
		
		
		//Set the JFrame title
		this.setTitle("Snake");
		
		//Set the JFrame Close button action
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		//Add the to JPanels to the main background panel
		backgroundJPanel.add(aPlayerJPanel);
		backgroundJPanel.add(aSerialJPanel);

		//Add the background panel to the JFrame
		this.add(backgroundJPanel);
		
		//Set the size of the JFrame
		this.setSize(800, 496);
		//Set the JFrame to the center of the screen
		this.setLocationRelativeTo(null);
		
		//Set the JFrame visible
		this.setVisible(true);
		
		
		
		
		/* **********Action Listeners ****************/
		//Action Listener for the CubeType comboBox 
		cubeTypeComboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					logger.error("The user clicked to change the cube type to "+ (String) cubeTypeComboBox.getSelectedItem() );
					
					//Set the new cube type based on what the user selected
					controller.GameEnvironment.instance.activeCubeType = (String) cubeTypeComboBox.getSelectedItem();
					
					//Get the x y and z for the new cube type
					theCube =  (controller.SerialInterface) controller.GameEnvironment.instance.aListOfCubeTypes.get(controller.GameEnvironment.instance.activeCubeType);
					
					xLedsPerCubeField.setText("x = " + theCube.getxNumberOfLeds() +""); 
					yLedsPerCubeField.setText("y = " + theCube.getyNumberOfLeds() +"");
					zLedsPerCubeField.setText("z = " + theCube.getzNumberOfLeds() +"");
					
					baudRate.setText( theCube.getSerialBaudrate() +"");
					logger.debug("The system recognizes *"+ controller.GameEnvironment.instance.activeCubeType + "* as the current cube type");
					
				}});
		
		//Action Listener for the Start Button
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logger.error("User pressed start button");
				
				//Get number of Players
				//There are better ways to do this, but this solution seemed the simplest
				//http://stackoverflow.com/questions/201287/how-do-i-get-which-jradiobutton-is-selected-from-a-buttongroup
				int numberOfPlayers;
				if (player1.isSelected()) {
					logger.error("1 Player game is the active radio button");
					numberOfPlayers = 1;
				}
				else if( player2.isSelected()) {
					logger.error("2 Player game is the active radio button");
					numberOfPlayers = 2;
				}
				else if( player3.isSelected()) {
					logger.error("3 Player game is the active radio button");
					numberOfPlayers = 3;
				}
				else if( player4.isSelected()) {
					logger.error("4 Player game is the active radio button");
					numberOfPlayers = 4;
				}
				else {
					logger.fatal("User pressed start game, but no radio button was selected for number of players");
					throw new IllegalStateException("User pressed start game, but no radio button was selected for number of players");
				}
				
				//Get Game Mode
				//TODO: Implement game mode
				
				GameEnvironment.setupGame(numberOfPlayers, 0, baudRate.getText(), theCube.getSerialBaudrate() );
                                
                                
				
				//Set mode to unpaused
				GameEnvironment.startGame();
				
			}
		});
		

	}//end SnakeGui() Constructor


        /**
         * Sets the gui to visible/hidden depending on what variable is passed in. 
         * true - The gui is shown
         * false - The gui is hidden
         * 
         * Overrides setVisible in parent, JFrame
         * @param toShowGui 
         * 
         */
    @Override
        public void setVisible(boolean visible) {
            super.setVisible(visible);
        }

}//end SnakeGui Class
