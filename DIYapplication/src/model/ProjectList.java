package model;

import java.util.ArrayList;

/**
 * Class for the project list.
 * 
 * @author Tammy Vo
 *
 */
public class ProjectList {
	
	/** ArrayList to store the projects. */
	private ArrayList<Project> myProjectList; 

	/** Constructor for ProjectList. */
	public ProjectList() {
		myProjectList = new ArrayList<Project>();
	}
	
	/** Method to add projects to project list. */
	public void addProject(Project p) {
		myProjectList.add(p);
	}
	
	/** Method to get project list. */
	public ArrayList<Project> getProjectList(){
		return myProjectList;
	}

}
