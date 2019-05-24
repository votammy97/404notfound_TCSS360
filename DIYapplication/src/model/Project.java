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
	private int myCost;
	/** Project materials. */
	private HashMap<String, Double> myMaterials;
	/** Project energy efficiency. */
	private byte myEnergy;
	/** Project notes. */
	private String myNotes;

	/**
	 * Create a project object. 
	 * 
	 * @param theName the name of the project. 
	 * @param theDays the days to complete project. 
	 * @param theCost the cost of the project. 
	 * @param theMaterials the materials of project. 
	 * @param theEnergy the energy efficiency of project. 
	 * @param theNotes the notes of the project. 
	 */
	public Project(final String theName, final int theDays, final int theCost,
			final HashMap<String, Double> theMaterials, final byte theEnergy, final String theNotes) {
		myName = theName;
		myDays = theDays;
		myCost = theCost;
		myMaterials = theMaterials;
		myEnergy = theEnergy;
		myNotes = theNotes;

	}
	
	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public int getMyDays() {
		return myDays;
	}

	public void setMyDays(int myDays) {
		this.myDays = myDays;
	}

	public int getMyCost() {
		return myCost;
	}

	public void setMyCost(int myCost) {
		this.myCost = myCost;
	}

	public byte getMyEnergy() {
		return myEnergy;
	}

	public void setMyEnergy(byte myEnergy) {
		this.myEnergy = myEnergy;
	}

	public String getMyNotes() {
		return myNotes;
	}

	public void setMyNotes(String myNotes) {
		this.myNotes = myNotes;
	}

	public HashMap<String, Double> getMyMaterials() {
		return myMaterials;
	}

}
