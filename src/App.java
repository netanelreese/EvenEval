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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton createAssn;
	JLabel selectOption = new JLabel("Please select an option below:");
	JButton gradeAssn;
	JTextField assnID;
	JLabel title = new JLabel("EvenEval");
	JLabel company = new JLabel("/src/");
	
	
	public void launch() {
		setTitle("EvenEval");
		

		
		createAssn = new JButton("Create an Assignment");
		gradeAssn = new JButton("Grade an Assignment");
		setPreferredSize(new Dimension(400, 400));
	    setLayout(new GridBagLayout());
	    GridBagConstraints positionConst = new GridBagConstraints();
		getContentPane().setBackground( new Color(132, 22, 23));
		
		Font labelFont = new Font("Comic Sans", Font.BOLD, 25);
		
		title.setFont(labelFont);
		title.setForeground(Color.WHITE);
		
		company.setFont(labelFont);
		company.setForeground(Color.WHITE);
		
		selectOption.setForeground(Color.WHITE);
		
		positionConst.insets = new Insets(5, 5, 5, 5);
	    positionConst.gridx = 0;
	    positionConst.gridy = 0;
	    add(title, positionConst);
	    
		positionConst.insets = new Insets(5, 5, 5, 5);
	    positionConst.gridx = 1;
	    positionConst.gridy = 0;
	    add(company, positionConst);
	    
		positionConst.insets = new Insets(5, 5, 5, 5);
	    positionConst.gridx = 0;
	    positionConst.gridy = 2;
	    add(new JLabel(), positionConst);
	    
		positionConst.insets = new Insets(5, 5, 5, 5);
	    positionConst.gridx = 0;
	    positionConst.gridy = 1;
	    add(new JLabel(), positionConst);
	    
		positionConst.insets = new Insets(5, 5, 5, 5);
	    positionConst.gridx = 0;
	    positionConst.gridy = 3;
	    add(selectOption, positionConst);
	    
		positionConst.insets = new Insets(5, 5, 5, 5);
	    positionConst.gridx = 0;
	    positionConst.gridy = 4;
	    add(createAssn, positionConst);
	    
		positionConst.insets = new Insets(5, 5, 5, 5);
	    positionConst.gridx = 1;
	    positionConst.gridy = 4;
	    add(gradeAssn, positionConst);
	    
	    gradeAssn.setActionCommand("Grade an Assignment");
	    createAssn.setActionCommand("Create an Assignment");
	    
	    gradeAssn.addActionListener(new ButtonClickListener());
	    createAssn.addActionListener(new ButtonClickListener());
	    
		pack();
	}
	
	private class ButtonClickListener implements ActionListener{
	      public void actionPerformed(ActionEvent e) {
	         String command = e.getActionCommand();  
	         
	         if( command.equals( "Grade an Assignment" ))  {
	        	 System.out.println("Grade");
	         } 
	         else if( command.contains( "Create" ) )  {
	            System.out.println("Create");
	         }
	      }		
	   }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
