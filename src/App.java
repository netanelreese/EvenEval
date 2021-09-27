import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ProcessBuilder.Redirect;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

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
	String reviewNum;
	String assnIDNum;
	String apiString;
	String urlString;
	String courseString;
	private static final long serialVersionUID = 1L;
	JButton createAssn;
	JLabel selectOption = new JLabel("Please select an option below:");
	JButton gradeAssn;
	JTextField assnID;
	JLabel title = new JLabel("EvenEval");
	JLabel company = new JLabel("/src/");
	Font labelFont = new Font("Comic Sans", Font.BOLD, 25);
	Color cream = new Color(255, 241, 208);	
	
	
	public void launch() throws FileNotFoundException {
		setTitle("EvenEval");

		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		
		JMenu n = new JMenu("Settings");
		bar.add(n);
		JMenuItem cSet = new JMenuItem("Canvas Settings");
		n.add(cSet);
		cSet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame settings = new JFrame("Settings");
				settings.setPreferredSize(new Dimension(400, 250));
				JLabel apiKey = new JLabel("Canvas API Key:");
				JLabel apiUrl = new JLabel("Canvas API URL:");
				JLabel courseID = new JLabel("Course ID:");
				JTextField keyField = new JTextField();
				JTextField urlField = new JTextField();
				JTextField courseField = new JTextField();
				JButton ok = new JButton("OK");
				
			    settings.setLayout(new GridBagLayout());
			    GridBagConstraints settingsPositionConst = new GridBagConstraints();
				
			    settingsPositionConst.insets = new Insets(5, 5, 5, 5);
			    settingsPositionConst.gridx = 0;
			    settingsPositionConst.gridy = 0;
			    settings.add(apiKey, settingsPositionConst);
			    
			    settingsPositionConst.insets = new Insets(5, 5, 5, 5);
			    settingsPositionConst.gridx = 1;
			    settingsPositionConst.gridy = 0;
			    keyField.setPreferredSize(new Dimension(200, 35));
			    settings.add(keyField, settingsPositionConst);
			    
			    settingsPositionConst.insets = new Insets(5, 5, 5, 5);
			    settingsPositionConst.gridx = 0;
			    settingsPositionConst.gridy = 1;
			    settings.add(apiUrl, settingsPositionConst);
			    
			    settingsPositionConst.insets = new Insets(5, 5, 5, 5);
			    settingsPositionConst.gridx = 1;
			    settingsPositionConst.gridy = 1;
			    urlField.setPreferredSize(new Dimension(200, 35));
			    settings.add(urlField, settingsPositionConst);
			    
			    settingsPositionConst.insets = new Insets(5, 5, 5, 5);
			    settingsPositionConst.gridx = 0;
			    settingsPositionConst.gridy = 2;
			    settings.add(courseID, settingsPositionConst);
			    
			    settingsPositionConst.insets = new Insets(5, 5, 5, 5);
			    settingsPositionConst.gridx = 1;
			    settingsPositionConst.gridy = 2;
			    courseField.setPreferredSize(new Dimension(200, 35));
			    settings.add(courseField, settingsPositionConst);
			    
			    settingsPositionConst.insets = new Insets(5, 5, 5, 5);
			    settingsPositionConst.gridx = 0;
			    settingsPositionConst.gridy = 3;
			    settings.add(ok, settingsPositionConst);
			    
			    settings.pack();
			    
			    keyField.addActionListener(new ActionListener() {
	    	    	  public void actionPerformed(ActionEvent event) {
	    	    		  apiString = keyField.getText();
	    	    	  }
	    	    	});
			    
			    urlField.addActionListener(new ActionListener() {
	    	    	  public void actionPerformed(ActionEvent event) {
	    	    		  urlString = urlField.getText();
	    	    	  }
	    	    	});
			    
			    courseField.addActionListener(new ActionListener() {
	    	    	  public void actionPerformed(ActionEvent event) {
	    	    		  courseString = courseField.getText();
	    	    	  }
	    	    	});
			    
			    settings.setVisible(true);
			    
			    ok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							BufferedWriter out = new BufferedWriter(new FileWriter("config.toml"));
							out.write(apiString);
							out.write("\n");
							out.write(urlString);
							out.write("\n");
							out.write(courseString);
							
							out.close();
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
			    	
			    });
			    
			}
		});
		
		createAssn = new JButton("Create an Assignment");
		gradeAssn = new JButton("Grade an Assignment");
		setPreferredSize(new Dimension(400, 400));
	    setLayout(new GridBagLayout());
	    GridBagConstraints positionConst = new GridBagConstraints();
		getContentPane().setBackground( new Color(132, 22, 23));
		
		title.setFont(labelFont);
		title.setForeground(cream);
		
		company.setFont(labelFont);
		company.setForeground(cream);
		
		selectOption.setForeground(cream);
		
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
	         String enterAssnID = "Enter Assignment ID";
	         
	         if( command.equals( "Grade an Assignment" ))  {
		        	String id = "";
		            JFrame popup = new JFrame("Enter Assignment ID");
		            
		            JLabel enterID = new JLabel(enterAssnID);
		            JButton ok = new JButton("OK");
		            JTextField assnID = new JTextField();
		            assnID.setEditable(true);
		            assnID.setPreferredSize(new Dimension(200, 35));
		            
		            
		            popup.setVisible(true);
		            popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		            
		    		popup.setPreferredSize(new Dimension(400, 400));
		    	    popup.setLayout(new GridBagLayout());
		    	    GridBagConstraints popupPositionConst = new GridBagConstraints();
		    		popup.getContentPane().setBackground( new Color(132, 22, 23));
		    		
		    		
		    		enterID.setForeground(cream);
		    		Font labelFont = new Font("Comic Sans", Font.BOLD, 14);
		    		enterID.setFont(labelFont);
		    		
		    		popupPositionConst.insets = new Insets(5, 5, 5, 5);
		    		popupPositionConst.gridx = 0;
		    	    popupPositionConst.gridy = 0;
		    	    popup.add(enterID, popupPositionConst);
		    	    
		    		popupPositionConst.insets = new Insets(5, 5, 5, 5);
		    		popupPositionConst.gridx = 0;
		    	    popupPositionConst.gridy = 1;
		    	    popup.add(assnID, popupPositionConst);
		    	    
		    	    popupPositionConst.insets = new Insets(5, 5, 5, 5);
		    		popupPositionConst.gridx = 0;
		    		popupPositionConst.gridy = 2;
		    	    popup.add(ok, popupPositionConst);
		    	    
		    	    assnID.addActionListener(new ActionListener() {
		    	    	  public void actionPerformed(ActionEvent event) {
		    	    		 assnIDNum = assnID.getText();
		    	    	  }
		    	    	});
		    	    
		    	    ok.setActionCommand("gr");
		    	    
		    	    assnIDNum = assnID.getText();
		    	    System.out.println(assnIDNum);
		    	    
		    	    ok.addActionListener(new ReviewClickListener());
		    	    
		    	    popup.pack();
	         } 
	         else if(command.contains( "Create" ) )  {
	        	 	
		            JFrame popup = new JFrame("Enter Assignment ID");
		            
		            JLabel peerReviewOps = new JLabel("Enter Peer Review Options");
		            JButton ok = new JButton("OK");
		            JLabel peerReview = new JLabel("Enter Peer Review Num");
		            JTextField peerReviewTitle = new JTextField();
		            peerReviewTitle.setEditable(true);
		            peerReviewTitle.setPreferredSize(new Dimension(200, 35));
		            
		            
		            popup.setVisible(true);
		            
		    		popup.setPreferredSize(new Dimension(600, 400));
		    	    popup.setLayout(new GridBagLayout());
		    	    GridBagConstraints popupPositionConst = new GridBagConstraints();
		    		popup.getContentPane().setBackground( new Color(132, 22, 23));
		    		
		    		
		    		peerReviewOps.setForeground(cream);
		    		Font labelFont = new Font("Comic Sans", Font.BOLD, 14);
		    		peerReviewOps.setFont(labelFont);
		    		
		    		peerReview.setForeground(cream);
		    		Font reviewFont = new Font("Comic Sans",Font.PLAIN, 12);
		    		peerReview.setFont(reviewFont);
		    		
		    		popupPositionConst.insets = new Insets(5, 5, 5, 5);
		    		popupPositionConst.gridx = 0;
		    	    popupPositionConst.gridy = 0;
		    	    popup.add(peerReviewOps, popupPositionConst);
		    	    
		    		popupPositionConst.insets = new Insets(5, 5, 5, 5);
		    		popupPositionConst.gridx = 0;
		    	    popupPositionConst.gridy = 1;
		    	    popup.add(peerReview, popupPositionConst);
		    	    
		    		popupPositionConst.insets = new Insets(5, 5, 5, 5);
		    		popupPositionConst.gridx = 1;
		    	    popupPositionConst.gridy = 1;
		    	    popup.add(peerReviewTitle, popupPositionConst);
		    	    
		    	    popupPositionConst.insets = new Insets(5, 5, 5, 5);
		    		popupPositionConst.gridx = 0;
		    		popupPositionConst.gridy = 2;
		    	    popup.add(ok, popupPositionConst);
		    	    
		    	    peerReviewTitle.addActionListener(new ActionListener() {
		    	    	  public void actionPerformed(ActionEvent event) {
		    	    		  reviewNum = peerReviewTitle.getText();
		    	    	  }
		    	    	});
		    	    
		    	    ok.setActionCommand("cr");
		    	    
		    	    ok.addActionListener(new ReviewClickListener());
		    	    reviewNum = peerReviewTitle.getText();
		    	    System.out.println(reviewNum);
		    	    popup.pack();
	         }
	      }		
	   }

	private class ReviewClickListener implements ActionListener{
	      public void actionPerformed(ActionEvent e) {
	    	String action = e.getActionCommand();
	    	
	    	try {
				BufferedWriter out = new BufferedWriter(new FileWriter("pyinp.txt"));
				
		    	if(action.equals("cr")) {
		    		out.write("A\n");
		    		out.write(reviewNum);
		    	}
		    	else if(action.equals("gr")) {
		    		out.write("B\n");
		    		out.write(assnIDNum);
		    	}
		    	out.close();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	    	

	  		ProcessBuilder processBuilder = new ProcessBuilder("python", "Driver.py");
	  		processBuilder.inheritIO();
	  		
	  		
	  		
			try {
				Process p = processBuilder.start();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
	    	 
	      }		
	   }
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
