import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;

/**
 * Runs the python code through a GUI.
 * 
 * @author Nathanael Reese
 * @version 0.5
 *
 */
public class App extends JFrame implements ActionListener {

	private Color crimson = new Color(132, 22, 23, 1);
	JButton createAssn;
	JButton gradeAssn;
	JTextField assnID;
	
	public void launch() {
		setTitle("EvenEval");
		createAssn = new JButton("Create an Assignment");
		gradeAssn = new JButton("Grade an Assignment");
		setPreferredSize(new Dimension(400, 400));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
