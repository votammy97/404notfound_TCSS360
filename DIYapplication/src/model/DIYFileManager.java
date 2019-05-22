package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class DIYFileManager {
	
	private static final String fileHeader = "#DIY Projects";
	private static final String fileProjectsSizeHeader = "#Projects Size: ";
	private static final String fileNameHeader = "#Name: ";
	private static final String fileCostHeader = "#Cost: ";
	private static final String fileDurationDayHeader = "#Duration Day: ";
	private static final String fileDurationWeekHeader = "#Duration Week: ";
	private static final String fileDurationMonthHeader = "#Duration Month: ";
	private static final String fileEnergyEffHeader = "#Energy Efficiency: ";
	private static final String fileNotesHeader = "#Notes: ";
	private static final String fileMaterialsSizeHeader = "#Material Size: ";
	private static final String fileMaterialHeader = "#Material: ";
	private static final String fileMaterialCostHeader = "#Material: ";
	private static final String fileEndNotes = "-end notes-";
	
	//TODO: add more headers for loading project and saving project
	
    public void loadProjects(final File projectsFile) throws IOException {
    	final Scanner scan = new Scanner(projectsFile); 
    	int projectsSize = 0;
    	checkHeader(scan, fileHeader);
    	checkHeader(scan, fileProjectsSizeHeader);
    	if (scan.hasNextInt()) {
    		projectsSize = scan.nextInt();
    	} else {
    		closeScanThrowIOEx(scan);
    	}
    	//new project list
    	for (int i = 0; i < projectsSize; i++) {
        	//TODO://new project
        	checkHeader(scan, fileNameHeader);
        	String projectName = scan.next();    	//TODO:
        	checkHeader(scan, fileCostHeader);
        	int projectCost;    	//TODO:
        	if (scan.hasNextInt()) {
        		projectCost = scan.nextInt();
        	} else {
        		closeScanThrowIOEx(scan);
        	}
        	checkHeader(scan, fileDurationDayHeader);
        	int projectDurationDay;    	//TODO:
        	if (scan.hasNextInt()) {
        		projectDurationDay = scan.nextInt();
        	} else {
        		closeScanThrowIOEx(scan);
        	}
        	checkHeader(scan, fileDurationWeekHeader);
        	int projectDurationWeek;    	//TODO:
        	if (scan.hasNextInt()) {
        		projectDurationWeek = scan.nextInt();
        	} else {
        		closeScanThrowIOEx(scan);
        	}
        	checkHeader(scan, fileDurationMonthHeader);
        	int projectDurationMonth;    	//TODO:
        	if (scan.hasNextInt()) {
        		projectDurationMonth = scan.nextInt();
        	} else {
        		closeScanThrowIOEx(scan);
        	}
        	checkHeader(scan, fileEnergyEffHeader);
        	//TODO://enum energy eff
        	if (scan.hasNextInt()) {
        		//energy eff = scan.nextInt();
        	} else {
        		closeScanThrowIOEx(scan);
        	}
        	checkHeader(scan, fileNotesHeader);
        	String projectNotes = "";
        	while (scan.hasNextLine()) {
        		String currLine = scan.nextLine();    	//TODO:
        		if (currLine.equals(fileEndNotes)) {
        			break;
        		} else {
        			projectNotes += currLine;    	//TODO:
        		}
        	}
        	checkHeader(scan, fileMaterialsSizeHeader);
        	int materialsSize = 0;//TODO:
        	//TODO://enum energy eff
        	if (scan.hasNextInt()) {
        		materialsSize = scan.nextInt();
        	} else {
        		closeScanThrowIOEx(scan);
        	}
        	for (int j = 0; j < materialsSize; j++) {
            	//TODO://new material
        		checkHeader(scan, fileMaterialHeader);
        		String materialName = scan.next();
        		checkHeader(scan, fileMaterialCostHeader);
        		int materialCost;
            	if (scan.hasNextInt()) {
            		materialCost = scan.nextInt();
            	} else {
            		closeScanThrowIOEx(scan);
            	}
            	//TODO://add material to the material list of the project
        	}
        	//TODO://add to project list
    	}
    	scan.close();
    }

	/**
	 * @param scan
	 * @throws IOException
	 */
	private void closeScanThrowIOEx(final Scanner scan) throws IOException {
		scan.close();
		throw new IOException();
	}
    
    /**
     * Closes the scan and throw IOException.
     * 
     * @throws IOException the exception thrown.
     */
    private void checkHeader(Scanner scan, String header) throws IOException {
    	if(!scan.next().equals(header)) {	
    		closeScanThrowIOEx(scan);
    	}
    }
    
    public void saveProjects(final File projectsFile) throws IOException {
    	//TODO: save projects
    	FileWriter fileWriter = new FileWriter(projectsFile);
    	fileWriter.write(fileHeader + "\n");
    	fileWriter.write(fileProjectsSizeHeader + "" + "\n"); //TODO:
    	int projectSize = 0, materialsSize = 0;//TODO:
    	for (int i = 0; i < projectSize; i++) {//TODO:
    		fileWriter.write(fileNameHeader + "" + "\n");  	//TODO:
    		fileWriter.write(fileCostHeader + "" + "\n");//TODO:
    		fileWriter.write(fileDurationDayHeader + "" + "\n");//TODO:
    		fileWriter.write(fileDurationWeekHeader + "" + "\n");//TODO:
    		fileWriter.write(fileDurationMonthHeader + "" + "\n");//TODO:
    		fileWriter.write(fileEnergyEffHeader + "" + "\n");//TODO:
    		fileWriter.write(fileNotesHeader + "" + "\n");//TODO:
    		fileWriter.write(fileEndNotes + "\n");//TODO:
    		fileWriter.write(fileMaterialsSizeHeader + "" + "\n");//TODO:
    		for (int j = 0; j < materialsSize; j++) {//TODO:
    			fileWriter.write(fileMaterialHeader + "" + "\n");//TODO:
    		}
    	}
    	fileWriter.close();
    }

}
