package model;

import java.util.HashMap;

/**
 * Class for materials.
 * 
 * @author Tammy Vo
 */
public class Materials {

	/** The HashMap storing all materials needed. */
	private HashMap<String, Double> myMaterials;

	/** Private constructor. */
	public Materials() {
		myMaterials = new HashMap<>();
	}

	/**
	 * Adds the material.
	 * 
	 * @param theName of the material.
	 * @param theCost of the material.
	 */
	public void addMaterial(final String theName, final double theCost) {
		myMaterials.put(theName, theCost);
	}

	/**
	 * Returns the materials.
	 * 
	 * @return the materials.
	 */
	public HashMap<String, Double> getMaterialMap() {
		return myMaterials;
	}

}
