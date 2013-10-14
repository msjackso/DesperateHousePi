package desperatehousepi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import java.lang.Integer;

// Generic Item Class

public class Item {
	
	//Initialize variables
	private String name = null;
	private String stat = null; //The name of the stat that gets improved
	private int amountChanged = 0;  //The amount that the stat gets improved
	
	/**********************************
	 * A generic item class containing information about an item and the stats that it affects
	 * @author Luke and Mark
	 *********************************/

	//Constructor
	Item(String n, String s, int amount){
		name = n;
		stat = s;
		amountChanged = amount;
	}
		
	String getName(){ return this.name; }
	String getStat(){ return this.stat; }
	int getAmountChanged(){ return this.amountChanged; }
	
	void print(){
		System.out.println(name + " -> " + stat + " +" + amountChanged);
	}
	
}
