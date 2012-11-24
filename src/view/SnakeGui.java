package view;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.apache.log4j.Logger;

import controller.SerialInterface;
import controller.SnakeGame;

/**
 * Write a description of class SnakeGui here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
@SuppressWarnings("serial")
public class SnakeGui extends JFrame {
	public Logger logger = Logger.getLogger(this.getClass() );
	
	JPanel backgroundJPanel;
	JPanel aSerialJPanel;
	JPanel aPlayerJPanel;
	
	//A title object that we reuse to make pretty black borders around panels
	TitledBorder title;

	private JMenuBar menuBar = new JMenuBar();
	private JMenu file = new JMenu("File");
	private JMenu crawl = new JMenu("Crawl");
	private JMenu help = new JMenu("Help");


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
		
		aSerialJPanel.setBackground(Color.blue);
		
//		//Look up every type of cube we have in the hashmap and add each to the combo box
		final JComboBox cubeType 	= new JComboBox(controller.SnakeGame.aListOfCubeTypes.keySet().toArray() );
		//Set the default to always be the Adaptive Cube		  
			cubeType.setSelectedItem("Adaptive");
			
			
		aSerialJPanel.add(cubeType);
		
		
		
		final JTextField xLedsPerCubeField = new JTextField();
				   xLedsPerCubeField.setText("42"); 
				   xLedsPerCubeField.setEditable(false);
		final JTextField yLedsPerCubeField = new JTextField();
				   yLedsPerCubeField.setEditable(false);
		final JTextField zLedsPerCubeField = new JTextField();
				   zLedsPerCubeField.setEditable(false);
		
		aSerialJPanel.add(xLedsPerCubeField);
		aSerialJPanel.add(yLedsPerCubeField);
		aSerialJPanel.add(zLedsPerCubeField);
		
		JComboBox serialPort 	= new JComboBox(model.SerialPort.getaListOfSerialPorts() );
		serialPort.setSelectedIndex(0);

		aSerialJPanel.add(serialPort);
		
		final JTextField baudRate = new JTextField();
				   
		aSerialJPanel.add(baudRate);
		
		
		
/* *******Player JPanel***************/		
		aPlayerJPanel 		= new JPanel();
		aPlayerJPanel.setLayout(new BoxLayout(aPlayerJPanel,BoxLayout.Y_AXIS )) ;
			title  = BorderFactory.createTitledBorder( BorderFactory.createLineBorder(Color.black), "Players" );
			title.setTitleJustification(TitledBorder.CENTER);
		aPlayerJPanel.setBorder(title );
		
		
		
		
/* *******Main JFrame***************/
		
		
		//Set the JFrame title
		this.setTitle("Snake");
		//Set the JFrame Close button action
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		

		
		buildMenu();
		backgroundJPanel.add(aPlayerJPanel);
		backgroundJPanel.add(aSerialJPanel);

		this.add(backgroundJPanel);
		
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		

		this.setVisible(true);
		
		
		
		
		/* **********Action Listeners ****************/
		//Action Listener for the CubeType comboBox 
		cubeType.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					logger.error("The user clicked to change the cube type to "+ (String) cubeType.getSelectedItem() );
					
					//Set the new cube type based on what the user selected
					controller.SnakeGame.activeCubeType = (String) cubeType.getSelectedItem();
					
					//Get the x y and z for the new cube type
					SerialInterface theCube =  (SerialInterface) controller.SnakeGame.aListOfCubeTypes.get(controller.SnakeGame.activeCubeType);
					xLedsPerCubeField.setText(theCube.getxNumberOfLeds() +""); 
					yLedsPerCubeField.setText(theCube.getyNumberOfLeds() +"");
					zLedsPerCubeField.setText(theCube.getzNumberOfLeds() +"");
					baudRate.setText( theCube.getSerialBaudrate() +"");
					logger.debug("The system recognizes *"+ controller.SnakeGame.activeCubeType + "* as the current cube type");
					
				}});

	}

	public void buildMenu() {
		menuBar.add(file);
		menuBar.add(crawl);
		menuBar.add(help);

		// Turn on the menuBar
		this.setJMenuBar(menuBar);
	}

}
