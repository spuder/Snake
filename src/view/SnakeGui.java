package view;


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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.apache.log4j.Logger;

import controller.SerialInterface;
import controller.SnakeGame;

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
	SerialInterface theCube;
	
	JPanel backgroundJPanel;
	JPanel aSerialJPanel;
	JPanel aPlayerJPanel;
	
	//A title object that we reuse to make pretty black borders around panels
	TitledBorder title;
	
	//Combo Boxto choose the cube type
	final JComboBox cubeTypeComboBox;
	
	final JTextField xLedsPerCubeField;
	final JTextField yLedsPerCubeField;
	final JTextField zLedsPerCubeField;
	
	//Radio Buttons to select the number of players
	final JRadioButton player1;
	final JRadioButton player2;
	final JRadioButton player3;
	final JRadioButton player4;
	final ButtonGroup playerButtonGroup;
	
	final JComboBox serialPortComboBox;
	final JTextField baudRate;


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
		controller.SnakeGame.activeCubeType = "Adaptive Cube"; //TODO: There must be a better way to do this with .toString. See line 20 lower
		
		//Create an Object of any type
		theCube =  (SerialInterface) controller.SnakeGame.aListOfCubeTypes.get( controller.SnakeGame.activeCubeType );
		
		
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
		aSerialJPanel.setBackground(Color.blue);
		
		//Look up every type of cube we have in the hashmap and add each to the combo box
		cubeTypeComboBox 	= new JComboBox(controller.SnakeGame.aListOfCubeTypes.keySet().toArray() );
		
		//Set the default to always be the Adaptive Cube		  
//		cubeTypeComboBox.setSelectedItem("Adaptive"); //TODO: There must be a better way with .toString. See line 20 up
		cubeTypeComboBox.setSelectedItem(theCube.toString() );
		System.out.println(theCube.toString() );
		
		//Add the combo box to the serial JPanel
		aSerialJPanel.add(cubeTypeComboBox);
		

		xLedsPerCubeField = new JTextField();
		xLedsPerCubeField.setText(theCube.getxNumberOfLeds() +""); 
		xLedsPerCubeField.setEditable(false);
		
		yLedsPerCubeField = new JTextField();
		yLedsPerCubeField.setText(theCube.getyNumberOfLeds() +"");
		yLedsPerCubeField.setEditable(false);
		
		zLedsPerCubeField = new JTextField();
		zLedsPerCubeField.setText(theCube.getzNumberOfLeds() +"");
		zLedsPerCubeField.setEditable(false);
				   

		//Create the Serial Port ComboBox
		serialPortComboBox = new JComboBox( model.SerialPort.getaListOfSerialPorts() );
		
		//Set the serial port to default, 
		serialPortComboBox.setSelectedIndex(0);

		baudRate = new JTextField();
		baudRate.setText( theCube.getSerialBaudrate() +"");
		baudRate.setEditable(false);
			
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
		
		aPlayerJPanel.add(player1);
		aPlayerJPanel.add(player2);
		aPlayerJPanel.add(player3);
		aPlayerJPanel.add(player4);
		
		
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
					controller.SnakeGame.activeCubeType = (String) cubeTypeComboBox.getSelectedItem();
					
					//Get the x y and z for the new cube type
					theCube =  (SerialInterface) controller.SnakeGame.aListOfCubeTypes.get(controller.SnakeGame.activeCubeType);
					
					xLedsPerCubeField.setText(theCube.getxNumberOfLeds() +""); 
					yLedsPerCubeField.setText(theCube.getyNumberOfLeds() +"");
					zLedsPerCubeField.setText(theCube.getzNumberOfLeds() +"");
					
					baudRate.setText( theCube.getSerialBaudrate() +"");
					logger.debug("The system recognizes *"+ controller.SnakeGame.activeCubeType + "* as the current cube type");
					
				}});

	}



}
