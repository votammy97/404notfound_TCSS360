package controller;

import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.*;
import view.*;

public class Controller {
	
	/* The project view. */
	private DIYProjectPlanner myView;
	
	/* The project model. */
	private DIYFileManager myModel;
	
    /** The file chooser for opening and saving an image. */
    private JFileChooser myJFileChooser;
	
	public Controller(final Login theLogin) {
		theLogin.assignController(this);
	}
	
	public void loginSuccess(final DIYProjectPlanner theView,
												final DIYFileManager theModel) {
		myView = theView;
		myModel = theModel;
		myJFileChooser = new JFileChooser(".");
		setSaveActionListener();
		setOpenActionListener();
		//setEditProjectButtonActionListener();
		//setDeleteProjectButtonActionListener();
	}
	
	public void createNewProject() {
		new NewEditProjectWindow(new Project(), myView, this);
	}
	
	public void addCreatedProject(final Project theProject) {
		myModel.addProject(theProject);
	}
	
	/**
     * Sets the action of Open
     */
    private void setOpenActionListener() {
        myView.myOpen.addActionListener(theEvent -> {
        	if (myJFileChooser.showOpenDialog(myView) == JFileChooser.APPROVE_OPTION) {
        		try {                  
        			myModel.loadProjects(myJFileChooser.getSelectedFile()); 
                        
                } catch (final IOException e) {
                    JOptionPane.showMessageDialog(myView,
                                    "Error loading file.");
                }
            }
        });
    }
    
    /**
     * Sets the action of Save
     */
    private void setSaveActionListener() {
        myView.mySave.addActionListener(theEvent -> {
        	if (myJFileChooser.showSaveDialog(myView) == JFileChooser.APPROVE_OPTION) {
        		try {                  
        			myModel.saveProjects(myJFileChooser.getSelectedFile()); 
                        
                } catch (final IOException e) {
                    JOptionPane.showMessageDialog(myView,
                                    "Error saving file.");
                }
            }
        });
    }
    
    /**
     * Sets the action of the add button
     */
    private void setAddProjectButtonActionListener() {
        myView.myAddJButton.addActionListener(theEvent -> {
        	createNewProject();
        	//TODO
//        	Project project = new Project();
//        	addProject(project)
        });
    }
    
    /**
     * Sets the action of the edit button
     */
    private void setEditProjectButtonActionListener() {
		myView.myJPanelLeft.myEditJButton.addActionListener(theEvent -> {
			//editProject(jPanel, theProject);
		});
    }
    
    /**
     * Sets the action of the delete button
     */
    private void setDeleteProjectButtonActionListener() {
		myView.myJPanelLeft.myDeleteJButton.addActionListener(theEvent -> {
			//deleteProject(jPanel, theProject);
		});
    }
    
    /**
     * edit a project to the left components.
     * @param panel to be edited
     * @param theProject to be edited
     */
 	public void editProject(JPanel theJPanel, Project theProject) {
 		//TODO open editGUI and get project	
// 		model.addProject(project);
// 		addProject(project);
 		theJPanel.setBorder(BorderFactory.createTitledBorder(theProject.getMyName()));
    	myView.myJPanelLeft.revalidate();
 	}
    
    /**
     * remove a panel to the left components.
     * @param theJPanel the panel to be deleted
     * @param theProject to be deleted
     */
    public void deleteProject(JPanel theJPanel, Project theProject) {
 		//myView.myJPanelLeft.remove(theJPanel);
 		//TODO:delete Project
 		myView.myJPanelLeft.revalidate();
    }   
}
