package model;

import java.util.Comparator;

/**
 * A class that provides different comparators to compare a Project by either
 * its cost, duration or energy efficiency.
 * 
 * @author Matthew Chan
 */
public class ProjectComparator {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private ProjectComparator() {
	}

	/**
	 * Sorts the project list by cost value.
	 * 
	 * @return a cost comparator
	 */
	public static Comparator<Project> getCostComparator() {
		return Comparator.comparing(Project::getMyCost).thenComparing(Project::getMyName);
	}

	/**
	 * Sorts the project list by duration value.
	 * 
	 * @return a duration comparator
	 */
	public static Comparator<Project> getDurationComparator() {
		return Comparator.comparing(Project::getMyDays).thenComparing(Project::getMyName);
	}

	/**
	 * Sorts the project list by energy efficiency.
	 * 
	 * @return an energy efficiency comparator
	 */
	public static Comparator<Project> getEnergyComparator() {
		return Comparator.comparing(Project::getMyEnergy).thenComparing(Project::getMyName);
	}

}
