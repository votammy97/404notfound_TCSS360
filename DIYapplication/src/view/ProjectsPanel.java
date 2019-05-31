package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Controller;
import model.ProjectList;

/**
* Class for the left component of the main application
* @author Ken Gil Romero
* @version Spring 19
*/
public class ProjectsPanel extends JPanel {

    /**
     * A generated serial version UID for object Serialization.
     */
	private static final long serialVersionUID = 5924207307409471100L;
	
	/**
	 * Panel that contains all the projects panel	
	 */
	private JPanel myProjectsPanel;
	
    /** The model for reference. */
    private Controller myController;
	
    /**
     * Constructor of the ProjectsPanel
     * @param theController to references the constructor
     */
	ProjectsPanel(final Controller theController) {
		super();
		JPanel LeftPanel = new JPanel(new BorderLayout());
		myController = theController;
        JButton add = new JButton("  +  ");
        add.setBackground(Color.WHITE);
        add.setPreferredSize(new Dimension(250, 50));    
        add.addActionListener(theEvent -> myController.createNewProject());
        LeftPanel.add(add, BorderLayout.NORTH);
        LeftPanel.add(new JPanel(), BorderLayout.CENTER);
        myProjectsPanel = new JPanel();
        myProjectsPanel.setPreferredSize(new Dimension(250, 270));
		LeftPanel.add(new JScrollPane(myProjectsPanel, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, //VERTICAL_SCROLLBAR_ALWAYS
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.SOUTH);
        add(LeftPanel);
	}

	/**
	 * Builds the project panels using the projectsList
	 * @param theProjectsList the panels list of projects
	 */
	public void buildProjectPanels(final ProjectList theProjectsList) {
		myProjectsPanel.removeAll();
		for (int i = 0; i < theProjectsList.getProjectList().size(); i++) {
			myProjectsPanel.add(new ProjectPanel(theProjectsList.getProjectList().get(i)));
		}
		myProjectsPanel.revalidate();
	}
}
