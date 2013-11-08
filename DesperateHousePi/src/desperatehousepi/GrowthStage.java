package desperatehousepi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

// Class each growth stage

public class GrowthStage {
	
	//Initialize variables
	private String growthStage; //The name of this growth stage
	private int maxAge; //The age at which this growth stage will end
	
	/**********************************
	 * An age class containing information about the crust's growth stage and the crust's progress in altering its personality.
	 * @author Luke
	 *********************************/
	
	public GrowthStage(String stageName, int ageCap){
		growthStage = stageName;
		maxAge = ageCap;
	}
	
	////////////////////////Access Functions\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	//Returns the current growth stage of the crust
	String getGrowthStage(){ return growthStage; }
	
	//Returns the age at which this growth stage ends
	int getMaxAge() { return maxAge; }
	
}
	

