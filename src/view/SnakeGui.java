package view;



import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * Write a description of class SnakeGui here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
@SuppressWarnings("serial")
public class SnakeGui extends JFrame 
{

		public static final int MAIN_HEIGHT = 515;
	    public static final int MAIN_WIDTH = 800;
		
	    private JMenuBar menuBar = new JMenuBar();
	    private JMenu file = new JMenu("File");
	    private JMenu crawl = new JMenu("Crawl");
	    private JMenu help = new JMenu("Help");
	    
	    //Not sure what this code does, but skyler has it in his project
	    public static SnakeGui GUI;
	    private SnakeGui self;
	    
		public SnakeGui() throws HeadlessException 
		{
			//Not sure what this code does, but skyler has it in his project
			self = this;
			SnakeGui.GUI = this;
	    	
			this.setTitle("Snake");
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        
	        buildMenu();
	        
	        this.setLocationRelativeTo(null);
	        this.setVisible(true);
			
			
		}
		
		public void buildMenu()
		{
			menuBar.add(file);
	    	menuBar.add(crawl);
	    	menuBar.add(help);
	    	
	    	  //Turn on the menuBar
	          this.setJMenuBar(menuBar);
		}
	    
	    
		

}
