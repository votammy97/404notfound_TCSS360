package model;

import java.util.HashMap;

/**
 * Class for materials. 
 * @author Tammy Vo
 *
 */
public class Material {
	
	private static HashMap<String, Double> myMaterials = new HashMap<>();
	
	/** Private constructor. */
	private Material(){

	}
	
	/**
	 * Adds the material. 
	 * 
	 * @param theName of the material. 
	 * @param theCost of the material. 
	 */
	public static void addMaterial (String theName, double theCost) {
		myMaterials.put(theName, theCost);
	}
	
	/**
	 * Returns the materials. 
	 * 
	 * @return the materials. 
	 */
	public static HashMap<String, Double> getMaterialMap(){
		return myMaterials;
	}
	
}
