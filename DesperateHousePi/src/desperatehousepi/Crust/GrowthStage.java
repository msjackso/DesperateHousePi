package desperatehousepi.Crust;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.*;

import javax.swing.Timer;

// Class each growth stage

public class GrowthStage {
	
	//Initialize variables
	private String growthStage; //The name of this growth stage
	private int numInteractions; //The number of interactions this level
	private int[] posTraits = new int [16]; //The number of positive encounters with crusts with highly positive traits this level
	private int[] negTraits = new int [16]; //The number of positive encounters with crusts with highly negative traits this level
	
	/**********************************
	 * An age class containing information about the crust's growth stage and the crust's progress in altering its personality.
	 * @author Luke
	 *********************************/
	
	public GrowthStage(String stageName){
		growthStage = stageName;
	}
	
	////////////////////////Access Functions\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	//Returns the current growth stage of the crust
	String getGrowthStage(){ return growthStage; }

	///////////////////////Manipulation Functions\\\\\\\\\\\\\\\\\\\\\

	void alterTraits() {
		int[] newTraitVals = new int [16];
		int[] sums = new int [16];
		int[] percentages = new int [16];
		int totalTraitVals = 0;
		
		for (int i = 0; i < 16; i++) {
			newTraitVals[i] = posTraits[i] - negTraits[i];
			totalTraitVals += Math.abs(newTraitVals[i]);
		}
		
		for (int i = 0; i < 16; i++) {
			percentages[i] = newTraitVals[i]/totalTraitVals * 100;
		}
		
		if (numInteractions <= 25) {
			
		}
		
		else {
			
		}
		
	}

}	

