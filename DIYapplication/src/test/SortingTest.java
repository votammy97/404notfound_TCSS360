package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import model.Energy;
import model.Project;
import model.ProjectComparator;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SortingTest {

	private final Project a = new Project("A", 10, 10000.0, null, Energy.MEDIUM, "Notes A");
	private final Project a1 = new Project("A1", 10, 10000.0, null, Energy.MEDIUM, "Notes A1");
	private final Project a2 = new Project("A2", 10, 1000.0, null, Energy.MEDIUM, "Notes A2");
	private final Project b = new Project("B", 30, 60000.0, null, Energy.HIGH, "Notes B");
	private final Project b1 = new Project("B1", 30, 60000.0, null, Energy.HIGH, "Notes B1");
	private final Project b2 = new Project("B2", 3, 60000.0, null, Energy.HIGH, "Notes B2");
	private final Project c = new Project("C", 20, 50000.0, null, Energy.MEDIUM, "Notes C");
	private final Project c1 = new Project("C1", 20, 50000.0, null, Energy.MEDIUM, "Notes C1");
	private final Project c2 = new Project("C2", 20, 50000.0, null, Energy.LOW, "Notes C2");

	private ArrayList<Project> myProjects;

	@BeforeEach
	void setUp() {
		myProjects = new ArrayList<>();
		addProjects();
	}

	@Test
	@Order(1)
	void testSortByName() {
		myProjects.sort(ProjectComparator.sortByName());

		for (int i = 0; i < myProjects.size() - 1; i++) {
			assertTrue(myProjects.get(i).getMyName().compareTo(myProjects.get(i + 1).getMyName()) <= 0);
		}

		System.out.println("Sorting by name in alphabetical order...");
		myProjects.forEach(p -> System.out.println(p));
		System.out.println();
	}

	@Test
	@Order(2)
	void testSortByNameReversed() {
		myProjects.sort(ProjectComparator.sortByNameReversed());

		for (int i = 0; i < myProjects.size() - 1; i++) {
			assertTrue(myProjects.get(i).getMyName().compareTo(myProjects.get(i + 1).getMyName()) >= 0);
		}

		System.out.println("Sorting by name in reversed alphabetical order...");
		myProjects.forEach(p -> System.out.println(p));
		System.out.println();
	}

	@Test
	@Order(3)
	void testSortByCost() {
		myProjects.sort(ProjectComparator.sortByCost());

		for (int i = 0; i < myProjects.size() - 1; i++) {
			assertTrue(myProjects.get(i).getMyCost() <= myProjects.get(i + 1).getMyCost());
		}

		System.out.println("Sorting by cost in ascending order...");
		myProjects.forEach(p -> System.out.println(p));
		System.out.println();
	}

	@Test
	@Order(4)
	void testSortByCostReversed() {
		myProjects.sort(ProjectComparator.sortByCostReversed());

		for (int i = 0; i < myProjects.size() - 1; i++) {
			assertTrue(myProjects.get(i).getMyCost() >= myProjects.get(i + 1).getMyCost());
		}

		System.out.println("Sorting by cost in descending order...");
		myProjects.forEach(p -> System.out.println(p));
		System.out.println();
	}

	@Test
	@Order(5)
	void testSortByDuration() {
		myProjects.sort(ProjectComparator.sortByDuration());

		for (int i = 0; i < myProjects.size() - 1; i++) {
			assertTrue(myProjects.get(i).getMyDays() <= myProjects.get(i + 1).getMyDays());
		}

		System.out.println("Sorting by duration in ascending order...");
		myProjects.forEach(p -> System.out.println(p));
		System.out.println();
	}

	@Test
	@Order(6)
	void testSortByDurationReversed() {
		myProjects.sort(ProjectComparator.sortByDurationReversed());

		for (int i = 0; i < myProjects.size() - 1; i++) {
			assertTrue(myProjects.get(i).getMyDays() >= myProjects.get(i + 1).getMyDays());
		}

		System.out.println("Sorting by duration in descending order...");
		myProjects.forEach(p -> System.out.println(p));
		System.out.println();
	}

	@Test
	@Order(7)
	void testSortByEnergy() {
		myProjects.sort(ProjectComparator.sortByEnergy());

		for (int i = 0; i < myProjects.size() - 1; i++) {
			assertTrue(myProjects.get(i).getMyEnergy().compareTo(myProjects.get(i + 1).getMyEnergy()) <= 0);
		}

		System.out.println("Sorting by energy in normal order...");
		myProjects.forEach(p -> System.out.println(p));
		System.out.println();
	}

	@Test
	@Order(8)
	void testSortByEnergyReversed() {
		myProjects.sort(ProjectComparator.sortByEnergyReversed());

		for (int i = 0; i < myProjects.size() - 1; i++) {
			assertTrue(myProjects.get(i).getMyEnergy().compareTo(myProjects.get(i + 1).getMyEnergy()) >= 0);
		}

		System.out.println("Sorting by energy in reversed order...");
		myProjects.forEach(p -> System.out.println(p));
		System.out.println();
	}

	private void addProjects() {
		myProjects.add(a);
		myProjects.add(a1);
		myProjects.add(a2);

		myProjects.add(b);
		myProjects.add(b1);
		myProjects.add(b2);

		myProjects.add(c);
		myProjects.add(c1);
		myProjects.add(c2);
	}

}
