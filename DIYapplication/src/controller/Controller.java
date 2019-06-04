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
	
	/**
	 * Constructor for the Controller.
	 * 
	 * @param theLogin The login window.
	 */
	public Controller(final Login theLogin) {
		theLogin.assignController(this);
	}
	
	/**
	 * This method is automatically called by the login window after a login is
	 * successful.
	 * 
	 * @param theView The view received from the login.
	 * @param theModel The model received from the login.
	 */
	public void loginSuccess(final DIYProjectPlanner theView,
												final DIYFileManager theModel) {
		myView = theView;
		myModel = theModel;
	}
	
	/**
	 * Calling this method will bring up the New Project Window.
	 */
	public void createNewProject() {
		new NewEditProjectWindow(new Project(), myView, this);
	}
	
	/**
	 * This method is automatically called by the New Project Window once the
	 * create button is clicked.
	 * 
	 * @param theProject The project that was created.
	 */
	public void addCreatedProject(final Project theProject) {
		myModel.addProject(theProject);
	}
	
	/**
	 * Calling this method will bring up the Edit Project Window.
	 * 
	 * @param theProject The project that will be edited.
	 */
	public void editProject(final Project theProject) {
		new NewEditProjectWindow(theProject, myView, this);
	}
	
	/**
	 * Calling this method will delete given project from project list.
	 * @param theProject the project which will be delete.
	 */
	public void deleteProject(final Project theProject) {
		myModel.getProjectList().deleteProject(theProject);
	}
	
	/**
	 * Calling this method refreshes the GUI display of the current project
	 * list. This method should be called whenever a project is added, deleted,
	 * or whenever sorting is performed on the ProjectList.
	 */
	public void refreshProjects() {
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
    
	/**
	 * Determines whether a project already exists with the given name.
	 * 
	 * @param theProjectName The project name to search for.
	 * @return True if the project already exists.
	 */
	public boolean projectExists(final String theProjectName) {
		return myModel.getProjectList().containsName(theProjectName);
	}
	
	/**
     * Removes the non-integer characters from a given string.
     * 
     * @param theInput The string to be formatted.
     * @return The original string with non-integer character removed.
     */
    public String formatInt(final String theInput) {
    	return model.StringFormatters.removeNonInt(theInput);
    }
    
    /**
     * Formats the given string to represent a US dollar cost.
     * 
     * @param theInput The string to be formatted.
     * @return The original string formatted to represent a US dollar cost.
     */
    public String formatCost(final String theInput) {
    	return model.StringFormatters.formatCost(theInput);
    }
    
    /**
     * If the given string is longer than the given length, the string return
     * with any character past the given length removed.
     * 
     * @param theInput The string to be formatted.
     * @param theLength The maximum length allowed.
     * @return The string with length less than or equal to the given length.
     */
    public String formatLength(final String theInput, final int theLength) {
    	return model.StringFormatters.formatLength(theInput, theLength);
    }
    
	/**
	 * Sorts the project panels by name in alphabetical order.
	 */
    public void sortByName() {
    	myModel.getProjects().getProjectList().sort(ProjectComparator.sortByName());
    	myView.buildProjectPanels(myModel.getProjects());
    }
    
	/**
	 * Sorts the project panels by name in reverse alphabetical order.
	 */
    public void sortByNameR() {
    	myModel.getProjects().getProjectList().sort(ProjectComparator.sortByNameReversed());
    	myView.buildProjectPanels(myModel.getProjects());
    }
    
	/**
	 * Sorts the project panels by cost in ascending order.
	 */
    public void sortByCost() {
    	myModel.getProjects().getProjectList().sort(ProjectComparator.sortByCost());
    	myView.buildProjectPanels(myModel.getProjects());
    }
    
	/**
	 * Sorts the project panels by cost in descending order.
	 */
    public void sortByCostR() {
    	myModel.getProjects().getProjectList().sort(ProjectComparator.sortByCostReversed());
    	myView.buildProjectPanels(myModel.getProjects());
    }
    
	/**
	 * Sorts the project panels by duration in ascending order.
	 */
    public void sortByDuration() {
    	myModel.getProjects().getProjectList().sort(ProjectComparator.sortByDuration());
    	myView.buildProjectPanels(myModel.getProjects());
    }
    
	/**
	 * Sorts the project panels by duration in descending order.
	 */
    public void sortByDurationR() {
    	myModel.getProjects().getProjectList().sort(ProjectComparator.sortByDurationReversed());
    	myView.buildProjectPanels(myModel.getProjects());
    }
    
	/**
	 * Sorts the project panels by energy efficiency in normal order.
	 */
    public void sortByEnergy() {
    	myModel.getProjects().getProjectList().sort(ProjectComparator.sortByEnergy());
    	myView.buildProjectPanels(myModel.getProjects());
    }
    
	/**
	 * Sorts the project panels by energy efficiency in reversed order.
	 */
    public void sortByEnergyR() {
    	myModel.getProjects().getProjectList().sort(ProjectComparator.sortByEnergyReversed());
    	myView.buildProjectPanels(myModel.getProjects());
    }
}
