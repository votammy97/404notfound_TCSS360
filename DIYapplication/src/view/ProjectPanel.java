package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Project;

public class ProjectPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7412616505273929177L;
	
	ProjectPanel(Project theProject) {
		super();
		setBorder(BorderFactory.createTitledBorder(theProject.getMyName()));
		setPreferredSize(new Dimension(240, 50));
		setBackground(Color.LIGHT_GRAY);
	}
	
    
//    /**
//     * add a project to the left components.
//     * @param theProject the project to be added
//     */
//    public void addProjectPanel(Project theProject) {
//	   	JPanel jPanel = new JPanel();
//	   	jPanel.setBorder(BorderFactory.createTitledBorder(theProject.getMyName()));
//        JButton edit = new JButton("Edit");
//        edit.addActionListener(theEvent -> myController.setEditProjectButtonActionListener());
//        JButton delete = new JButton("Delete");
//        delete.addActionListener(theEvent -> myController.setDeleteProjectButtonActionListener());
//		jPanel.add(edit);
//		jPanel.add(delete);
//		this.add(jPanel);
//		this.revalidate();
//    }
//    
//    /**
//     * edit a project to the left components.
//     * @param panel to be edited
//     * @param theProject to be edited
//     */
// 	public void editProject(JPanel theJPanel, Project theProject) {
// 		//TODO open editGUI and get project	
//// 		model.addProject(project);
//// 		addProject(project);
// 		theJPanel.setBorder(BorderFactory.createTitledBorder(theProject.getMyName()));
//    	revalidate();
// 	}
//    
//    /**
//     * remove a panel to the left components.
//     * @param theJPanel the panel to be deleted
//     * @param theProject to be deleted
//     */
//    public void deleteProject(JPanel theJPanel, Project theProject) {
// 		//myView.myJPanelLeft.remove(theJPanel);
// 		//TODO:delete Project
// 		revalidate();
//    }   
    
    

}
