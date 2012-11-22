package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

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
		aSerialJPanel 		= new JPanel( new BorderLayout() );
		
		
		
		
		
		
/* *******Player JPanel***************/		
		aPlayerJPanel 		= new JPanel( new BorderLayout() );

		
		
		
		
/* *******Main JFrame***************/
		
		
		//Set the JFrame title
		this.setTitle("Snake");
		//Set the JFrame Close button action
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		

		
		buildMenu();

		backgroundJPanel.add(aSerialJPanel);
		backgroundJPanel.add(aPlayerJPanel);
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
