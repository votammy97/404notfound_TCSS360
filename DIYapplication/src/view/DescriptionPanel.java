package view;

import java.awt.Dimension;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.Project;

/**
 * Class for Description Panel.
 * 
 * @author Tammy Vo
 * @version June 5th, 2019
 *
 */
public class DescriptionPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextArea myTextArea;
	private JScrollPane myScrollPane;

	/**
	 * Description Panel.
	 * 
	 * @author Tammy Vo
	 */
	public DescriptionPanel() {
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
	 * 
	 * @author Tammy Vo
	 * @param theProject the project
	 */
	public void displayDescription(final Project theProject) {
		DecimalFormat df = new DecimalFormat("0.00");
		myTextArea.setText("");
		myTextArea.append("Name:\n" + theProject.getMyName());
		myTextArea.append(String.valueOf("\n\nCost:\n$" + df.format(theProject.getMyCost())));
		myTextArea.append(String.valueOf("\n\nDuration:\n" + theProject.getMyDays() + " days"));
		myTextArea.append(String.valueOf("\n\nEnergy Efficiency:\n" + theProject.getMyEnergy()));
		myTextArea.append(String.valueOf("\n\nMaterials:\n" + theProject.getMyMaterials()));
		myTextArea.append("\n\nNotes:\n" + theProject.getMyNotes());
	}

	/**
	 * Reset the DescriptionPanel to its initial state.
	 * 
	 * @author Tammy Vo
	 */
	public void resetDescription() {
		myTextArea.setText("No Project Found.\nPlease Create or Load a Project!");
	}

}
