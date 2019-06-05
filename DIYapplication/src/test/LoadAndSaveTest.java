package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Model;
import model.Energy;

/**
 * Test class for loading and saving
 * @author Ken Gil Romero
 * @version Spring 19
 */
class LoadAndSaveTest {
	
	/**
	 * model to be tested
	 */
	Model fm;

	/**
	 * Set up all fields for test cases 
	 * @throws java.lang.Exception
	 * @author Ken Gil Romero
	 */
	@BeforeEach
	void setUp() throws Exception {
		fm = new Model("firstName", "emailAddress");
	}

	/**
	 * Tests the loadProjects method when file is blank
	 * @author Ken Gil Romero
	 */
	@Test 
	void LoadTestErrorEmptyFile()  {
		assertThrows(IOException.class, () -> {
			fm.loadProjects(new File(""));
		});
	}
	
	/**
	 * Tests the loadProjects method
	 * @author Ken Gil Romero
	 */
	@Test 
	void LoadTestErrorWrongHeader()  {
		assertThrows(IOException.class, () -> {
			fm.loadProjects(new File("loadTestFileError.txt"));
		});
	}
	
	/**
	 * Tests the loadProjects method expect
	 * @author Ken Gil Romero
	 */
	@Test
	void LoadTest() {
		File file = new File("loadTestFile.txt");
		try {
			fm.loadProjects(file);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		assertEquals("AAAA", fm.getFirstName(), "first name wrong");
		assertEquals("BBBBB", fm.getEmailAddress(), "email address wrong");
		assertEquals("P 1", fm.getProjectList().getProjectList().get(0).getMyName(), "project name wrong");
		assertEquals(1 , fm.getProjectList().getProjectList().get(0).getMyCost(), "cost wrong");
		assertEquals(1 , fm.getProjectList().getProjectList().get(0).getMyDays(), "days wrong");
		assertEquals(Energy.LOW, fm.getProjectList().getProjectList().get(0).getMyEnergy(), "energy wrong");
		assertEquals("", fm.getProjectList().getProjectList().get(0).getMyNotes(), "notes wrong");
		assertEquals(0, fm.getProjectList().getProjectList().get(0).getMyMaterials().getMaterialMap().size()
				, "material wrong");
		assertEquals(2, fm.getProjectList().getProjectList().get(1).getMyMaterials().getMaterialMap().size()
				, "material wrong");
		assertEquals(100.0, fm.getProjectList().getProjectList().get(1).getMyMaterials().getMaterialMap().get("M 2")
				, "material wrong");
		assertEquals("a a\nb b b\nc c c c\n", fm.getProjectList().getProjectList().get(1).getMyNotes(), "notes wrong");
	}
	
	/**
	 * Tests the saveProjects method
	 * @throws FileNotFoundException 
	 * @author Ken Gil Romero
	 */
	@Test
	void SaveTest() throws FileNotFoundException {
		File file = new File("loadTestFile.txt");
		File file2 = new File("loadTestFile2.txt");
		try {
			fm.loadProjects(file);
			fm.saveProjects(file2);
		} catch (IOException e) {
			e.printStackTrace();
			assertFalse(true);
		}
		Scanner scan = new Scanner(file);
		Scanner scan2 = new Scanner(file2);
		while(scan.hasNext()) {
			assertEquals(scan.next(), scan2.next(), "file differ");
		}
		scan.close();
		scan2.close();
	}
}
