package view;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Write a description of class SnakeGui here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
@SuppressWarnings("serial")
public class SnakeGui extends JFrame {
	
	JPanel backgroundJPanel;
	JPanel aSerialJPanel;
	JPanel aPlayerJPanel;

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
		
		aSerialJPanel.setBackground(Color.blue);
		
		JComboBox cubeType 	= new JComboBox(controller.SnakeGame.aListOfCubeTypes.toArray() );
				  cubeType.setSelectedIndex(0);
		aSerialJPanel.add(cubeType);
		
		JTextField xLedsPerCubeField = new JTextField();
				   xLedsPerCubeField.setText("42"); 
				   xLedsPerCubeField.setEditable(false);
		JTextField yLedsPerCubeField = new JTextField();
				   yLedsPerCubeField.setEditable(false);
		JTextField zLedsPerCubeField = new JTextField();
				   zLedsPerCubeField.setEditable(false);
		
		aSerialJPanel.add(xLedsPerCubeField);
		aSerialJPanel.add(yLedsPerCubeField);
		aSerialJPanel.add(zLedsPerCubeField);
		
		JComboBox serialPort 	= new JComboBox(model.SerialPort.getaListOfSerialPorts() );
		serialPort.setSelectedIndex(0);
		aSerialJPanel.add(serialPort);
		
		JTextField baudRate = new JTextField();
				   
		aSerialJPanel.add(baudRate);
		
		
		
/* *******Player JPanel***************/		
		aPlayerJPanel 		= new JPanel();
		aPlayerJPanel.setLayout(new BoxLayout(aPlayerJPanel,BoxLayout.Y_AXIS )) ;

		
		
		
		
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

	}

	public void buildMenu() {
		menuBar.add(file);
		menuBar.add(crawl);
		menuBar.add(help);

		// Turn on the menuBar
		this.setJMenuBar(menuBar);
	}

}
