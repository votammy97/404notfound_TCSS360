package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.Scanner;

/**
 * Class for saving and loading information
 * @author Ken Gil Romero
 * @version Spring 19
 */
public class DIYFileManager {
	
	/**
	 * Header of the project workspace
	 */
	private static final String myFileHeader = "#DIYProjects";
	
	/**
	 * Header of the projects' user's name
	 */
	private static final String myFileNameHeader = "#Name: ";
	
	/**
	 * Header of the projects' user's email address
	 */
	private static final String  myfileEmailAddrHeader = "#EmailAddress: ";
	
	/**
	 * Header of the number of projects
	 */
	private static final String myFileProjectsSizeHeader = "#ProjectsSize: ";
	
	/**
	 * Header of a project's name
	 */
	private static final String myFileProjectNameHeader = "#ProjectName: ";
	
	/**
	 * Header of the project's cost
	 */
	private static final String myFileCostHeader = "#Cost: ";
	
	/**
	 * Header of the project's duration for days
	 */
	private static final String myFileDurationDayHeader = "#DurationDay: ";
//	private static final String fileDurationWeekHeader = "#DurationWeek: ";
//  private static final String fileDurationMonthHeader = "#DurationMonth: ";
	
	/**
	 * Header of the project's energy efficiency
	 */
	private static final String myFileEnergyEffHeader = "#EnergyEfficiency: ";
	
	/**
	 * Header of the project's notes
	 */
	private static final String myFileNotesHeader = "#Notes: ";
	
	/**
	 * Header of the project's number of materials
	 */
	private static final String myFileMaterialsSizeHeader = "#MaterialSize: ";
	
	/**
	 * Header of the project's material's name
	 */
	private static final String myFileMaterialNameHeader = "#MaterialName: ";
	
	/**
	 * Header of the project's material's cost
	 */
	private static final String myFileMaterialCostHeader = "#MaterialCost: ";
	
	/**
	 * Header of the project's notes end
	 */
	private static final String myFileEndNotes = "-endnotes-";
	
	/**
	 * The list of projects
	 */
	private ProjectList myProjects;
	
	/**
	 * The user's name
	 */
	private String myUserFirstName;
	
	/**
	 * The user's email address
	 */
	private String myUserEmailAddr;
	
	/**
	 * Constructor of  the DIYFileManager
	 */
	public DIYFileManager(String theFirstName, String theEmailAddr) {
		myProjects= new ProjectList();
		myUserFirstName = theFirstName;
		myUserEmailAddr = theEmailAddr;
	}
	
	/**
	 * @return the first name of the DIYer
	 */
	public String getFirstName() {
		return myUserFirstName;
	}
	
	
	/**
	 * @return the email address of the DIYer
	 */
	public String getEmailAddress() {
		return myUserEmailAddr;
	}
	
	/**
	 * @param theProject to be added to the list of projects
	 */
	public void addProject(Project theProject) {
		myProjects.addProject(theProject);
	}
	
	/**
	 * loading the list of projects
	 * @param theProjectsFile the file to be loaded
	 * @throws IOException the exception to be thrown
	 */
    public void loadProjects(final File theProjectsFile) throws IOException {
    	final Scanner scan = new Scanner(theProjectsFile); 
    	int projectsSize = 0;
    	checkHeader(scan, myFileHeader);
    	checkHeader(scan, myFileNameHeader);
    	myUserFirstName = scan.next(); 
    	checkHeader(scan, myfileEmailAddrHeader);
    	myUserEmailAddr = scan.next(); 
    	checkHeader(scan, myFileProjectsSizeHeader);
//    	if (scan.hasNextInt()) {
//    		projectsSize = scan.nextInt();
//    	} else {
//    		closeScanThrowIOEx(scan);
//    	}
//    	//new project list
//    	for (int i = 0; i < projectsSize; i++) {
//        	checkHeader(scan, myFileProjectNameHeader);
//        	String projectName = scan.next();    
//        	checkHeader(scan, myFileCostHeader);
//        	int projectCost;    
//        	if (scan.hasNextInt()) {
//        		projectCost = scan.nextInt();
//        	} else {
//        		closeScanThrowIOEx(scan);
//        	}
//        	checkHeader(scan, myFileDurationDayHeader);
//        	int projectDurationDay;    	
//        	if (scan.hasNextInt()) {
//        		projectDurationDay = scan.nextInt();
//        	} else {
//        		closeScanThrowIOEx(scan);
//        	}
////        	checkHeader(scan, fileDurationWeekHeader);
////        	int projectDurationWeek;    
////        	if (scan.hasNextInt()) {
////        		projectDurationWeek = scan.nextInt();
////        	} else {
////        		closeScanThrowIOEx(scan);
////        	}
////        	checkHeader(scan, fileDurationMonthHeader);
////        	int projectDurationMonth;    	
////        	if (scan.hasNextInt()) {
////        		projectDurationMonth = scan.nextInt();
////        	} else {
////        		closeScanThrowIOEx(scan);
////        	}
//        	checkHeader(scan, myFileEnergyEffHeader);
//        	//TODO://enum energy eff
//        	if (scan.hasNextInt()) {
//        		//energy eff = scan.nextInt();
//        	} else {
//        		closeScanThrowIOEx(scan);
//        	}
//        	checkHeader(scan, myFileNotesHeader);
//        	String projectNotes = "";
//        	while (scan.hasNextLine()) {
//        		String currLine = scan.nextLine();    	
//        		if (currLine.equals(myFileEndNotes)) {
//        			break;
//        		} else {
//        			projectNotes += currLine;    
//        		}
//        	}
//        	checkHeader(scan, myFileMaterialsSizeHeader);
//        	int materialsSize = 0;
//        	if (scan.hasNextInt()) {
//        		materialsSize = scan.nextInt();
//        	} else {
//        		closeScanThrowIOEx(scan);
//        	}
//        	Material materials = new Materials();
//        	for (int j = 0; j < materialsSize; j++) {
//            	//TODO://new material
//        		checkHeader(scan, myFileMaterialNameHeader);
//        		String materialName = scan.next();
//        		checkHeader(scan, myFileMaterialCostHeader);
//        		double materialCost;
//            	if (scan.hasNextDouble()) {
//            		materialCost = scan.nextDouble();
//            	} else {
//            		closeScanThrowIOEx(scan);
//            	}
//            	materials.addMaterial(materialName, materialCost);
//        	}
//        	Project project = new Project(projectName, projectDurationDay, projectCost, materials, theEnergy, projectNotes);//TODO
//        	myProjects.addProject(project);
//    	}
//    	scan.close();
    }

	/**
	 * @param theScan the scanner to be closed
	 * @throws IOException the exception to be thrown
	 */
	private void closeScanThrowIOEx(final Scanner theScan) throws IOException {
		theScan.close();
		throw new IOException();
	}
    
    /**
     * Closes the scan and throw IOException.
     * @param theScan the scanner to be closed
     * @param theHeader the header to be checked
     * @throws IOException the exception thrown.
     */
    private void checkHeader(Scanner theScan, String theHeader) throws IOException {
    	String scan1 = theScan.next();
    	if(!scan1.equals(theHeader.trim())) {	
    		closeScanThrowIOEx(theScan);
    	}
    }
    
    /**
     * @param theProjectsFile the file to be saved
     * @throws IOException the exception to be thrown
     */
    public void saveProjects(final File theProjectsFile) throws IOException {
    	FileWriter fileWriter = new FileWriter(theProjectsFile);
    	fileWriter.write(myFileHeader + "\n");
    	fileWriter.write(myFileNameHeader + myUserFirstName + "\n"); 
    	fileWriter.write(myfileEmailAddrHeader + myUserEmailAddr + "\n"); 
    	fileWriter.write(myFileProjectsSizeHeader + myProjects.getProjectList().size() + "\n"); 
    	for (int i = 0; i < myProjects.getProjectList().size(); i++) {
    		fileWriter.write(myFileProjectNameHeader + myProjects.getProjectList().get(i).getMyName() + "\n");  	
    		fileWriter.write(myFileCostHeader + myProjects.getProjectList().get(i).getMyCost() + "\n");
    		fileWriter.write(myFileDurationDayHeader + myProjects.getProjectList().get(i).getMyDays() + "\n");
//    		fileWriter.write(fileDurationWeekHeader + "" + "\n");
    		//fileWriter.write(fileDurationMonthHeader + "" + "\n");
    		fileWriter.write(myFileEnergyEffHeader + "" + "\n");//TODO:
    		fileWriter.write(myFileNotesHeader + myProjects.getProjectList().get(i).getMyNotes() + "\n");
    		fileWriter.write(myFileEndNotes + "\n");
    		fileWriter.write(myFileMaterialsSizeHeader + myProjects.getProjectList().get(i).getMyMaterials().size() + "\n");
    		for (Map.Entry<String,Double> entry : myProjects.getProjectList().get(i).getMyMaterials().entrySet()) {
    			fileWriter.write(myFileMaterialNameHeader + entry.getKey() + "\n");
    			fileWriter.write(myFileMaterialCostHeader + entry.getValue() + "\n");
    		}
    	}
    	fileWriter.close();
    }
    
    public String getName() {
    	return myUserFirstName;
    }
    
    public void setName(String theFirstName) {
    	myUserFirstName = theFirstName;
    }
    
    public String getEmail() {
    	return myUserEmailAddr;
    }
    
    public void setEmail(String theEmailAddr) {
    	myUserEmailAddr = theEmailAddr;
    }
}
