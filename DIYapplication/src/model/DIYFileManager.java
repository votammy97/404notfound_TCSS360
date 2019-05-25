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
	private static final String fileHeader = "#DIYProjects";
	
	/**
	 * Header of the projects' user's name
	 */
	private static final String fileNameHeader = "#Name: ";
	
	/**
	 * Header of the projects' user's email address
	 */
	private static final String fileEmailAddrHeader = "#EmailAddress: ";
	
	/**
	 * Header of the number of projects
	 */
	private static final String fileProjectsSizeHeader = "#ProjectsSize: ";
	
	/**
	 * Header of a project's name
	 */
	private static final String fileProjectNameHeader = "#ProjectName: ";
	
	/**
	 * Header of the project's cost
	 */
	private static final String fileCostHeader = "#Cost: ";
	
	/**
	 * Header of the project's duration for days
	 */
	private static final String fileDurationDayHeader = "#DurationDay: ";
//	private static final String fileDurationWeekHeader = "#DurationWeek: ";
//  private static final String fileDurationMonthHeader = "#DurationMonth: ";
	
	/**
	 * Header of the project's energy efficiency
	 */
	private static final String fileEnergyEffHeader = "#EnergyEfficiency: ";
	
	/**
	 * Header of the project's notes
	 */
	private static final String fileNotesHeader = "#Notes: ";
	
	/**
	 * Header of the project's number of materials
	 */
	private static final String fileMaterialsSizeHeader = "#MaterialSize: ";
	
	/**
	 * Header of the project's material's name
	 */
	private static final String fileMaterialNameHeader = "#MaterialName: ";
	
	/**
	 * Header of the project's material's cost
	 */
	private static final String fileMaterialCostHeader = "#MaterialCost: ";
	
	/**
	 * Header of the project's notes end
	 */
	private static final String fileEndNotes = "-endnotes-";
	
	/**
	 * The list of projects
	 */
	private ProjectList projects;
	
	/**
	 * The user's name
	 */
	public String userName;
	
	/**
	 * The user's email address
	 */
	public String userEmailAddr;
	
	/**
	 * Constructor of  the DIYFileManager
	 */
	public DIYFileManager() {
		projects= new ProjectList();
		userName = "<Name>";
		userEmailAddr = "<EmailAddress>";
	}
	
	/**
	 * @param project to be added to the list of projects
	 */
	public void addProject(Project project) {
		projects.addProject(project);
	}
	
	/**
	 * loading the list of projects
	 * @param projectsFile the file to be loaded
	 * @throws IOException the exception to be thrown
	 */
    public void loadProjects(final File projectsFile) throws IOException {
    	final Scanner scan = new Scanner(projectsFile); 
    	int projectsSize = 0;
    	checkHeader(scan, fileHeader);
    	checkHeader(scan, fileNameHeader);
    	userName = scan.next(); //TODO:
    	checkHeader(scan, fileEmailAddrHeader);
    	userEmailAddr = scan.next(); //TODO:
//    	checkHeader(scan, fileProjectsSizeHeader);
//    	if (scan.hasNextInt()) {
//    		projectsSize = scan.nextInt();
//    	} else {
//    		closeScanThrowIOEx(scan);
//    	}
//    	//new project list
//    	for (int i = 0; i < projectsSize; i++) {
//        	checkHeader(scan, fileProjectNameHeader);
//        	String projectName = scan.next();    
//        	checkHeader(scan, fileCostHeader);
//        	int projectCost;    
//        	if (scan.hasNextInt()) {
//        		projectCost = scan.nextInt();
//        	} else {
//        		closeScanThrowIOEx(scan);
//        	}
//        	checkHeader(scan, fileDurationDayHeader);
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
//        	checkHeader(scan, fileEnergyEffHeader);
//        	//TODO://enum energy eff
//        	if (scan.hasNextInt()) {
//        		//energy eff = scan.nextInt();
//        	} else {
//        		closeScanThrowIOEx(scan);
//        	}
//        	checkHeader(scan, fileNotesHeader);
//        	String projectNotes = "";
//        	while (scan.hasNextLine()) {
//        		String currLine = scan.nextLine();    	
//        		if (currLine.equals(fileEndNotes)) {
//        			break;
//        		} else {
//        			projectNotes += currLine;    
//        		}
//        	}
//        	checkHeader(scan, fileMaterialsSizeHeader);
//        	int materialsSize = 0;
//        	if (scan.hasNextInt()) {
//        		materialsSize = scan.nextInt();
//        	} else {
//        		closeScanThrowIOEx(scan);
//        	}
//        	Material materials = new Materials();
//        	for (int j = 0; j < materialsSize; j++) {
//            	//TODO://new material
//        		checkHeader(scan, fileMaterialNameHeader);
//        		String materialName = scan.next();
//        		checkHeader(scan, fileMaterialCostHeader);
//        		double materialCost;
//            	if (scan.hasNextDouble()) {
//            		materialCost = scan.nextDouble();
//            	} else {
//            		closeScanThrowIOEx(scan);
//            	}
//            	materials.addMaterial(materialName, materialCost);
//        	}
//        	Project project = new Project(projectName, projectDurationDay, projectCost, materials, theEnergy, projectNotes);//TODO
//        	projects.addProject(project);
//    	}
    	scan.close();
    }

	/**
	 * @param scan the scanner to be closed
	 * @throws IOException the exception to be thrown
	 */
	private void closeScanThrowIOEx(final Scanner scan) throws IOException {
		scan.close();
		throw new IOException();
	}
    
    /**
     * Closes the scan and throw IOException.
     * @param scan the scanner to be closed
     * @param header the header to be checked
     * @throws IOException the exception thrown.
     */
    private void checkHeader(Scanner scan, String header) throws IOException {
    	String scan1 = scan.next();
    	if(!scan1.equals(header.trim())) {	
    		closeScanThrowIOEx(scan);
    	}
    }
    
    /**
     * @param projectsFile the file to be saved
     * @throws IOException the exception to be thrown
     */
    public void saveProjects(final File projectsFile) throws IOException {
    	FileWriter fileWriter = new FileWriter(projectsFile);
    	fileWriter.write(fileHeader + "\n");
    	fileWriter.write(fileNameHeader + userName + "\n"); //TODO
    	fileWriter.write(fileEmailAddrHeader + userEmailAddr + "\n"); //TODO
//    	fileWriter.write(fileProjectsSizeHeader + projects.getProjectList().size() + "\n"); 
//    	for (int i = 0; i < projects.getProjectList().size(); i++) {
//    		fileWriter.write(fileProjectNameHeader + projects.getProjectList().get(i).getMyName() + "\n");  	
//    		fileWriter.write(fileCostHeader + projects.getProjectList().get(i).getMyCost() + "\n");
//    		fileWriter.write(fileDurationDayHeader + projects.getProjectList().get(i).getMyDays() + "\n");
////    		fileWriter.write(fileDurationWeekHeader + "" + "\n");
//    		//fileWriter.write(fileDurationMonthHeader + "" + "\n");
//    		fileWriter.write(fileEnergyEffHeader + "" + "\n");//TODO:
//    		fileWriter.write(fileNotesHeader + projects.getProjectList().get(i).getMyNotes() + "\n");
//    		fileWriter.write(fileEndNotes + "\n");
//    		fileWriter.write(fileMaterialsSizeHeader + projects.getProjectList().get(i).getMyMaterials().size() + "\n");
//    		for (Map.Entry<String,Double> entry : projects.getProjectList().get(i).getMyMaterials().entrySet()) {
//    			fileWriter.write(fileMaterialNameHeader + entry.getKey() + "\n");
//    			fileWriter.write(fileMaterialCostHeader + entry.getValue() + "\n");
//    		}
//    	}
    	fileWriter.close();
    }
}
