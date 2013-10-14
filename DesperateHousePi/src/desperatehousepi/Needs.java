package desperatehousepi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

// Generic Person Class

public class Needs {
	
	//Set constants
	private static final int millSecsInDay = 1000*60*60*24;
	private static final int millSecsInHour = 1000*60*60;
	
	//Initialize variables
	private int hunger = 50; //Hunger meter; 0 = starving; 100 = full; default value = 50
	private int energy = 50; //Energy meter; 0 = tired; 100 = wide awake; default value = 50
	private int entertainment = 50; //Energy meter; 0 = bored; 100 = entertained; default value = 50
	
	/**********************************
	 * A class containing a set of needs that are to be used by 
	 * @author Luke and Mark
	 *********************************/
	public Needs(){
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
	
	//Create a timer for the aging process
	private ActionListener hungerMe = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			if(hunger<100) hunger+=1;
      	}
	};
}
