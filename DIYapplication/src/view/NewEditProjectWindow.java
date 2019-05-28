package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders;
import model.Project;

public class NewEditProjectWindow {
	
	private JTextField myNameField;
	private JTextField myCostField;
	private JTextField myDaysField;
	private JTextField myWeeksField;
	private JComboBox<String> myEnergyField;
	private JTextArea myNotesField;
	private ProjectListener myListener;
	
	public NewEditProjectWindow(final boolean theNew, final Project theProject) {
		myListener = new ProjectListener();
		JFrame frame;
		if (theNew) {
			frame = new JFrame("Create New Project");
		} else {
			frame = new JFrame("Edit Project");
		}
		JPanel panel = new JPanel();
		buildPanel(panel);
		frame.add(panel);
		showFrame(frame);
	}
	
	private void buildPanel(final JPanel thePanel) {
		thePanel.setLayout(new BoxLayout(thePanel, BoxLayout.Y_AXIS));
		
		addName(thePanel);
		
		addCost(thePanel);
		
		addDuration(thePanel);
		
		addEnergyEfficiency(thePanel);
		
		addNotes(thePanel);
		
		thePanel.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 25));
	}
	
	private void addName(final JPanel thePanel) {
		JPanel Name = new JPanel(new BorderLayout());
		Name.add(new JLabel("Name:"), BorderLayout.WEST);
		myNameField = new JTextField(15);
		Name.add(myNameField, BorderLayout.EAST);
		Name.setBorder(BorderFactory.createEmptyBorder(25, 0, 5, 0));
		Name.setPreferredSize(new Dimension(200, 50));
		thePanel.add(Name);
	}
	
	private void addCost(final JPanel thePanel) {
		JPanel Cost = new JPanel(new BorderLayout());
		JLabel label = new JLabel("Cost:");
		myCostField = new JTextField(10);
		myCostField.setText("$");
		myCostField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent theEvent) {
				myListener.propertyChange(new PropertyChangeEvent(myCostField, "FormatCost", myCostField.getText(), myCostField.getText()));
			}
			@Override
			public void focusGained(FocusEvent e) {}
		});
		myCostField.setPreferredSize(new Dimension(100, 20));
		Cost.add(label, BorderLayout.WEST);
		Cost.add(myCostField, BorderLayout.EAST);
		Cost.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 50));
		Cost.setPreferredSize(new Dimension(200, 30));
		thePanel.add(Cost);
	}
	
	private void addDuration(final JPanel thePanel) {
		JPanel Duration = new JPanel(new BorderLayout());
		Duration.add(new JLabel("Duration:"), BorderLayout.WEST);
		JPanel DurEntries = new JPanel();
		DurEntries.setLayout(new BoxLayout(DurEntries, BoxLayout.Y_AXIS));
		JPanel Days = new JPanel(new BorderLayout());
		Days.add(new JLabel("     Days"), BorderLayout.EAST);
		myDaysField = new JTextField(5);
		myDaysField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent theEvent) {
				myListener.propertyChange(new PropertyChangeEvent(myDaysField, "FormatDays", myDaysField.getText(), myDaysField.getText()));
			}
			@Override
			public void focusGained(FocusEvent e) {}
		});
		Days.add(myDaysField, BorderLayout.WEST);
		JPanel Weeks = new JPanel(new BorderLayout());
		Weeks.add(new JLabel("     Weeks"), BorderLayout.EAST);
		myWeeksField = new JTextField(5);
		myWeeksField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent theEvent) {
				myListener.propertyChange(new PropertyChangeEvent(myWeeksField, "FormatWeeks", myWeeksField.getText(), myWeeksField.getText()));
			}
			@Override
			public void focusGained(FocusEvent e) {}
		});
		Weeks.add(myWeeksField, BorderLayout.WEST);
		DurEntries.add(Days);
		DurEntries.add(Weeks);
		Duration.add(DurEntries, BorderLayout.EAST);
		Duration.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 25));
		Duration.setPreferredSize(new Dimension(200, 60));
		thePanel.add(Duration);
	}
	
	private void addEnergyEfficiency(final JPanel thePanel) {
		JPanel EnergyEfficiency = new JPanel(new BorderLayout());
		EnergyEfficiency.add(new JLabel("Energy Efficiency:"), BorderLayout.WEST);
		myEnergyField = new JComboBox<String>(new String[] {"Low", "Medium", "High"});
		EnergyEfficiency.add(myEnergyField, BorderLayout.EAST);
		EnergyEfficiency.setBorder(BorderFactory.createEmptyBorder(12, 0, 12, 15));
		EnergyEfficiency.setPreferredSize(new Dimension(200, 50));
		thePanel.add(EnergyEfficiency);
	}
	
	private void addNotes(final JPanel thePanel) {
		JPanel Notes = new JPanel(new BorderLayout());
		Notes.add(new JLabel("Notes:"), BorderLayout.WEST);
		myNotesField = new JTextArea(4, 15);
		myNotesField.setLineWrap(true);
		JScrollPane scrollNotes = new JScrollPane(myNotesField);
		Notes.add(scrollNotes, BorderLayout.EAST);
		Notes.setBorder(BorderFactory.createEmptyBorder(5, 0, 25, 0));
		Notes.setPreferredSize(new Dimension(200, 80));
		thePanel.add(Notes);
	}
	
	private void showFrame(final JFrame theFrame) {
		theFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		theFrame.pack();
		theFrame.setLocationRelativeTo(null);
		theFrame.setResizable(false);
		theFrame.setVisible(true);
	}
	
	
	
	
	class ProjectListener implements PropertyChangeListener {

		@Override
		public void propertyChange(PropertyChangeEvent theEvent) {
			final String propertyName = theEvent.getPropertyName();
			if ("FormatCost".equals(propertyName)) {
				myCostField.setText(costEvent((String) theEvent.getNewValue()));
			} else if ("FormatDays".equals(propertyName)) {
				int days = Integer.parseInt(0 + integerEvent((String) theEvent.getNewValue()));
				int weeks = (days / 7) + Integer.parseInt(0 + myWeeksField.getText());
				myDaysField.setText("" + (days % 7));
				myWeeksField.setText("" + weeks);
			} else if ("FormatWeeks".equals(propertyName)) {
				myWeeksField.setText(integerEvent((String) theEvent.getNewValue()));
			}
		}
		
		private String costEvent(final String theOriginal) {
			String result = "$";
			final String[] split = theOriginal.split("\\.", 2);
			result += integerEvent(split[0]);
			
			// Uncomment this to implement cents.
//			if (split.length > 1) {
//				String change = integerEvent(split[1]);
//				while (change.length() < 2) {
//					change += "0";
//				}
//				result += "." + change.substring(0, 2);
//			}
			
			return result;
		}
		
		private String integerEvent(final String theOriginal) {
			String result = "";
			for (int i = 0; i < theOriginal.length(); i++) {
				int c = Character.getNumericValue(theOriginal.charAt(i));
				if (Character.getNumericValue('0') <= c && c <= Character.getNumericValue('9')) {
					result += theOriginal.charAt(i);
				}
			}
			return result;
		}
		
	}
}