package desperatehousepi;

import java.util.StringTokenizer;

public class Commands {
	
	//Declare variables
	private static Crust crust;
	private static Item apple, rasberry, bed, coffee, tv, ball;
	private static ActionLog history = new ActionLog();
	
	//Item itemSet = new Item();
	
	//Create objects that commands can alter
	private static enum objectType{
		CRUST, ITEM
	}
	
	//Create items that crust objects may interact with
	private static enum itemType{
		APPLE, RASBERRY, BED, COFFEE, TV, BALL;
	}
	
	/***************************************
	 * Helper function that retrieves Item object specified by string name
	 * or deletes it with flag 'x'
	 * If new items are wanted, their arguments must be defined in create(),
	 * they must be added to this function, the enum, and also declared.
	 * @author Mark and Luke
	 ***************************************/
	private static Item getItem( itemType name, char delete ){
		switch (name){
			//The following items may be consumed
			case APPLE:
				if( delete=='x' )apple = null;
				if( apple!=null )return apple; break;
			case RASBERRY:
				if( delete=='x' )rasberry = null;
				if( rasberry!=null )return rasberry; break;
				
			//The following items may NOT be consumed
			case BED: 
				if( delete=='x' )bed = null;
				if( bed!=null )return bed; break;
			case COFFEE: 
				if( delete=='x' )coffee = null;
				if( coffee!=null )return coffee; break;
			case TV: 
				if( delete=='x' )tv = null;
				if( tv!=null )return tv; break;
			case BALL: 
				if( delete=='x' )ball = null;
				if( ball!=null )return ball; break;
			default: System.out.println("Invalid item");
		}
		return null;
	}
	private static Item getItem( itemType name ){
		return getItem(name, 'o'); //Neccessary so that the 2nd parameter is optional
	}
	
	/***************************************
	 * Holds all of the executables for each command that can be called
	 * @author Anthony and Michael
	 ***************************************/
	public Commands(Crust new_crust){
		crust = new_crust;
	}
	
	/***************************************
	 * Saves an object to file to be imported from later
	 * @param tkn - A string tokenizer containing the rest of the save command
	 * @author Michael
	 ***************************************/
	public void save(StringTokenizer tkn){
		
		//Try to save the object
		try{
			
			//Grab the name of the object to be saved
			String obj = tkn.nextToken();
			
			//Find the object that is to be saved
			switch(objectType.valueOf(obj.toUpperCase())){
				
				//If saving the crust
				case CRUST:
					if(tkn.hasMoreTokens())
						crust.save(tkn.nextToken());
					else
						System.out.println("Invalid command.\nUsage: save [object] [profile name]");
					break;
				
				//Otherwise object is not meant to be saved
				default:
					System.out.println("Invalid command, given object can not be created. Type 'help save'");
					break;
			}
		
		//Object not in list or invalid command
		}catch(Exception e){
			System.out.println("Invalid command.\nUsage: save [object] [profile name]");
		}
		
	}
	
	/***************************************
	 * Loads an object from a file \
	 * @param tkn - A string tokenizer containing the rest of the save command
	 * @author Anthony and Michael
	 ***************************************/
	public void load(StringTokenizer tkn){
		
		try{	
			
			//Grab the name of the object to be loaded
			String obj = tkn.nextToken();
			
			//Value to check if load works correctly
			int loadVal = 0;
			
			//Find the object that is to be loaded
			switch(objectType.valueOf(obj.toUpperCase())){
			
				//If Loading the crust
				case CRUST:
					if(tkn.hasMoreTokens()){
						
						//run load function and store success variable in loadVal
						loadVal = crust.load(tkn.nextToken());
						
						//check that file exists and is in correct format; if not print useage message
						if(loadVal == 1){
							System.out.println("Invalid command.\nCrust not found.");
						}else if(loadVal == 2){
							System.out.println("Invalid command.\nBad file format.");
						}
					}else{
						System.out.println("Invalid command.\nUsage: load [object] [profile name]");
					}break;
				
				//Otherwise object is not meant to be loaded
				default:
					System.out.println("Invalid command, given object can not be loaded. Type 'help load'");
					break;
			}
		
		//Object not in list or invalid command
		}catch(Exception e){
			System.out.println("Invalid command.\nUsage: load [object] [profile name]");
		}
		
	}
	
	/***************************************
	 * Destroys an object and frees the memory
	 * @param tkn - A string tokenizer containing the rest of the destroy command
	 * @author Anthony and Michael
	 ***************************************/
	public void destroy(StringTokenizer tkn){
		
		//Try to destroy the object
		try{
			
			//Grab the name of the object to be destroyed
			String obj = tkn.nextToken();
			
			//Find the object that is to be destroyed
			switch(objectType.valueOf(obj.toUpperCase())){
				
				//If destroying the crust
				case CRUST:
					crust = null;
					break;
					
				//If destroying specified item
				case ITEM:
					if(tkn.hasMoreTokens()){
						//If the item exists
						itemType ourItem = itemType.valueOf(tkn.nextToken().toUpperCase());
						if( getItem(ourItem)!=null ){
							//Delete the item
							getItem(ourItem, 'x');
							history.logAction(ourItem.name() + " has been destroyed");
						}
						else
							System.out.println("No such item exists");
					}else
						System.out.println("Cannot delete all items at once");
					break;
					
				//Otherwise object is not meant to be destroyed
				default:
					System.out.println("Invalid command, given object can not be destroyed. Type 'help destroy'");
					break;
			}
		
		//Object not in list or invalid command
		}catch(Exception e){
			System.out.println("Invalid command.\nUsage:\tdestroy [object]\n\tdestroy item [item name]");
		}
		
	}
	
	/***************************************
	 * Prints out the information of an object
	 * @param tkn - A string tokenizer containing the rest of the print command
	 * @author Anthony and Michael
	 ***************************************/
	public void print(StringTokenizer tkn){
		
		//Try to print the object
		try{
			
			//Grab the name of the object to be printed
			String obj = tkn.nextToken();
			
			//Find the object that is to be manipulated
			switch(objectType.valueOf(obj.toUpperCase())){
				
				//If printing the crust
				case CRUST:
					if(crust!=null){
						crust.print();
						crust.printRelationships();
					}else
						System.out.println("No crust available or invalid command.\nUsage: print [object]");
					break;
				
				
				//If printing item
				case ITEM:
					//Is an item specified?
					if(tkn.hasMoreTokens()){
						getItem(itemType.valueOf(tkn.nextToken().toUpperCase())).print();
					}else{
						//Otherwise print all existing items
						for ( itemType item : itemType.values() ){
							if ( getItem(item)!=null )
								getItem(item).print();
						}
					}
					break;
						
					
				//Otherwise object is not meant to be printed
				default:
					System.out.println("Invalid command, given object can not be created. Type 'help print'");
					break;
			}
		
		//Object not in list or invalid command
		}catch(Exception e){
			System.out.println("Invalid command.\nUsage:\tprint [object]\n\tprint item [item name]?");
		}
		
	}
	
	/***************************************
	 * Creates a new object to be manipulated
	 * @param tkn - A string tokenizer containing the rest of the create command
	 * @author Anthony and Michael
	 ***************************************/
	public void create(StringTokenizer tkn){
		
		//Try to create the object
		try{
			
			//Grab the name of the object to be created
			String obj = tkn.nextToken();
			
			//Find the object that is to be manipulated
			switch(objectType.valueOf(obj.toUpperCase())){
				
				//If creating the crust
				case CRUST:
					crust = new Crust();
					break;
				
				case ITEM:
					if(tkn.hasMoreTokens()){
						itemType item = itemType.valueOf(tkn.nextToken().toUpperCase());
						switch(item){
							
							//This is where item stat definitions go
							case APPLE:
								apple = new Item("Apple", "Hunger", 10);
								history.logAction(item.name() + " has been created");
								break;
							
							case RASBERRY:
								rasberry = new Item("Rasberry", "Hunger", 15);
								history.logAction(item.name() + " has been created");
								break;
							
							case BED:
								bed = new Item("Bed", "Energy", 50);
								history.logAction(item.name() + " has been created");
								break;
							
							case COFFEE:
								coffee = new Item("Coffee", "Energy", 40);
								history.logAction(item.name() + " has been created");
								break;
								
							case TV:
								tv = new Item("TV", "Entertainment", 30);
								history.logAction(item.name() + " has been created");
								break;
							
							case BALL:
								ball = new Item("Ball", "Entertainment", 15);
								history.logAction(item.name() + " has been created");
								break;
						}
					}
					break;
					
				//Otherwise object is not meant to be created
				default:
					System.out.println("Invalid command, given object can not be created. Type 'help create'");
					break;
			}
		
		//Object not in list or invalid command
		}catch(Exception e){
			System.out.println("Invalid command.\nUsage:\tcreate [object]\n\tcreate item [item name]");
		}
	}
	
	/***************************************
	 * Sets a variable in an object
	 * @param tkn - A string tokenizer containing the rest of the set command
	 * @author Anthony and Michael
	 ***************************************/
	public void set(StringTokenizer tkn){
		
		//Try the list of the following objects
		try{
			
			//Grab the name of the object to be manipulated
			String obj = tkn.nextToken();
			
			//Find the object that is to be manipulated
			switch(objectType.valueOf(obj.toUpperCase())){
				
				//If setting the crust
				case CRUST:
					if(crust!=null && tkn.countTokens()>1)
						crust.set(tkn.nextToken(), tkn.nextToken());
					else
						System.out.println("Crust does not exist or invalid commmand.\nUsage: set [object] [variable] [value]");
					break;
				
				//Otherwise object is not meant to be manipulated
				default:
					System.out.println("Invalid command, given object can not be manipulated. Type 'help set'");
					break;
			}
		
		//Object not in list or not enough in the list
		}catch(Exception e){
			System.out.println("Invalid command.\nUsage: set [object] [variable] [value]");
		}
	}
	
	/***************************************
	 * Gets a variable in an object
	 * @param tkn - A string tokenizer containing the rest of the get command
	 * @author Anthony and Michael
	 ***************************************/
	public void get(StringTokenizer tkn){
		
		//Try the list of the following objects
		try{
			
			//Grab the name of the object to be retrieved
			String obj = tkn.nextToken();
			
			//Find the object that is to be retrieved
			switch(objectType.valueOf(obj.toUpperCase())){
				
				//If getting the crust
				case CRUST:
					if(crust!=null && tkn.hasMoreTokens())
						System.out.println("Value: "+crust.get(tkn.nextToken()));
					else
						System.out.println("Crust does not exist or invalid commmand.\nUsage: get [object] [variable]");
					break;
				
				//Otherwise object is not meant to be gotten
				default:
					System.out.println("Invalid command, given object can not be manipulated. Type 'help get'");
					break;
			}
		
		//Object not in list or not enough in the list
		}catch(Exception e){
			System.out.println("Invalid command.\nUsage: set [object] [variable]");
		}
	}
	
	/***************************************
	 * Lets your crust object eat an item object
	 * @param tkn - A string tokenizer containing the rest of the eat command
	 * @author Mark and Luke
	 ***************************************/
	public void eat(StringTokenizer tkn){
		
		try{
			
			//Grab the name of the item object
			String obj = tkn.nextToken();
			if( crust!=null ){
				itemType findThis = itemType.valueOf(obj.toUpperCase());
				//Find the item that is to be eaten
				for ( itemType search : itemType.values() ){
					if( search==findThis ){
						Item ourItem = getItem( search );
						//Check if item has been created yet
						if( ourItem!=null ){
							//Check if it is an item you can eat
							if( ourItem.getStat()=="Hunger" ){
								crust.incrementHunger( ourItem.getAmountChanged() );
								history.logAction("Crust has consumed: " + findThis.name() );
								System.out.println("New Hunger: " + crust.getHunger() );
								
								//Delete the item eaten
								getItem( search, 'x' );
							}else
								history.logAction("You can't eat: " + ourItem.getName() );
						}else
							history.logAction(findThis.name() + " does not exist");
					}
				}
			}else
				System.out.println("No crust available. Try \"create crust\"");
		
		//Object not in list or not enough in the list
		}catch(Exception e){
				System.out.println("Invalid command or item does not exist. \nUsage: eat [item name]");
		}
	}
	
	/***************************************
	 * Lets your crust object use an item object
	 * @param tkn - A string tokenizer containing the rest of the eat command
	 * @author Mark and Luke
	 ***************************************/
	public void use(StringTokenizer tkn){
		
		try{
			
			//Grab the name of the item object
			String obj = tkn.nextToken();
			if( crust!=null ){
				itemType findThis = itemType.valueOf(obj.toUpperCase());
				//Find the item that is to be eaten
				for ( itemType search : itemType.values() ){
					if( search==findThis ){
						Item ourItem = getItem( search );
						//Check if item has been created yet
						if( ourItem!=null ){
							//Check if it is an item you can eat
							if( ourItem.getStat()=="Energy" ){
								crust.incrementEnergy( ourItem.getAmountChanged() );
								history.logAction("Crust has used: " + findThis.name() );
								System.out.println("New Energy: " + crust.getEnergy() );
							}else if( ourItem.getStat()=="Entertainment" ){
								crust.incrementEntertainment( ourItem.getAmountChanged() );
								history.logAction("Crust has used: " + findThis.name() );
								System.out.println("New Entertainment: " + crust.getEntertainment() );
							}else
								history.logAction("You can't use: " + ourItem.getName() );
						}else
							history.logAction(findThis.name() + " does not exist");
					}
				}
			}else
				System.out.println("No crust available. Try \"create crust\"");
		
		//Object not in list or not enough in the list
		}catch(Exception e){
				System.out.println("Invalid command or item does not exist. \nUsage: use [item name]");
		}
	}	
}


