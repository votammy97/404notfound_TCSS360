package model;

import java.util.ArrayList;

/**
 * Class for the project list.
 * 
 * @author Tammy Vo
 */
public class ProjectList {

	/** ArrayList to store the projects. */
	private ArrayList<Project> myProjectList;

	/** Constructor for ProjectList. */
	public ProjectList() {
		myProjectList = new ArrayList<>();
	}

	/** Method to add projects to project list. */
	public void addProject(final Project theProject) {
		myProjectList.add(theProject);
	}

	/** Method to delete projects from project list. */
	public void deleteProject(final Project theProject) {
		myProjectList.remove(theProject);
	}

	/** Method to get project list. */
	public ArrayList<Project> getProjectList() {
		return myProjectList;
	}

}
