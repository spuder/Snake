package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayerJPanel extends JPanel{
	private JTextField numberOfPlayers;
	
	PlayerJPanel()
	{
		new GridBagLayout();
		GridBagConstraints gbConstraints = new GridBagConstraints();
		numberOfPlayers = new JTextField();
		numberOfPlayers.setText("4");
		this.add(numberOfPlayers, gbConstraints);
	}

	
}
