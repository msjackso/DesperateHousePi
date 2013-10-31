package desperatehousepi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.Timer;

// Generic Person Class

public class Person {
	
	//Set constants
	private static final int millSecsInDay = 1000*60*60*24;
	private static final int hungerDecreaseRate = 1000*4; //loses 1 hunger every 4 minutes
	private static final int energyDecreaseRate = 1000*15; //loses 1 energy every 15 minutes
	private static final int entertainmentDecreateRate = 1000*10; //loses 1 entertainment every 10 minutes
	
	//Initialize variables
	String first_name = "John";
	String middle_name = "Jacob";
	String last_name = "Smith";
	int age = 0;
	
	protected LinkedList<Need> Needs = new LinkedList<Need>(); //the person's set of needs
	
	/**********************************
	 * A generic person class containing general traits to be inherited
	 * @author Anthony and Michael
	 * Edited 10/17/13 by Luke
	 *********************************/
	public Person(){
		//starts the age timer
		new Timer(millSecsInDay, ageMe).start();
		//creates the persons
		Needs.add(new Need("Hunger", hungerDecreaseRate));
		Needs.add(new Need("Energy", energyDecreaseRate));
		Needs.add(new Need("Entertainment", entertainmentDecreateRate));
	}
	
	//Create a timer for the aging process
	private ActionListener ageMe = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			age+=1;
      	}
	};
	
	////////////////////////Access Functions\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	//Returns the age of the person
	public int getAge(){ 
		return age; 
	}
	
	/* Increases the hunger level of the person
	 * Input: the name of the need to be checked.
	 * Output: the new value for the need. If the need is not found in needs.
	 */ 
	public int getNeed(String need_name){ 
		
		//Finds the need in the list of needs, then increments it.
		for(Need n : Needs) {
			if ( n.getNeedName()==need_name ) {
				return n.getNeedLevel();
			}; 
		}
		
		//If need is not defined.
		System.out.println("Fatal error. Need " + need_name + " not defined.");
		System.exit(0);
		return 0;
		
	}
	
	///////////////////////Manipulation Functions\\\\\\\\\\\\\\\\\\\\\\\
	
	/* Increases the hunger level of the person
	 * Input: the number that hunger will be incremented by
	 */
	/*********************************
	 * Edited 10/18/13 by Mark
	 *********************************/
	public void incrementNeed(String need_name, int amount) {
		for(Need n : Needs){
			if ( n.getNeedName()==need_name ) {
				n.incrementNeed(amount);
				return;
			}
		}
		//If need is not defined.
		System.out.println("Fatal error. Need '" + need_name + "' not defined.");
		System.exit(0);
	}
}
