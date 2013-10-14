package desperatehousepi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import Integer;

// Generic Item Class

public class Item {
	
	//Initialize variables
	String item_name = null;
	String stat_improved = null; //The name of the stat that gets improved
	int improvement_amount = 0;  //The amount that the stat gets improved
	
	/**********************************
	 * A generic item class containing information about an item and the stats that it affects
	 * @author Luke and Mark
	 *********************************/

	//Constructor
	Item(String name, String stat, String amount){
		item_name = name;
		stat_improved = stat;
		improvement_amount = Integer.parseInt(amount);
	}
	
}
