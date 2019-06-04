package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;
import model.Project;

public class ProjectPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7412616505273929177L;
	/**
	 * edit button.
	 */
	private JButton myEdit;
	/**
	 * delete button.
	 */
	private JButton myDelete;
	/**
	 * my project panel.
	 */
	private JPanel myProject;
	/**
	 * right panel.
	 */
	private JPanel myRightPanel;
	/**
	 * project.
	 * @param theProject
	 */
	ProjectPanel(Project theProject, final Controller theController) {
		//super();
		
		//setup layout.
		setLayout(new BorderLayout());
		//two buttons.
		myEdit = new JButton("edit");
		myDelete = new JButton("delete");
		//setup display stuff.
		setBorder(BorderFactory.createTitledBorder(theProject.getMyName()));
		setPreferredSize(new Dimension(240, 50));
		setBackground(Color.LIGHT_GRAY);
		
//		add(myProject);
//		myProject.setBorder(BorderFactory.createTitledBorder(theProject.getMyName()));
//		myProject.setPreferredSize(new Dimension(240, 50));
		
		//new panel for those two buttons.
		myRightPanel = new JPanel();
		myRightPanel.setLayout(new GridLayout(2,1));
		//setup position.
		myRightPanel.add(myEdit, BorderLayout.EAST);
		myRightPanel.add(myDelete, BorderLayout.EAST);
		add(myRightPanel, BorderLayout.EAST);
		revalidate();
		
		//actionlistener for edit button.
		myEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				theController.editProject(theProject);
			}
			
		});
		//actionlistener for delete button.
		myDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				theController.deleteProject(theProject);
				removeAll();
				revalidate();
				theController.refreshProjects();
				//repaint();
			}
			
		});
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
