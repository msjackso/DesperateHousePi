package desperatehousepi;

import java.util.StringTokenizer;

public class Commands {
	
	//Declare variables
	private static Crust crust;
	private static ItemSet inventory = new ItemSet();
	private static ActionLog history = new ActionLog();
	
	//Create objects that commands can alter
	private static enum objectType{
		CRUST, ITEM
	}
	
	//Available items
	static enum itemType{
		APPLE, RASBERRY, BED, COFFEE, TV, BALL;
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
				/***************************************
				 * @author Mark - case ITEM            */
				case ITEM:
					if( !tkn.hasMoreTokens() )
						System.out.println("Invalid command.\nUsage: destroy item [item name]");
					else{
						itemType itemTkn = itemType.valueOf(tkn.nextToken().toUpperCase());
						inventory.destroy( itemTkn );
					}	
					break;
				 /**************************************/
					
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
				
				/***************************************
				 * @author Mark - case ITEM            */
				//If printing item
				case ITEM:
					if( !tkn.hasMoreTokens() )
						inventory.printSet();
					else{
						itemType itemTkn = itemType.valueOf(tkn.nextToken().toUpperCase());
						inventory.print( itemTkn );
					}
					break;
				/**************************************/
						
					
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
					
				//If creating an item
				/***************************************
				 * @author Mark - case ITEM            */
				case ITEM:
					if( !tkn.hasMoreTokens() ){
						System.out.println("Items Available: " + inventory.toString() );
						return;
					}else{
						//Grab name of specified item
						itemType itemTkn = itemType.valueOf(tkn.nextToken().toUpperCase());
						inventory.create(itemTkn);
					}
					break;
				/**************************************/
					
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
			//Check if crust exists
			if( crust==null ){
				System.out.println("No crust available.");
				return;
			}		
			
			//Grab the name of the object to be created
			itemType itemName = itemType.valueOf(tkn.nextToken().toUpperCase());
			Item food = inventory.getItem( itemName );
	
			//Check if food item exists
			if( !inventory.doWeHave(itemName) ){
				System.out.println("No " + itemName + " available");
				return;
			}
			//Check if food is actual Hunger-satisfying food
			if( food.getStat()!="Hunger" )
				System.out.println("You cannot eat "+food.getName());
			else{
				crust.incrementHunger( food.getValue() );
				inventory.destroy( itemName );
				history.logAction("Crust has eaten "+food.getName());
			}

		//Object not in list or invalid command
		}catch(Exception e){
			System.out.println("Invalid command.\nUsage: eat [item name]");
		}
	}
	
	/***************************************
	 * Lets your crust object use an item object
	 * @param tkn - A string tokenizer containing the rest of the eat command
	 * @author Mark and Luke
	 ***************************************/
	public void use(StringTokenizer tkn){

		try{
			//Check if crust exists
			if( crust==null ){
				System.out.println("No crust available.");
				return;
			}		
			
			//Grab the name of the object to be created
			itemType itemName = itemType.valueOf(tkn.nextToken().toUpperCase());
			Item item = inventory.getItem( itemName );
	
			//Check if object item exists
			if( !inventory.doWeHave(itemName) ){
				System.out.println("No " + itemName + " available");
				return;
			}
			//Check if item is NOT Hunger-satisfying food
			switch ( item.getStat() ){
				case "Hunger":
					System.out.println("You cannot use "+item.getName());
					break;
				case "Energy":
					crust.incrementEnergy( item.getValue() );
					history.logAction("Crust has used "+item.getName());
					break;
				case "Entertainment":
					crust.incrementEntertainment( item.getValue() );
					history.logAction("Crust has used "+item.getName());
					break;	
			}

		//Object not in list or invalid command
		}catch(Exception e){
			System.out.println("Invalid command.\nUsage: use [item name]");
		}
	}
}

