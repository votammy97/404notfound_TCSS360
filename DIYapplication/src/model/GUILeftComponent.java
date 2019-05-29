package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GUILeftComponent extends JScrollPane {
	
	
    /**
	 * 
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
    public GUILeftComponent() {
        JPanel jPanelLeft = new JPanel();
        
        myAddJButton = new JButton("+");
        myAddJButton.setBackground(Color.WHITE);
        myAddJButton.setPreferredSize(new Dimension(250, 50));
        myAddJButton.addActionListener(theEvent -> {
        	//TODO: 
//        	open add project window
//        	Project project = new Project();
//        	addProject(project)
        });
        
        jPanelLeft.add(myAddJButton);
        final JScrollPane jScrollPane = new JScrollPane(jPanelLeft, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, //VERTICAL_SCROLLBAR_ALWAYS
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }
    
    /**
     * add a project to the left components.
     * @param project the project to be added
     */
   public void addProject(Project project) {
   	JPanel jPanel = new JPanel(new BorderLayout());
   	jPanel.setBorder(BorderFactory.createTitledBorder(project.getMyName()));
		JButton edit = new JButton("Edit");
		edit.addActionListener(theEvent -> {
			editProject(jPanel);
		});
		JButton delete = new JButton("Delete");
	    delete.addActionListener(theEvent -> {
			deleteProject(/* project, */ jPanel); //TODO
		});
		jPanel.add(edit);
		jPanel.add(delete);
   		this.add(jPanel);
   		this.revalidate();
   }
   
   /**
    * edit a project to the left components.
    * @param panel to be edited
    */
   public void editProject(JPanel jPanel) {
		this.remove(jPanel);
		//TODO open editGUI and get project
//		model.addProject(project);
//		addProject(project);
   		this.revalidate();
   }
   
   /**
    * remove a panel to the left components.
    * @param jPanel the panel to be deleted
    */
   public void deleteProject(JPanel jPanel) {
		this.remove(jPanel);
		//TODO remove in the project list
		this.revalidate();
   }
}
