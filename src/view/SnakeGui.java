package view;

import java.awt.BorderLayout;
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


	public SnakeGui() throws HeadlessException {


/* *******Background JPanel***************/
		backgroundJPanel 	= new JPanel( new GridLayout() );
		backgroundJPanel.setVisible(true);
		
		
/* *******Serial JPanel***************/		
		aSerialJPanel 		= new JPanel();
		aSerialJPanel.setLayout(new BoxLayout(aSerialJPanel,BoxLayout.Y_AXIS) );
		
		aSerialJPanel.setBackground(Color.blue);
		
		JComboBox cubeType = new JComboBox(controller.SnakeGame.aListOfCubeTypes.toArray() );
				  cubeType.setSelectedIndex(0);
				  
		aSerialJPanel.add(cubeType);
		
		JTextField xLedsPerCubeField = new JTextField();
				   xLedsPerCubeField.setText("42"); 
		JTextField yLedsPerCubeField = new JTextField();
		JTextField zLedsPerCubeField = new JTextField();
		
		aSerialJPanel.add(xLedsPerCubeField);
		aSerialJPanel.add(yLedsPerCubeField);
		aSerialJPanel.add(zLedsPerCubeField);
		
		
		
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
