package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class DIYModel {
	
	private static final String fileHeader = "#DIY Projects";
	private static final String fileProjectsSizeHeader = "#Projects Size: ";
	private static final String fileNameHeader = "#Name: ";
	private static final String fileCostHeader = "#Cost: ";
	private static final String fileDurationHeader = "#Duration: ";
	private static final String fileEnergyEffHeader = "#Energy Efficiency: ";
	private static final String fileNotesHeader = "#Notes: ";
	private static final String fileMaterialSizeHeader = "#Material Size: ";
	private static final String fileMaterialHeader = "#Material: ";
	
	//TODO: add more headers for loading project and saving project
	
    public void loadProjects(final File projectsFile) throws IOException {
    	final Scanner scan = new Scanner(projectsFile);
    	//TODO: load projects
    	scan.close();
    }
    
    public void saveProjects(final File projectsFile) throws IOException {
    	//TODO: save projects
    	FileWriter fileWriter = new FileWriter(projectsFile);
    	
    	fileWriter.write(fileHeader);
    	fileWriter.write(fileProjectsSizeHeader + ""); 
    	
    	int projectSize = 0, materialsSize = 0;
    	for (int i = 0; i < projectSize; i++) {
    		fileWriter.write(fileNameHeader + "");  	
    		fileWriter.write(fileCostHeader + "");
    		fileWriter.write(fileDurationHeader + "");
    		fileWriter.write(fileEnergyEffHeader + "");
    		fileWriter.write(fileNotesHeader + "");
    		fileWriter.write(fileMaterialSizeHeader + "");
    		for (int j = 0; j < materialsSize; j++) {
    			fileWriter.write(fileMaterialHeader + "");
    		}
    	}
    }

}
