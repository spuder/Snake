package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class SerialJPanel extends JPanel{
	
	private JTextField serialPortNumber;
	
	SerialJPanel()
	{
		new GridBagLayout();
		GridBagConstraints gbConstraints = new GridBagConstraints();
		serialPortNumber = new JTextField();
		serialPortNumber.setText("Com3");
		this.add(serialPortNumber, gbConstraints);
	}

	
	
	
	
}
