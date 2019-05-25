/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.DIYFileManager;

/**
 * Test class for loading and saving
 * @author Ken Gil Romero
 * @version Spring 19
 */
class LoadAndSaveTest {
	
	DIYFileManager fm;

	/**
	 * Set up all fields for test cases 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		fm = new DIYFileManager();
	}

	/**
	 * Tests the loadProjects method
	 */
	@Test
	void LoadTest() {
		File file = new File("loadTestFile.txt");
		try {
			fm.loadProjects(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		assertEquals("AAAA", fm.userName, "first name wrong");
		assertEquals("BBBBB", fm.userEmailAddr, "email address wrong");
	}
	
	/**
	 * Tests the saveProjects method
	 */
	@Test
	void SaveTest() {
		File file = new File("saveTestFile.txt");
		try {
			fm.saveProjects(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertFalse(true);
		}
		assertEquals("<Name>", fm.userName, "first name wrong");
		assertEquals("<EmailAddress>", fm.userEmailAddr, "email address wrong");
	}
}
