package desperatehousepi;

// Generic Item Class

public class Item {

	//Initialize variables
	private desperatehousepi.Commands.itemType item = null; //The name of the item
	private String stat = null; //The name of the stat that gets modified
	private int value = 0;  //The value added/subtracted from stat
	
	/**********************************
	 * A generic item class containing information about an item and the stats that it affects
	 * @author Luke and Mark
	 *********************************/

	//Constructor
	Item( desperatehousepi.Commands.itemType n, String s, int val ){
		item = n;
		stat = s;
		value = val;
	}
		
	public String getName(){ return this.item.name(); }
	public String getStat(){ return this.stat; }
	public int getValue(){ return this.value; }
	
	public void print(){
		System.out.println(item.name() + " -> " + stat + " +" + value);
	}	
}
