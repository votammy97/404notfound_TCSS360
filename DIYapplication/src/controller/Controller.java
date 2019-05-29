package controller;

import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import model.*;
import view.*;

public class Controller {
	
	/* The project view. */
	private DIYProjectPlanner myView;
	
	/* The project model. */
	private DIYFileManager myModel;
	
	public Controller(final Login theLogin) {
		theLogin.assignController(this);
	}
	
	public void loginSuccess(final DIYProjectPlanner theView,
												final DIYFileManager theModel) {
		myView = theView;
		myModel = theModel;
		//myJFileChooser = new JFileChooser(".");
		//setEditProjectButtonActionListener();
		//setDeleteProjectButtonActionListener();
	}
	
	public void createNewProject() {
		new NewEditProjectWindow(new Project(), myView, this);
	}
	
	public void addCreatedProject(final Project theProject) {
		myModel.addProject(theProject);
		refreshProjects();
	}
	
	public void editProject(final Project theProject) {
		new NewEditProjectWindow(theProject, myView, this);
	}
	
	/**
	 * Refresh the projects panels
	 */
	public void refreshProjects() {
		// This method will refresh the GUI with the updated project list.
		//System.out.println("Refreshing project list not yet implemented.");
		myView.buildProjectPanels(myModel.getProjects());
	}
	
	/**
     * Sets the action of Open
     */
    public void openProjects() {
    	if (myModel.getFileChooser().showOpenDialog(myView) == JFileChooser.APPROVE_OPTION) {
    		try {                  
    			myModel.loadProjects(myModel.getFileChooser().getSelectedFile());
            } catch (final IOException e) {
                JOptionPane.showMessageDialog(myView, "Error loading file.");
            }
        }
    	refreshProjects();
    }
    
    /**
     * Sets the action of Save
     */
    public void saveProjects() {
    	if (myModel.getFileChooser().showSaveDialog(myView) == JFileChooser.APPROVE_OPTION) {
    		try {                  
    			myModel.saveProjects(myModel.getFileChooser().getSelectedFile()); 
            } catch (final IOException e) {
                JOptionPane.showMessageDialog(myView, "Error saving file.");
            }
        }
    }
    
//    /**
//     * Sets the action of the add button
//     */
//    public void setAddProjectButtonActionListener() {
//    	createNewProject();
//        	//TODO
////        	Project project = new Project();
////        	addProject(project)
//    }
//    
//    /**
//     * Sets the action of the edit button
//     */
//    public void setEditProjectButtonActionListener() {
//		//editProject(jPanel, theProject);
//    }
//    
//    /**
//     * Sets the action of the delete button
//     */
//    public void setDeleteProjectButtonActionListener() {
//		//deleteProject(jPanel, theProject);
//    }
}
