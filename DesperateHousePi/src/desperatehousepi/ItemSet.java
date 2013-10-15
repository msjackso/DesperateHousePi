package desperatehousepi;

public class ItemSet {
	/**********************************
	 * A item container class that handles all item interaction
	 * @author Mark and Luke
	 *********************************/
	//Initialize items
	private Item apple, rasberry, bed, coffee, tv, ball;
	
	//Access functions
	public Item getItem( desperatehousepi.Commands.itemType itemName ){
		switch (itemName){
			case APPLE: return apple;
			case RASBERRY: return rasberry;
			case BED: return bed;
			case COFFEE: return coffee;
			case TV: return tv;
			case BALL: return ball;
		}
		return null;
	}
	
	public boolean doWeHave( desperatehousepi.Commands.itemType itemName ){
		return( getItem(itemName)!=null );
	}
	
	public void printSet(){
		for (desperatehousepi.Commands.itemType item : desperatehousepi.Commands.itemType.values() ){
			if( getItem(item)!=null )
				getItem(item).print();
		}
	}
	
	public void print( desperatehousepi.Commands.itemType item ){
		if( getItem(item)==null )
			System.out.println("Item does not exist");
		else
			getItem(item).print();
	}
	
	public String toString(){
		String out = "";
		for (desperatehousepi.Commands.itemType item : desperatehousepi.Commands.itemType.values() )
			out += item.name() + " ";
		return out;
	}
	
	//Manipulation functions
	public void create( desperatehousepi.Commands.itemType itemName ){
		switch (itemName){
			case APPLE:
				if( apple==null )
					apple = new Item( itemName, "Hunger", 10);
				break;
			case RASBERRY:
				if( rasberry==null )
					rasberry = new Item( itemName, "Hunger", 15);
				break;
			case BED:
				if( bed==null )
					bed = new Item( itemName, "Energy", 40);
				break;
			case COFFEE:
				if( coffee==null )
					coffee = new Item( itemName, "Energy", 30);
				break;
			case TV:
				if( tv==null )
					tv = new Item( itemName, "Entertainment", 30);
				break;
			case BALL:
				if( ball==null )
					ball = new Item( itemName, "Entertainment", 15);
				break;
			default:
				System.out.println("Default create itemset.java case");
		}	
	}
	
	public void destroy( desperatehousepi.Commands.itemType itemName ){
		if( getItem(itemName)==null )
			System.out.println("No such item exists");
		else{
			switch (itemName){
				case APPLE: apple=null; break;
				case RASBERRY: rasberry=null; break;
				case BED: bed=null; break;
				case COFFEE: coffee=null; break;
				case TV: tv=null; break;
				case BALL: ball=null; break;
				default:
					System.out.println("Default delete itemset.java case");
			}
		}
	}
}
