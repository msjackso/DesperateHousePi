package desperatehousepi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

// Generic Person Class

public class Person {
	
	//Set constants
	private static final int millSecsInDay = 1000*60*60*24;
	private static final int millSecsInHour = 1000*60*60;
	
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
		new Timer(millSecsInDay,ageMe).start();
		new Timer(millSecsInHour, hungerMe).start();
	}
	
	//Create a timer for the aging process
	private ActionListener ageMe = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			age+=1;
      	}
	};
		
	//Create a timer for the aging process
	private ActionListener hungerMe = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			if(hunger<100) hunger+=1;
      	}
	};
}
