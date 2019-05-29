package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ProjectsPanel extends JScrollPane {
	
	/**
	 * Class for the left component of the main application
	 * @author Ken Gil Romero
	 * @version Spring 19
	 */
	
    /**
     * A generated serial version UID for object Serialization.
     */
	private static final long serialVersionUID = 2077101975990854195L;
	
    /**
     * The add button to add projects and its panel
     */
    JButton myAddJButton;   

	/**
     * Setting up the Left components.
     * 
     */
    public ProjectsPanel() {      
        super(new JPanel(), 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, //VERTICAL_SCROLLBAR_ALWAYS
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        myAddJButton = new JButton("+");
        myAddJButton.setBackground(Color.WHITE);
        myAddJButton.setPreferredSize(new Dimension(250, 50));
        myAddJButton.addActionListener(theEvent -> {
        	//TODO: 
//        	open add project window
//        	Project project = new Project();
//        	addProject(project)
        });
        
        ((JPanel)this.getViewport().getView()).add(myAddJButton);
    }
    
    /**
     * add a project to the left components.
     * @param theProject the project to be added
     */
   public void addProject(Project theProject) {
   	JPanel jPanel = new JPanel(new BorderLayout());
   	jPanel.setBorder(BorderFactory.createTitledBorder(theProject.getMyName()));
		JButton edit = new JButton("Edit");
		edit.addActionListener(theEvent -> {
			editProject(jPanel, theProject);
		});
		JButton delete = new JButton("Delete");
	    delete.addActionListener(theEvent -> {
			deleteProject(jPanel, theProject); 
		});
		jPanel.add(edit);
		jPanel.add(delete);
   		this.add(jPanel);
   		this.revalidate();
   }
   
   /**
    * edit a project to the left components.
    * @param panel to be edited
    * @param theProject to be edited
    */
   public void editProject(JPanel theJPanel, Project theProject) {
		this.remove(theJPanel);
		//TODO open editGUI and get project	
//		model.addProject(project);
//		addProject(project);
   		this.revalidate();
   }
   
   /**
    * remove a panel to the left components.
    * @param theJPanel the panel to be deleted
    * @param theProject to be deleted
    */
   public void deleteProject(JPanel theJPanel, Project theProject) {
		this.remove(theJPanel);
		
		this.revalidate();
   }
}
