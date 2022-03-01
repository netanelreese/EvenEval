import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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
	private String reviewNum;
	private String assnIDNum;
	private String apiString;
	private String urlString;
	private String courseString;
	private String groupCat;
	private ArrayList<String> groupCategoryName = new ArrayList<String>();
	private ArrayList<String> groupCategoryID = new ArrayList<String>();
	private static final long serialVersionUID = 1L;
	private JButton createAssn;
	private JLabel selectOption = new JLabel("Please select an option below:");
	private JButton gradeAssn;
	private JTextField assnID;
	private JLabel title = new JLabel("EvenEval");
	private JLabel company = new JLabel("/src/");
    JTextField peerReviewTitle = new JTextField();
	private Font labelFont = new Font("Sans Serif", Font.BOLD, 25);
	JTextField keyField = new JTextField();
	JTextField urlField = new JTextField();
	JTextField courseField = new JTextField();
	private Color cream = new Color(255, 241, 208);	
	private Color crimson = new Color(132, 22, 23);
	JComboBox<Object> dropDown;
	
	
	public void runGroupGetter() {
  		ProcessBuilder processBuilder = new ProcessBuilder("python", "GroupGetter.py");
  		processBuilder.inheritIO();
  		Process p = null;
		try {
			p = processBuilder.start(); //starting the instance
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
        }
		while(p.isAlive()) {}
		int success = p.exitValue();
		if (success == 0) {
			ggSuccess();
		}
		else if(success != 0) {
			ggFail();
		}
	}
	
	public void launch() throws FileNotFoundException {
		setTitle("EvenEval");

		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		
		/**
		 * Getter for the group categories and place into drop down box
		 
		runGroupGetter(); 
		getSettings();
		dropDown = new JComboBox<Object>(groupCategoryName.toArray());
		dropDown.setBackground(cream);
		*/
		JMenu n = new JMenu("Settings");
		bar.add(n);
		JMenuItem cSet = new JMenuItem("Canvas Settings");
		n.add(cSet);
		cSet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { //creating frame for settings menu
				// TODO Auto-generated method stub
				JFrame settings = new JFrame("Settings");
				settings.setPreferredSize(new Dimension(700, 250));
				JLabel apiKey = new JLabel("Canvas API Key:");
				JLabel apiUrl = new JLabel("Canvas API URL:");
				JLabel courseID = new JLabel("Course ID:");
				JButton ok = new JButton("OK");
				
				try {
					getSettings();
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			    settings.setLayout(new GridBagLayout());
			    GridBagConstraints settingsPositionConst = new GridBagConstraints();
				
			    keyField.setText(apiString);
			    urlField.setText(urlString);
			    courseField.setText(courseString);
			    
			    settingsPositionConst.insets = new Insets(5, 5, 5, 5);
			    settingsPositionConst.gridx = 0;
			    settingsPositionConst.gridy = 0;
			    settings.add(apiKey, settingsPositionConst);
			    
			    settingsPositionConst.insets = new Insets(5, 5, 5, 5);
			    settingsPositionConst.gridx = 1;
			    settingsPositionConst.gridy = 0;
			    keyField.setPreferredSize(new Dimension(490, 35));
			    settings.add(keyField, settingsPositionConst);
			    
			    settingsPositionConst.insets = new Insets(5, 5, 5, 5);
			    settingsPositionConst.gridx = 0;
			    settingsPositionConst.gridy = 1;
			    settings.add(apiUrl, settingsPositionConst);
			    
			    settingsPositionConst.insets = new Insets(5, 5, 5, 5);
			    settingsPositionConst.gridx = 1;
			    settingsPositionConst.gridy = 1;
			    urlField.setPreferredSize(new Dimension(300, 35));
			    settings.add(urlField, settingsPositionConst);
			    
			    settingsPositionConst.insets = new Insets(5, 5, 5, 5);
			    settingsPositionConst.gridx = 0;
			    settingsPositionConst.gridy = 2;
			    settings.add(courseID, settingsPositionConst);
			    
			    settingsPositionConst.insets = new Insets(5, 5, 5, 5);
			    settingsPositionConst.gridx = 1;
			    settingsPositionConst.gridy = 2;
			    courseField.setPreferredSize(new Dimension(300, 35));
			    settings.add(courseField, settingsPositionConst);
			    
			    settingsPositionConst.insets = new Insets(5, 5, 5, 5);
			    settingsPositionConst.gridx = 0;
			    settingsPositionConst.gridy = 3;
			    settings.add(ok, settingsPositionConst);
			    
			    
			    settings.pack();
			    
	    	    keyField.getDocument().addDocumentListener(new DocumentListener() {
	    	        @Override
	    	        public void insertUpdate(DocumentEvent documentEvent) {
	    	            setKey();
	    	        }

	    	        @Override
	    	        public void removeUpdate(DocumentEvent documentEvent) {
	    	            setKey();
	    	        }

	    	        @Override
	    	        public void changedUpdate(DocumentEvent documentEvent) {
	    	        }
	    	    });
	    	    
	    	    keyField.addActionListener(
	    	            new ActionListener() {
	    	                public void actionPerformed(ActionEvent e) {
	    	                    setKey();
	    	                }
	    	            }
	    	    );
			    
	    	    urlField.getDocument().addDocumentListener(new DocumentListener() {
	    	        @Override
	    	        public void insertUpdate(DocumentEvent documentEvent) {
	    	            setURL();

	    	        }

	    	        @Override
	    	        public void removeUpdate(DocumentEvent documentEvent) {
	    	            setURL();

	    	        }

	    	        @Override
	    	        public void changedUpdate(DocumentEvent documentEvent) {
	    	        }
	    	    });
	    	    
	    	    urlField.addActionListener(
	    	            new ActionListener() {
	    	                public void actionPerformed(ActionEvent e) {
	    	                    setURL();
	    	                }
	    	            }
	    	    );
			    
	    	    courseField.getDocument().addDocumentListener(new DocumentListener() {
	    	        @Override
	    	        public void insertUpdate(DocumentEvent documentEvent) {
	    	            setCourseField();
	    	        }

	    	        @Override
	    	        public void removeUpdate(DocumentEvent documentEvent) {
	    	            setCourseField();
	    	        }

	    	        @Override
	    	        public void changedUpdate(DocumentEvent documentEvent) {
	    	        }
	    	    });
	    	    
	    	    courseField.addActionListener(
	    	            new ActionListener() {
	    	                public void actionPerformed(ActionEvent e) {
	    	                    setCourseField();
	    	                }
	    	            }
	    	    );
			    
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
							out.write("\n");
							
							out.close();
							settings.dispose();
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
			    	
			    });
			    
			}
		});
		/**
		 * Creating JFrame for base applet
		 */
		createAssn = new JButton("Create an Assignment"); 
		gradeAssn = new JButton("Grade an Assignment");
		createAssn.setBackground(cream);
		gradeAssn.setBackground(cream);
		
		setPreferredSize(new Dimension(400, 400));
	    setLayout(new GridBagLayout());
	    GridBagConstraints positionConst = new GridBagConstraints();
		getContentPane().setBackground(crimson);
		
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
	    /*
	    positionConst.gridx = 0;
	    positionConst.gridy = 6;
	    add(dropDown, positionConst);
	    */
	    gradeAssn.setActionCommand("Grade an Assignment");
	    createAssn.setActionCommand("Create an Assignment");
	    
	    gradeAssn.addActionListener(new ButtonClickListener());
	    createAssn.addActionListener(new ButtonClickListener());
	    
		pack();
	}
	
	private class ButtonClickListener implements ActionListener{ //creating the popups that take input and write to pyinp.txt
	      public void actionPerformed(ActionEvent e) {
	    	 //groupCat = groupCategoryID.get(groupCategoryName.indexOf(dropDown.getSelectedItem()));
	    	 
	         String command = e.getActionCommand();
	         String enterAssnID = "Enter Assignment ID";
	         
	         if( command.equals( "Grade an Assignment" ))  {
		            JFrame popup = new JFrame("Enter Assignment ID");
		            
		            JLabel enterID = new JLabel(enterAssnID);
		            JButton ok = new JButton("OK");
		            ok.setBackground(cream);
		            assnID = new JTextField();
		            assnID.setEditable(true);
		            assnID.setPreferredSize(new Dimension(200, 35));
		            
		            
		            popup.setVisible(true);
		            popup.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		            
		    		popup.setPreferredSize(new Dimension(400, 400));
		    	    popup.setLayout(new GridBagLayout());
		    	    GridBagConstraints popupPositionConst = new GridBagConstraints();
		    		popup.getContentPane().setBackground(crimson);
		    		
		    		
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
		    	    
		    	    assnID.getDocument().addDocumentListener(new DocumentListener() {
		    	        @Override
		    	        public void insertUpdate(DocumentEvent documentEvent) {
		    	            setAssnID();
		    	        }

		    	        @Override
		    	        public void removeUpdate(DocumentEvent documentEvent) {
		    	            setAssnID();
		    	        }

		    	        @Override
		    	        public void changedUpdate(DocumentEvent documentEvent) {
		    	        }
		    	    });
		    	    
		    	    assnID.addActionListener(
		    	            new ActionListener() {
		    	                public void actionPerformed(ActionEvent e) {
		    	                    setAssnID();
		    	                }
		    	            }
		    	    );
		    	    
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
		            ok.setBackground(cream);
		            JLabel peerReview = new JLabel("Enter Peer Review Num");
		            JLabel groups = new JLabel("Select group category");
		            
		            peerReviewTitle.setEditable(true);
		            peerReviewTitle.setPreferredSize(new Dimension(200, 35));
		            
		            runGroupGetter(); 
		    		try {
						getSettings();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		dropDown = new JComboBox<Object>(groupCategoryName.toArray());
		    		dropDown.setBackground(cream);
		    		
		    	    
		            popup.setVisible(true);
		            
		    		popup.setPreferredSize(new Dimension(600, 400));
		    	    popup.setLayout(new GridBagLayout());
		    	    GridBagConstraints popupPositionConst = new GridBagConstraints();
		    		popup.getContentPane().setBackground(crimson);
		    		
		    		
		    		peerReviewOps.setForeground(cream);
		    		Font labelFont = new Font("Comic Sans", Font.BOLD, 14);
		    		peerReviewOps.setFont(labelFont);
		    		
		    		peerReview.setForeground(cream);
		    		Font reviewFont = new Font("Comic Sans",Font.PLAIN, 12);
		    		peerReview.setFont(reviewFont);
		    		
		    		groups.setForeground(cream);
		    		groups.setFont(reviewFont);
		    		
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
		    	    popup.add(groups, popupPositionConst);
		    	    
		    	    popupPositionConst.insets = new Insets(5, 5, 5, 5);
		    	    popupPositionConst.gridx = 1;
		    	    popupPositionConst.gridy = 2;
		    	    popup.add(dropDown, popupPositionConst);
		    	    
		    	    popupPositionConst.insets = new Insets(5, 5, 5, 5);
		    		popupPositionConst.gridx = 1;
		    		popupPositionConst.gridy = 3;
		    	    popup.add(ok, popupPositionConst);
		    	       	    
		    	    
		    	    
		    	    peerReviewTitle.getDocument().addDocumentListener(new DocumentListener() {
		    	        @Override
		    	        public void insertUpdate(DocumentEvent documentEvent) {
		    	            setReviewNum();
		    	        }

		    	        @Override
		    	        public void removeUpdate(DocumentEvent documentEvent) {
		    	            setReviewNum();
		    	        }

		    	        @Override
		    	        public void changedUpdate(DocumentEvent documentEvent) {
		    	        }
		    	    });
		    	    
		    	    peerReviewTitle.addActionListener(
		    	            new ActionListener() {
		    	                public void actionPerformed(ActionEvent e) {
		    	                    setReviewNum();
		    	                }
		    	            }
		    	    );
		    	    

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
				BufferedWriter out = new BufferedWriter(new FileWriter("pyinp.toml"));
				
		    	if(action.equals("cr")) {
		    		groupCat = groupCategoryID.get(groupCategoryName.indexOf(dropDown.getSelectedItem()));
		    		out.write("A\n"); //writing that we wanna create the assignment with the number inputted
		    		out.write(reviewNum + "\n");
		    		out.write(groupCat);
		    	}
		    	else if(action.equals("gr")) {
		    		out.write("B\n"); //writing to pyinp that we wanna grade assignment with input assingment id
		    		out.write(assnIDNum + "\n");
		    		//out.write(groupCat);
		    	}
		    	out.close();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	    	
	    	//start new shell instance running python with Driver as the arg
	  		ProcessBuilder processBuilder = new ProcessBuilder("python", "Driver.py");
	  		processBuilder.inheritIO();
	  		Process p = null;
			try {
				p = processBuilder.start(); //starting the instance
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
	        } 
			while(p.isAlive()) {}
			int success = p.exitValue();
			if (success == 0) {
				aSuccess(action);
				bSuccess(action);
			}
			else if(success != 0) {
				aFail(action);
				bFail(action);
			}

	   }
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void aSuccess(String action) {
		if (action == "cr") {JOptionPane.showMessageDialog(this, "Assignment Created Successfully!");}
		
		
	}
	private void bSuccess(String action) {
		if (action == "gr") {JOptionPane.showMessageDialog(this, "Assignment Graded Successfully!");}

	}
	private void aFail(String action) {
		if (action == "cr") {JOptionPane.showMessageDialog(this, "Assignment Creation Fail.", "ERROR", JOptionPane.ERROR_MESSAGE);}
		
		
	}
	private void bFail(String action) {
		if (action == "gr") {JOptionPane.showMessageDialog(this, "Assignment Grading Fail.", "ERROR", JOptionPane.ERROR_MESSAGE);}

	}
	private void ggSuccess() {
		JOptionPane.showMessageDialog(this, "Successfully Fetched Group Categories");

	}
	private void ggFail() {
		JOptionPane.showMessageDialog(this, "Failure With GroupGetter.py", "ERROR", JOptionPane.ERROR_MESSAGE);
		
		
	}
	private void setReviewNum() {
	    reviewNum = peerReviewTitle.getText();
	}
	private void setAssnID() {
	    assnIDNum = assnID.getText();
	}
	private void setKey() {
	    apiString = keyField.getText();
	}
	private void setCourseField() {
	    courseString = courseField.getText();
	}
	private void setURL() {
	    urlString = urlField.getText();
	}
	private void getSettings() throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("config.toml"));
		apiString = scanner.nextLine();
		urlString = scanner.nextLine();
		courseString = scanner.nextLine();
		String[] temp = new String[2];
		
		while(scanner.hasNext()) {
			temp = (scanner.nextLine()).split(",");
			groupCategoryName.add(temp[0]);
			groupCategoryID.add(temp[1]);
		}
		
		scanner.close();
	}

}
