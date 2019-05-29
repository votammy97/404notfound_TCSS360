package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Project;

/**
 * Class for the left component of the main application
 * @author Ken Gil Romero
 * @version Spring 19
 */
public class ProjectsScrollPane extends JScrollPane {
		
    /**
     * A generated serial version UID for object Serialization.
     */
	private static final long serialVersionUID = 2077101975990854195L;
	
    /**
     * The add button to add projects and its panel
     */
    public JButton myAddJButton;   
    
    /**
     * The edit button to edit a project and its panel
     */
    public JButton myEditJButton;
    
    /**
     * The delete button to delete a project and its panel
     */
    public JButton myDeleteJButton;

	/**
     * Setting up the Left components.
     * 
     */
    public ProjectsScrollPane() {      
        super(new JPanel(), 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, //VERTICAL_SCROLLBAR_ALWAYS
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        myAddJButton = new JButton("+");
        myAddJButton.setBackground(Color.WHITE);
        myAddJButton.setPreferredSize(new Dimension(250, 50));
	   	myEditJButton = new JButton("Edit");
		myDeleteJButton = new JButton("Delete");
        
        ((JPanel)this.getViewport().getView()).add(myAddJButton);
    }
    
    /**
     * add a project to the left components.
     * @param theProject the project to be added
     */
    public void addProjectPanel(Project theProject) {
	   	JPanel jPanel = new JPanel();
	   	jPanel.setBorder(BorderFactory.createTitledBorder(theProject.getMyName()));
		jPanel.add(myEditJButton);
		jPanel.add(myDeleteJButton);
		this.add(jPanel);
		this.revalidate();
    }
}