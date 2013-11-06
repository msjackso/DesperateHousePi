package desperatehousepi.Crust;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

// Generic Person Class

public class Need {
	
	//Initialize variables
	private String needName; //Name of the need, eg. hunger, sleep.
	private int needLevel = 50; //Current level of the need; 0 = unsatisfied; 100 = fully satisfied; default value = 50
	
	/**********************************
	 * A generic need class containing information about the need and functions to manipulate the level of the need
	 * @author Luke
	 *********************************/
	public Need(String name, int decrease_rate){
		needName  = name;
		new Timer(decrease_rate, decrease_level).start();
	}
	
	//Create a timer for the aging process
	private ActionListener decrease_level = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			decrementNeed(1);
      	}
	};
	
	////////////////////////Access Functions\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	//Returns the age of the person
	String getNeedName(){ return needName; }
	
	//Returns the age of the person
	int getNeedLevel(){ return needLevel; }
	
	///////////////////////Manipulation Functions\\\\\\\\\\\\\\\\\\\\\\\
	
	/* Increases the entertainment level of the person
	 * Input: the number that entertainment will be incremented by
	 */
	void incrementNeed(int amount) {
		if (needLevel + amount > 100) 
			needLevel = 100;
		else 
			needLevel += amount;
	}
	
	/* Increases the entertainment level of the person
	 * Input: the (POSITIVE) number that entertainment will be decremented by
	 */
	void decrementNeed(int amount) {
		if (needLevel - amount < 0) 
			needLevel = 0;
		else 
			needLevel -= amount;
	}
}
