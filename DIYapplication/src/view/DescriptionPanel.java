package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.Project;

/**
 * Class for Description Panel.
 * 
 * @author Tammy Vo
 * @version May 30th, 2019
 *
 */
public class DescriptionPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextArea myTextArea;
	private JScrollPane myScrollPane;
//	private Controller myController;
	
	public DescriptionPanel() {
//		myController = theController;
		myTextArea = new JTextArea();
		myTextArea.setLineWrap(true);
		myScrollPane = new JScrollPane(myTextArea);
		myScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		myScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		myScrollPane.setPreferredSize(new Dimension(330, 430));
	
		myTextArea.append("No Project Found.\nPlease Create or Load a Project!"); 
		myTextArea.setEditable(false);
		add(myScrollPane);
	}
	
	/**
	 * Display description when new project created. 
	 * @param project
	 */
	public void displayDescription (final Project project) {
		myTextArea.setText("");	
		myTextArea.append("Name: " + project.getMyName());
		myTextArea.append(String.valueOf("\nCost: $" + project.getMyCost()));
		myTextArea.append(String.valueOf("\nDuration: " + project.getMyDays() + " days"));
		myTextArea.append(String.valueOf("\n" + project.getMyMaterials()));
		myTextArea.append(String.valueOf("\nEnergy Efficiency: " + project.getMyEnergy()));
		myTextArea.append("\nNotes: " + project.getMyNotes());	
	}
	
//		textArea.setText("Name: " + project.getMyName());
//		costLabel.setText(String.valueOf("Cost: " + project.getMyCost()));
//		durationLabel.setText(String.valueOf("Duration: " + project.getMyDays()));
//		materialsLabel.setText(String.valueOf("Materials: " + project.getMyMaterials()));
//		energyLabel.setText(String.valueOf("Energy Efficiency" + project.getMyEnergy()));
//		notesLabel.setText("Notes" + project.getMyNotes());
//		
//		//Adding buttons to DescriptionPanel. 
//		this.add(nameLabel);
//		this.add(costLabel);
//		this.add(durationLabel);
//		this.add(materialsLabel);
//		this.add(energyLabel);
//		this.add(notesLabel);
		
	}


