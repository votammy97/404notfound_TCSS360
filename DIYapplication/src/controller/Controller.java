package controller;

import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

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
    public void openProjects() {
    	if (myJFileChooser.showOpenDialog(myView) == JFileChooser.APPROVE_OPTION) {
    		try {                  
    			myModel.loadProjects(myJFileChooser.getSelectedFile()); 
                    
            } catch (final IOException e) {
                JOptionPane.showMessageDialog(myView,
                                "Error loading file.");
            }
        }
    }
    
    /**
     * Sets the action of Save
     */
    public void saveProjects() {
    	if (myJFileChooser.showSaveDialog(myView) == JFileChooser.APPROVE_OPTION) {
    		try {                  
    			myModel.saveProjects(myJFileChooser.getSelectedFile()); 
                    
            } catch (final IOException e) {
                JOptionPane.showMessageDialog(myView,
                                "Error saving file.");
            }
        }
    }
}
