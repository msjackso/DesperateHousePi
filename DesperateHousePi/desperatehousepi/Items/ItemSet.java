package desperatehousepi.Items;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class ItemSet {
	/**********************************
	 * An item container class that handles all item interaction.
	 * All items are listed in the enum itemType.
	 * Each item's details are defined in the constructor below.
	 * @author Mark and Luke
	 *********************************/
	//Available items
	public static enum itemType{
		//Consumables
		APPLE("APPLE"), RASBERRY("RASBERRY"), FISH("FISH"), 
		//Energy-related
		BED("BED"), COFFEE("COFFEE"), 
		//Entertainment-related
		TV("TV"), BALL("BALL"),
		
		//Quest 1 Items
		GLASS("GLASS"), 
		LID("LID"), JAR("JAR"), SIGNATURE("SIGNATURE"),
		//Quest 2 Items
		RECIPIE("RECIPIE"),
		FLOUR("FLOUR"), SALT("SALT"), SUGAR("SUGAR"), BUTTER("BUTTER"), WATER("WATER"), 
		ROLLINGPIN("ROLLINGPIN"), PAN("PAN");
		
		
		public String name;
		itemType(String n){
			name = n;
		}
	}
	
	public EnumMap<itemType,Item> encyclopedia = new EnumMap<itemType,Item>(itemType.class);
	
	public ItemSet(){
		//Initialize Item Definitions
		Map<String, Integer> stats = new HashMap<String, Integer>();
		
		//APPLE
		stats.clear();
		stats.put("Hunger", 10);
		encyclopedia.put(itemType.APPLE, new Item( itemType.APPLE, stats ));
		
		//RASBERRY
		stats.clear();
		stats.put("Hunger", 25);
		encyclopedia.put(itemType.RASBERRY, new Item( itemType.RASBERRY, stats ));
		
		//FISH
		stats.clear();
		stats.put("Hunger", 25);
		encyclopedia.put(itemType.FISH, new Item( itemType.FISH, stats ));
		
		//BED
		stats.clear();
		stats.put("Energy", 40);
		encyclopedia.put(itemType.BED, new Item( itemType.BED, stats ));
		
		//COFFEE
		stats.clear();
		stats.put("Hunger", 5);
		stats.put("Energy", 30);
		encyclopedia.put(itemType.COFFEE, new Item( itemType.COFFEE, stats ));
		
		//TV
		stats.clear();
		stats.put("Entertainment", 30);
		encyclopedia.put(itemType.TV, new Item( itemType.TV, stats ));
		
		//BALL
		stats.clear();
		stats.put("Entertainment", 15);
		encyclopedia.put(itemType.BALL, new Item( itemType.BALL, stats ));
	
		//GLASS
		stats.clear();
		stats.put("Quest", 1);
		encyclopedia.put(itemType.GLASS, new Item( itemType.GLASS, stats ));
		
		//JAR
		stats.clear();
		stats.put("Quest", 20);
		encyclopedia.put(itemType.JAR, new Item( itemType.JAR, stats ));
		//LID
		stats.clear();
		stats.put("Quest", 20);
		encyclopedia.put(itemType.LID, new Item( itemType.LID, stats ));
		//SIGNATURE
		stats.clear();
		stats.put("Quest", 10);
		encyclopedia.put(itemType.SIGNATURE, new Item( itemType.SIGNATURE, stats ));

		//RECIPIE
		stats.clear();
		stats.put("Quest", 10);
		encyclopedia.put(itemType.RECIPIE, new Item( itemType.RECIPIE, stats ));

		//FLOUR
		encyclopedia.put(itemType.FLOUR, new Item( itemType.FLOUR, stats ));
		//SALT
		encyclopedia.put(itemType.SALT, new Item( itemType.SALT, stats ));
		//SUGAR
		encyclopedia.put(itemType.SUGAR, new Item( itemType.SUGAR, stats ));
		//BUTTER
		encyclopedia.put(itemType.BUTTER, new Item( itemType.BUTTER, stats ));
		//WATER
		encyclopedia.put(itemType.WATER, new Item( itemType.WATER, stats ));
		//ROLLINGPIN
		encyclopedia.put(itemType.ROLLINGPIN, new Item( itemType.ROLLINGPIN, stats ));
		//PAN
		encyclopedia.put(itemType.PAN, new Item( itemType.PAN, stats ));	
	}
	
	// Generic Item inner class
	public static class Item {
		/**********************************
		 * A generic-item inner class containing information about an item and 
		 * the needs that it affects
		 * @author Mark and Luke
		 *********************************/

		//Initialize variables
		public itemType item = null; //The name of the item
		private Map<String, Integer> myStats = new HashMap<String, Integer>(); //Stat container
		public boolean alive = false;	//Exists?
		
		//Constructor
		Item( itemType name, Map<String, Integer> stats ){
			item = name;
			myStats.putAll(stats);
		}
		
		//Returns String array of all needs that this item affects
		public String[] getNeeds(){ 
			return (String[])( myStats.keySet().toArray( new String[myStats.size()] ) ); 
		}
		
		//Returns how much this item changes the specified need
		public int getValue(String need){ 
			if( myStats.containsKey(need) )
				return myStats.get(need);
			else
				return -1;
		}
		
		//Prints item name and all the details
		public void print(){
			System.out.println(this.item);
			for( Map.Entry<String, Integer> entry : myStats.entrySet() )
				System.out.println(" -> " + entry.getKey()+" +" + entry.getValue());
		}	
	}

	////////////////////////Access Functions\\\\\\\\\\\\\\\\\\\\\\\\\\\
	/***************************************
	 * returns an Item object, given its enum name.
	 * @author Mark
	 ***************************************/
	public Item getItem( itemType itemName ){
		return encyclopedia.get(itemName);
	}
	
	/***************************************
	 * returns true if object currently exists.
	 * @author Mark
	 ***************************************/
	public boolean has( itemType itemName ){
		return( getItem(itemName).alive );
	}
	
	/***************************************
	 * returns a string containing every item object available.
	 * @author Mark
	 ***************************************/
	public String toString(){
		String out = "";
		for (itemType item : itemType.values() )
			out += item.name() + " ";
		return out;
	}
	
	///////////////////////Manipulation Functions\\\\\\\\\\\\\\\\\\\\\\\
	/***************************************
	 * Mark the specified item to be in existence
	 * @author Mark
	 ***************************************/
	public void create( itemType itemName ){
		if( getItem(itemName).alive)
			return;
		else
			getItem(itemName).alive = true;
	}
	
	/***************************************
	 * Mark the specified item to NOT be in existence
	 * @author Mark
	 ***************************************/
	public void destroy( itemType itemName ){
		if( getItem(itemName).alive )
			getItem(itemName).alive = false;
		else
			System.out.println("No such item exists");
	}
}
