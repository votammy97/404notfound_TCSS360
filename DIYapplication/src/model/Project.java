package model;

import java.util.HashMap;

/**
 * Class for project info.
 * 
 * @author Tammy Vo
 * @version May 22, 2019
 *
 */
public class Project {

	/** Project name. */
	private String myName;
	/** Project days. */
	private int myDays;
	/** Project cost. */
	private double myCost;
	/** Project materials. */
	private HashMap<String, Double> myMaterials;
	/** Project energy efficiency. */
	private Energy myEnergy;
	/** Project notes. */
	private String myNotes;

	/**
	 * Default constructor.
	 */
	public Project() {
		this("", 0, 0, new HashMap<String, Double>(), Energy.LOW, "");
	}

	/**
	 * Create a project object.
	 * 
	 * @param theName      the name of the project.
	 * @param theDays      the days to complete project.
	 * @param theCost      the cost of the project.
	 * @param theMaterials the materials of project.
	 * @param theEnergy    the energy efficiency of project.
	 * @param theNotes     the notes of the project.
	 */
	public Project(final String theName, final int theDays, final double theCost,
			final HashMap<String, Double> theMaterials, final Energy theEnergy, final String theNotes) {
		myName = theName;
		myDays = theDays;
		myCost = theCost;
		myMaterials = theMaterials;
		myEnergy = theEnergy;
		myNotes = theNotes;

	}

	/**
	 * Get project name.
	 * 
	 * @return project name.
	 */
	public String getMyName() {
		return myName;
	}

	/**
	 * Set project name.
	 * 
	 * @param myName project name.
	 */
	public void setMyName(final String myName) {
		this.myName = myName;
	}

	/**
	 * Get project days.
	 * 
	 * @return project days.
	 */
	public int getMyDays() {
		return myDays;
	}

	/**
	 * Set project days.
	 * 
	 * @param myDays project days.
	 */
	public void setMyDays(final int myDays) {
		this.myDays = myDays;
	}

	/**
	 * Get project cost.
	 * 
	 * @return project cost.
	 */
	public double getMyCost() {
		return myCost;
	}

	/**
	 * Set project cost.
	 * 
	 * @param myCost project cost.
	 */
	public void setMyCost(final double myCost) {
		this.myCost = myCost;
	}

	/**
	 * Get energy efficiency.
	 * 
	 * @return LOW, MED, or HIGH.
	 */
	public Energy getMyEnergy() {
		return myEnergy;
	}

	/**
	 * Set energy efficiency.
	 * 
	 * @param myEnergy project energy efficiency.
	 */
	public void setMyEnergy(final Energy myEnergy) {
		this.myEnergy = myEnergy;
	}

	/**
	 * Get project notes.
	 * 
	 * @return project notes.
	 */
	public String getMyNotes() {
		return myNotes;
	}

	/**
	 * Set project notes.
	 * 
	 * @param myNotes project notes.
	 */
	public void setMyNotes(final String myNotes) {
		this.myNotes = myNotes;
	}

	/**
	 * Get materials.
	 * 
	 * @return materials.
	 */
	public HashMap<String, Double> getMyMaterials() {
		return myMaterials;
	}

}
