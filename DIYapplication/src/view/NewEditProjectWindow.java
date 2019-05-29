/*
 * TCSS 360 - Spring 2019
 */

package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Energy;
import model.Project;

/**
 * The new and edit project window for DIYProjectPlanner application.
 * 
 * @author Gordon McCreary
 * @version May 28, 2019
 */
public class NewEditProjectWindow {
	
	/* The text field for project name. */
	private JTextField myNameField;
	
	/* The text field for project cost. */
	private JTextField myCostField;
	
	/* The text field for project duration days. */
	private JTextField myDaysField;
	
	/* The text field for project duration weeks. */
	private JTextField myWeeksField;
	
	/* The combo box for project energy efficiency. */
	private JComboBox<String> myEnergyField;
	
	/* The text area for project notes. */
	private JTextArea myNotesField;
	
	/* The JButton to submit the project information. */
	private JButton mySubmitButton;
	
	/* Property change listener for project fields. */
	private ProjectListener myListener;
	
	/* The frame that is this window. */
	private JFrame myFrame;
	
	/* The project being edited. */
	private Project myProject;
	
	/* The frame that is the main application. */
	private DIYProjectPlanner myApp;
	
	/**
	 * Constructor for the NewEditProjectWindow.
	 * 
	 * @param theProject The project being edited.
	 * @param theApp The main application that this window was called from.
	 */
	public NewEditProjectWindow(final Project theProject,
											   final DIYProjectPlanner theApp) {
		theApp.setEnabled(false);
		myApp = theApp;
		myProject = theProject;
		myListener = new ProjectListener();
		JPanel panel = new JPanel();
		buildPanel(panel);
		
		// Sets JFrame title and JButton text based on whether new or editing.
		if ("".equals(theProject.getMyName())) {
			myFrame = new JFrame("Create New Project");
		} else {
			myFrame = new JFrame("Edit Project");
			mySubmitButton.setText("Update");
		}
		
		// Fill out fields based on project info.
		myNameField.setText(theProject.getMyName());
		myListener.propertyChange(new PropertyChangeEvent(myCostField,
							 "FormatCost", "" + theProject.getMyCost(), "" + 
												   theProject.getMyCost()));
		myDaysField.setText("" + (theProject.getMyDays() % 7));
		myWeeksField.setText("" + (theProject.getMyDays() / 7));
		myEnergyField.setSelectedIndex(theProject.getMyEnergy().getValue());
		myNotesField.setText(theProject.getMyNotes());
		
		// Finish up and show frame.
		myFrame.add(panel);
		myFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent theEvent) {
				myApp.setEnabled(true);
			}
		});
		showFrame(myFrame);
	}
	
	/**
	 * Builds the panel by adding all the labels, fields, buttons, etc.
	 * 
	 * @param thePanel The panel to add the components to.
	 */
	private void buildPanel(final JPanel thePanel) {
		thePanel.setLayout(new BoxLayout(thePanel, BoxLayout.Y_AXIS));
		addName(thePanel);
		addCost(thePanel);
		addDuration(thePanel);
		addEnergyEfficiency(thePanel);
		addNotes(thePanel);
		addSubmit(thePanel);
		thePanel.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 25));
	}
	
	/**
	 * Adds the name JLabel and JTextField to the main JPanel.
	 * 
	 * @param thePanel The main JPanel.
	 */
	private void addName(final JPanel thePanel) {
		myNameField = new JTextField(15);
		JPanel Name = new JPanel(new BorderLayout());
		
		//Panel layout.
		Name.add(new JLabel("Name:"), BorderLayout.WEST);
		Name.add(myNameField, BorderLayout.EAST);
		Name.setBorder(BorderFactory.createEmptyBorder(25, 0, 5, 0));
		Name.setPreferredSize(new Dimension(200, 50));
		thePanel.add(Name);
	}
	
	/**
	 * Adds the cost JLabel and JTextField to the main JPanel.
	 * 
	 * @param thePanel The main JPanel.
	 */
	private void addCost(final JPanel thePanel) {
		myCostField = new JTextField(10);
		JPanel Cost = new JPanel(new BorderLayout());
		
		// Formats cost field once focus is lost.
		myCostField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent theEvent) {
				myListener.propertyChange(new PropertyChangeEvent(myCostField,
				   "FormatCost", myCostField.getText(), myCostField.getText()));
			}
			@Override
			public void focusGained(FocusEvent e) {}
		});
		
		// Panel layout.
		myCostField.setPreferredSize(new Dimension(100, 20));
		Cost.add(new JLabel("Cost:"), BorderLayout.WEST);
		Cost.add(myCostField, BorderLayout.EAST);
		Cost.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 50));
		Cost.setPreferredSize(new Dimension(200, 30));
		thePanel.add(Cost);
	}
	
	/**
	 * Adds the duration JLabel and JTextFields to the main JPanel, both for
	 * Days and Weeks.
	 * 
	 * @param thePanel The main JPanel.
	 */
	private void addDuration(final JPanel thePanel) {
		myDaysField = new JTextField(5);
		myDaysField.setHorizontalAlignment(JTextField.CENTER);
		myWeeksField = new JTextField(5);
		myWeeksField.setHorizontalAlignment(JTextField.CENTER);
		
		// Formats days and weeks fields when focus is lost.
		myWeeksField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent theEvent) {
				myListener.propertyChange(new PropertyChangeEvent(myWeeksField,
				"FormatWeeks", myWeeksField.getText(), myWeeksField.getText()));
			}
			@Override
			public void focusGained(FocusEvent e) {}
		});
		myDaysField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent theEvent) {
				myListener.propertyChange(new PropertyChangeEvent(myDaysField,
				   "FormatDays", myDaysField.getText(), myDaysField.getText()));
			}
			@Override
			public void focusGained(FocusEvent e) {}
		});
		
		// Panel layout.
		JPanel Duration = new JPanel(new BorderLayout());
		Duration.add(new JLabel("Duration:"), BorderLayout.WEST);
		JPanel DurEntries = new JPanel();
		DurEntries.setLayout(new BoxLayout(DurEntries, BoxLayout.Y_AXIS));
		JPanel Days = new JPanel(new BorderLayout());
		Days.add(new JLabel("     Days"), BorderLayout.EAST);
		Days.add(myDaysField, BorderLayout.WEST);
		JPanel Weeks = new JPanel(new BorderLayout());
		Weeks.add(new JLabel("     Weeks"), BorderLayout.EAST);
		Weeks.add(myWeeksField, BorderLayout.WEST);
		DurEntries.add(Days);
		DurEntries.add(Weeks);
		Duration.add(DurEntries, BorderLayout.EAST);
		Duration.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 25));
		Duration.setPreferredSize(new Dimension(200, 60));
		thePanel.add(Duration);
	}
	
	/**
	 * Adds the energy JLabel and JComboBox to the main JPanel.
	 * 
	 * @param thePanel The main JPanel.
	 */
	private void addEnergyEfficiency(final JPanel thePanel) {
		myEnergyField = new JComboBox<String>(
										new String[] {"Low", "Medium", "High"});
		
		// Panel layout.
		JPanel EnergyEfficiency = new JPanel(new BorderLayout());
		EnergyEfficiency.add(new JLabel("Energy Efficiency:"),
															 BorderLayout.WEST);
		EnergyEfficiency.add(myEnergyField, BorderLayout.EAST);
		EnergyEfficiency.setBorder(
								BorderFactory.createEmptyBorder(12, 0, 12, 15));
		EnergyEfficiency.setPreferredSize(new Dimension(200, 50));
		thePanel.add(EnergyEfficiency);
	}
	
	/**
	 * Adds the notes JLabel and JTextArea to the main JPanel.
	 * 
	 * @param thePanel The main JPanel.
	 */
	private void addNotes(final JPanel thePanel) {
		myNotesField = new JTextArea(4, 15);
		myNotesField.setLineWrap(true);
		
		// Panel layout.
		JPanel Notes = new JPanel(new BorderLayout());
		Notes.add(new JLabel("Notes:"), BorderLayout.WEST);
		JScrollPane scrollNotes = new JScrollPane(myNotesField);
		Notes.add(scrollNotes, BorderLayout.EAST);
		Notes.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		Notes.setPreferredSize(new Dimension(200, 80));
		thePanel.add(Notes);
	}
	
	/**
	 * Adds the submit JButton to the main JPanel.
	 * 
	 * @param thePanel The main JPanel.
	 */
	public void addSubmit(final JPanel thePanel) {
		mySubmitButton = new JButton("Create");
		
		// Add action listener to submit button.
		mySubmitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent theEvent) {
				myProject.setMyName(myNameField.getText());
				myProject.setMyCost(Double.parseDouble("0" +
										 (myCostField.getText()).substring(1)));
				int days = Integer.parseInt("0" + myDaysField.getText());
				days += 7 * Integer.parseInt("0" + myWeeksField.getText());
				myProject.setMyDays(days);
				String energy = (String) myEnergyField.getSelectedItem();
				switch (energy) {
					case "High":
						myProject.setMyEnergy(Energy.HIGH);
						break;
					case "Medium":
						myProject.setMyEnergy(Energy.MEDIUM);
						break;
					default:
						myProject.setMyEnergy(Energy.LOW);
				}
				myProject.setMyNotes(myNotesField.getText());
				myFrame.dispose();
				myApp.setEnabled(true);
			}
		});
		
		// Panel layout.
		JPanel Submit = new JPanel(new BorderLayout());
		Submit.add(mySubmitButton, BorderLayout.EAST);
		Submit.setBorder(BorderFactory.createEmptyBorder(5, 0, 25, 0));
		Submit.setPreferredSize(new Dimension(200, 50));
		thePanel.add(Submit);
	}
	
	/**
	 * Shows the frame.
	 * 
	 * @param theFrame The frame to be shown.
	 */
	private void showFrame(final JFrame theFrame) {
		theFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		theFrame.pack();
		theFrame.setLocationRelativeTo(null);
		theFrame.setResizable(false);
		theFrame.setVisible(true);
	}
	
	
	
	/**
	 * Property change listener for NewEditProjectWindow text fields.
	 * 
	 * @author Gordon McCreary
	 * @version May 28, 2019
	 */
	class ProjectListener implements PropertyChangeListener {
		
		@Override
		public void propertyChange(PropertyChangeEvent theEvent) {
			final String propertyName = theEvent.getPropertyName();
			
			// Formats the cost field.
			if ("FormatCost".equals(propertyName)) {
				myCostField.setText(costEvent((String) theEvent.getNewValue()));
				
			// Formats the days field.
			} else if ("FormatDays".equals(propertyName)) {
				int days = Integer.parseInt(0 +
						         integerEvent((String) theEvent.getNewValue()));
				int weeks = (days / 7) + Integer.parseInt(0 +
						                                myWeeksField.getText());
				myDaysField.setText("" + (days % 7));
				myWeeksField.setText("" + weeks);
				
			// Formats the weeks field.
			} else if ("FormatWeeks".equals(propertyName)) {
				myWeeksField.setText(integerEvent(
						                      (String) theEvent.getNewValue()));
			}
		}
		
		/**
		 * Formats the given string to properly represent a US dollar value.
		 * 
		 * @param theOriginal The original string before formatting.
		 * @return The new string after formatting to US dollar.
		 */
		private String costEvent(final String theOriginal) {
			String result = "$";
			final String[] split = theOriginal.split("\\.", 2);
			result += integerEvent(split[0]);
			if (split.length > 1) {
				String change = integerEvent(split[1]);
				while (change.length() < 2) {
					change += "0";
				}
				result += "." + change.substring(0, 2);
			}
			return result;
		}
		
		/**
		 * Formats the given string to an integer by removing any non-integer
		 * characters.
		 * 
		 * @param theOriginal The original string before formatting.
		 * @return The new string after formatting to integer.
		 */
		private String integerEvent(final String theOriginal) {
			String result = "";
			for (int i = 0; i < theOriginal.length(); i++) {
				int c = Character.getNumericValue(theOriginal.charAt(i));
				if (Character.getNumericValue('0') <= c
									   && c <= Character.getNumericValue('9')) {
					result += theOriginal.charAt(i);
				}
			}
			return result;
		}
	}
}