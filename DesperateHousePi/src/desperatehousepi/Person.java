package desperatehousepi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

// Generic Person Class

public class Person {
	
	
	
	//Set constants
	private static final int millSecsInDay = 1000*60*60*24;
	//private static final int millSecsInHour = 1000*60*60;
	private static final int hungerMeter = 1000*4; //loses 1 hunger every 4 minutes
	private static final int energyMeter = 1000*15; //loses 1 energy every 15 minutes
	private static final int entertainmentMeter = 1000*10; //loses 1 entertainment every 10 minutes
	
	//Initialize variables
	String first_name = "John";
	String middle_name = "Jacob";
	String last_name = "Smith";

	int age = 0;
	int hunger = 50; //Hunger meter; 0 = starving; 100 = full; default value = 50
	int energy = 50; //Energy meter; 0 = tired; 100 = wide awake; default value = 50
	int entertainment = 50; //Energy meter; 0 = bored; 100 = entertained; default value = 50
	
	/**********************************
	 * A generic person class containing general traits to be inherited
	 * @author Anthony and Michael
	 *********************************/
	public Person(){
		new Timer(millSecsInDay, ageMe).start();
		new Timer(hungerMeter, hungerMe).start();
		new Timer(energyMeter, energyMe).start();
		new Timer(entertainmentMeter, entertainmentMe).start();
	}
	
	//Create a timer for the aging process
	private ActionListener ageMe = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			age+=1;
      	}
	};
	
	//Create a timer for the hunger meter
	private ActionListener hungerMe = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			if(hunger>0) hunger-=1;
      	}
	};
		
	//Create a timer for the energy meter
	private ActionListener energyMe = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			if(hunger>0) energy-=1;
      	}
	};
	
	//Create a timer for the entertainment meter
	private ActionListener entertainmentMe = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			if(entertainment>0) entertainment-=1;
      	}
	};
	
	////////////////////////Access Functions\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	//Returns the age of the person
	int getAge(){ return age; }
	
	//Returns the hunger level of the person
	int getHunger(){ return hunger; }
	
	//Returns the energy level of the person
	int getEnergy() { return energy; }
	
	//Returns the entertainment level of the person
	int getEntertainment() { return entertainment; }
	
	///////////////////////Manipulation Functions\\\\\\\\\\\\\\\\\\\\\\\
	
	/* Increases the hunger level of the person
	 * Input: the number that hunger will be incremented by
	 */
	void incrementHunger(int amount) {
		if (hunger + amount > 100) 
			hunger = 100;
		else 
			hunger += amount;
	}
	
	/* Increases the energy level of the person
	 * Input: the number that energy will be incremented by
	 */
	void incrementEnergy(int amount) {
		if (energy + amount > 100) 
			energy = 100;
		else 
			energy += amount;
	}
	
	/* Increases the entertainment level of the person
	 * Input: the number that entertainment will be incremented by
	 */
	void incrementEntertainment(int amount) {
		if (entertainment + amount > 100) 
			entertainment = 100;
		else 
			entertainment += amount;
	}
	
}
