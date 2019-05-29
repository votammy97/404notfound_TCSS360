package controller;

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
	}
	
	public void createNewProject() {
		new NewEditProjectWindow(new Project(), myView, this);
	}
	
	public void addCreatedProject(final Project theProject) {
		myModel.addProject(theProject);
	}
}
