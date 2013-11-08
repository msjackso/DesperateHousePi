package desperatehousepi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.ArrayList;

import javax.swing.Timer;

// Generic Person Class

public class Person {
	
	//Set constants
	private static final int millSecsInDay = 1000*60*60*24;
	private static final int millSecsInHour = 1000*60*60;
	private static final int hungerDecreaseRate = 1000*4; //loses 1 hunger every 4 minutes
	private static final int energyDecreaseRate = 1000*15; //loses 1 energy every 15 minutes
	private static final int entertainmentDecreateRate = 1000*10; //loses 1 entertainment every 10 minutes
	
	//Initialize variables
	String first_name = "John";
	String middle_name = "Jacob";
	String last_name = "Smith";
	private int age = 0; //Current age; default value = 0
	private int growthStageIndex = 0; //stores the index of the current growth stage
	
	protected LinkedList<Need> Needs = new LinkedList<Need>(); //the person's set of needs
	protected ArrayList<GrowthStage> GrowthStages = new LinkedList<GrowthStage>(); //the person's set of needs
	
	/**********************************
	 * A generic person class containing general traits to be inherited
	 * @author Anthony and Michael
	 * Edited 10/17/13 by Luke
	 *********************************/
	public Person(){
		//Creates the person's age
		new Timer(millSecsInDay, increase_age).start();
		//Creates the person's needs
		Needs.add(new Need("Hunger", hungerDecreaseRate));
		Needs.add(new Need("Energy", energyDecreaseRate));
		Needs.add(new Need("Entertainment", entertainmentDecreateRate));
		GrowthStages.add(new GrowthStage("Baby", 3));
		GrowthStages.add(new GrowthStage("Child", 12));
		GrowthStages.add(new GrowthStage("Teen", 18));
		GrowthStages.add(new GrowthStage("Adult", 50));
		GrowthStages.add(new GrowthStage("Elder", 100));
	}
	
	//Create a timer for the aging process
	private ActionListener increase_age = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			incrementAge();
			//If the crust's age is at the threshold for the next growth stage and not over 100, progresses it to the next stage
			if (getAge() == GrowthStages.get(growthStageIndex).getMaxAge() && !(getAge() >= 100)) {
				growthStageIndex++;
			}
      	}
	};
	
	////////////////////////Access Functions\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	/* Returns the level of the specified need
	 * Input: the name of the need to be checked.
	 * Output: the value for the need. If the need is not found in needs returns an error.
	 */ 
	int getNeed(String need_name){ 
		
		//Finds the need in the list of needs, then increments it.
		for(Need n : Needs) {
			if ( n.getNeedName()==need_name ) {
				return n.getNeedLevel();
			}; 
		}
		
		//If need is not defined, return an error.
		System.out.println("Fatal error. Need " + need_name + " not defined.");
		System.exit(0);
		return 0;
		
	}
	
	/* Returns the age of the crust
	 * Input: None
	 * Output: the crust's age
	 */ 
	int getAge(){ return age; }
	
	/* Returns the current string name of the growth stage of the crust
	 * Input: None
	 * Output: the crust's growth stage as a string
	 */ 
	String getGrowthStage() { return GrowthStages.get(growthStageIndex).getGrowthStage(); }
	
	/* Returns the current index of the crust's growth stage for saving and loading
	 * Input: None
	 * Output: the crust's growth stage as a string
	 */ 
	String getGrowthStageIndex() { return GrowthStages.get(growthStageIndex).getGrowthStage(); }
	
	///////////////////////Manipulation Functions\\\\\\\\\\\\\\\\\\\\\\\
	
	/* Increases the need level of the person
	 * Input: the number that the need will be incremented by
	 */
	/*********************************
	 * Edited 10/18/13 by Mark
	 *********************************/
	void incrementNeed(String need_name, int amount) {
		for(Need n : Needs){
			if ( n.getNeedName()==need_name ) {
				n.incrementNeed(amount);
				return;
			}
		}
		//If need is not defined, produce error.
		System.out.println("Fatal error. Need '" + need_name + "' not defined.");
		System.exit(0);
	}
	
	/* Increases the age of the person
	 * Input: the number that age will be incremented by
	 */
	void incrementAge() {
		if (age + 1 > 100) 
			return;
		else 
			age += 1;
	}
}
