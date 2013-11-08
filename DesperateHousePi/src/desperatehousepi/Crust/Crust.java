package desperatehousepi.Crust;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;

import desperatehousepi.Items.ItemSet;
import desperatehousepi.Items.ItemSet.itemType;

/******************************
 * A crust is a personality with which interactions can be made. Every value in the
 * crust object has a setter and getter which can be received using the set(trait, value)
 * or get(trait) function. You can also print out all of the items in the crust by
 * calling the print() function. Relationships are available but are not heavily
 * implemented yet. You can add relationships between a crust and another by calling
 * the addRelationship() function. If you need to see what relationships there are
 * the only way right now is to call printRelationships(). This empty constructor will
 * generate a personality randomly. Each trait is determined using the setRandomTrait()
 * function from the PTrait object. This will create the values based on a bell curve.
 * @author Anthony and Michael
 ******************************/
public class Crust extends Person {
	
	//Constant declarations
	public static final int UNKNOWN = -1000;
	public static final int OK = 0;
	public static final int FILE_NOT_FOUND = 1;
	public static final int FILE_BAD_FORMAT = 2;
	public static final int NO_ITEM_AVAILABLE = 1;
	public static final int ITEM_USED = 0;
	
	//Object Declarations
	private PTrait[] traits = new PTrait [16];
	public enum traitName{
		warmth(0), reasoning(1), emotionalStability(2), dominance(3), liveliness(4), ruleConsciousness(5), socialBoldness(6), sensitivity(7),
		vigilance(8), abstractedness(9), privateness(10), apprehensivness(11), opennessToChange(12), selfReliance(13), perfectionism(14), tension(15);
		
		public int index;
		traitName(int i){
			index = i;
		}
	}
	private LinkedList<Relationship> relationships = new LinkedList<Relationship>();
	private LinkedList<Interest> interests = new LinkedList<Interest>();
	public ItemSet inventory = new ItemSet();
	public ActionLog history = new ActionLog(this);
	public CrustAI crustAI;
	
	/******************************
	 * This empty constructor will generate a personality randomly. Each trait is determined
	 * using the setRandomTrait() function from the PTrait object. This will create the
	 * values based on a bell curve.
	 * @author Anthony and Michael
	 ******************************/
	public Crust(){
		for(int x = 0; x<16; x++){
			traits[x] = new PTrait(0);
			traits[x].setRandomTrait();
		}
		
		crustAI = new CrustAI(this);
	}
	
	/******************************
	 * Passing in any amount of strings will work for this constructor. It will set the
	 * strings to firstName, middleName and lastName respectively. If more than 3 strings
	 * are provided they will be ignored.
	 * @author Michael
	 ******************************/
	public Crust(String... names){
		
		//Try to set all of the names of the object
		try{ first_name=names[0]; }catch(Exception e){ }
		try{ middle_name=names[1]; }catch(Exception e){ }
		try{ last_name=names[2]; }catch(Exception e){ }
		
		for(int x = 0; x<16; x++){
			traits[x] = new PTrait(0);
			traits[x].setRandomTrait();
		}
		
		crustAI = new CrustAI(this);
	}
	
	/******************************
	 * Passing in any amount of integers will work for this constructor. It will set
	 * the integers to warmth, reasoning, emotionalStability, dominance, liveliness, ruleConsciousness,
	 * socialBoldness, sensitivity, vigilance, abstractedness, privateness, apprehensivness,
	 * opennessToChange, selfReliance, perfectionism and tension respectively. If more than
	 * 16 integers are provided they will be ignored.
	 * @author Michael
	 ******************************/
	public Crust(int... trait_val){
		
		//Get the length of the amount of values passed in
		int length = (trait_val.length>16) ? 16:trait_val.length;
		
		//Set all of the traits in the order that they were given if not -1000
		for(int x = 0; x<length; x++)
			if(trait_val[x]!=UNKNOWN){
				traits[x] = new PTrait(0);
				traits[x].setBase(trait_val[x]);
			}
		
		crustAI = new CrustAI(this);
	}
	
	/******************************
	 * Passing in any amount of integers will work for this constructor. It will set
	 * the integers to warmth, reasoning, emotionalStability, dominance, liveliness, ruleConsciousness,
	 * socialBoldness, sensitivity, vigilance, abstractedness, privateness, apprehensivness,
	 * opennessToChange, selfReliance, perfectionism and tension respectively. If more than
	 * 16 integers are provided they will be ignored. It will also set each name accordingly.
	 * This constructor is for creating an entire crust sans relationships.
	 * @author Michael
	 ******************************/
	public Crust(String firstName, String middleName, String lastName, int... trait_val){
		
		//Set names
		first_name = firstName;
		middle_name = middleName;
		last_name = lastName;
		
		//Get the length of the amount of values passed in
		int length = (trait_val.length>16) ? 16:trait_val.length;
		
		//Set all of the traits in the order that they were given if not -1000
		for(int x = 0; x<length; x++)
			if(trait_val[x]!=UNKNOWN){
				traits[x] = new PTrait(0);
				traits[x].setBase(trait_val[x]);
			}
		
		crustAI = new CrustAI(this);
	}
	
	/*******************************
	 * Establishes a connection to a cleverbot server and then initates a dialogue with
	 * the user. No linkage to personality though, just something to waste time. It will
	 * throw an exception if it cannot connect to the server and print such to the
	 * console.
	 * @author Michael
	 *******************************/
	public String chat(String statement){
		
		//Create a string for holding the reply
		String reply = "";
		
		//Try to establish a connection to the server
		try{
			
			//Create all of the chatter bot objects
			ChatterBotFactory chatFactBot = new ChatterBotFactory();
			ChatterBot chatBot = chatFactBot.create(ChatterBotType.CLEVERBOT);
			ChatterBotSession chatBotSess = chatBot.createSession();
			
			
				
			//Get the reply from the server and print it out
			reply = chatBotSess.think(statement);
		
		//If the server can't be connected to
		}catch(Exception e){
			System.out.println("Chatting not available.");
		}
		
		return reply;
	}
	
	/******************************
	 * Saves the crust to a file to be imported later. Is saved as a .crust file
	 * @param filename - The profile name it will be stored under
	 * @author Michael
	 * @throws IOException 
	 ******************************/
	public void save() throws IOException{
		
		//Open saveFile
		File saveFile = new File(get("fullName").replace(" ", "_")+".crust");
		
		//If file doesn't exist then create it
		if(!saveFile.exists())
			saveFile.createNewFile();
		
		//Open up the file and create the writers
		FileWriter fw = new FileWriter(saveFile.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		//Generate content
		String content = "";
		content+=first_name+" "+middle_name+" "+last_name+" ";
		content+=getFormattedTraits();
		/*********************************
		 * Edited 11/5/13 by Luke
		 *********************************/
		content+=getFormattedNeeds();
		
		bw.write(content);
		bw.close();
	}
	
	/******************************
	 * Loads the crust from a file to currently selected Crust.
	 * @param filename - The profile name of Crust to be Loaded
	 * @author Anthony and Michael
	 * @throws IOException 
	 * @return int: 0 success; 1 file not found; 2 bad file format
	 ******************************/
	public int load(String filename) throws IOException{
		
		//open loadFIle
		File loadFile = new File(filename);
		
		//Check to see if file to be loaded exists, if it doesn't, return 1 to signify
		//'file not found'
		if(!loadFile.exists())
			return FILE_NOT_FOUND;
		
		//Open the file and create readers
		FileReader fr = new FileReader(loadFile.getAbsolutePath());
		BufferedReader br = new BufferedReader(fr);
		
		//Tokenize the String for the given file
		StringTokenizer tkn = new StringTokenizer(br.readLine());
		
		//Try and run function to set the traits from the formatted file, if successful
		//return 0, otherwise return 2
		try{
			setFormattedTraits(tkn);
			br.close();
			return OK;
		}catch(Exception e){
			br.close();
			return FILE_BAD_FORMAT;
		}
	}
	
	/******************************
	 * Returns all of the traits in format for being printed to file
	 * @author Michael
	 ******************************/
	public String getFormattedTraits(){
		
		String allTraits = "";
		
		for(PTrait tr : traits){
			allTraits+=tr.getBase()+" "+tr.getMod()+" "+tr.getAdj()+" ";
		}
		
		return allTraits;
	}
	
	/******************************
	 * Returns all of the needs in format for being printed to file
	 * @author Luke
	 ******************************/
	public String getFormattedNeeds(){
		
		String allNeeds = "";
		
		for (Need n : Needs){
			allNeeds+=n.getNeedLevel()+" ";
		}
		
		return allNeeds;
	}
	
	/******************************
	 * Returns all of the traits for this crust
	 * @author Michael
	 ******************************/
	public PTrait[] getTraits(){ return traits; }
	
	/******************************
	 * Sets all of the traits from formatted file to this Crust
	 * @author Michael and Anthony
	 ******************************/
	public void setFormattedTraits(StringTokenizer tkn){
		
		first_name = tkn.nextToken();
		middle_name = tkn.nextToken();
		last_name = tkn.nextToken();
		
		for(PTrait tr : traits){
			tr.setBase(Integer.parseInt(tkn.nextToken()));
			tr.setMod(Integer.parseInt(tkn.nextToken()));
			tr.setAdj(Integer.parseInt(tkn.nextToken()));
		}
		
		/*********************************
		 * Edited 11/5/13 by Luke
		 *********************************/
		for (Need n : Needs){
			n.setNeed(Integer.parseInt(tkn.nextToken()));
		}
	}
	
	/******************************
	 * Prints out all of the variables held in the Crust besides the relationships.
	 * @author Anthony and Michael
	 ******************************/
	public void print(){
		System.out.println("Name: " + first_name+" "+middle_name+" "+last_name);
		System.out.println("Age: " + getAge());
		System.out.println("Personality:");
		System.out.println("\tWarmth = " + traits[traitName.warmth.index].getValue());
		System.out.println("\tReasoning = " + traits[traitName.reasoning.index].getValue());
		System.out.println("\tEmotional Stability = " + traits[traitName.emotionalStability.index].getValue());
		System.out.println("\tDominance = " + traits[traitName.dominance.index].getValue());
		System.out.println("\tLiveliness = " + traits[traitName.liveliness.index].getValue());
		System.out.println("\tRule Consciousness = " + traits[traitName.ruleConsciousness.index].getValue());
		System.out.println("\tSocial Boldness = " + traits[traitName.socialBoldness.index].getValue());
		System.out.println("\tSensitivity = " + traits[traitName.sensitivity.index].getValue());
		System.out.println("\tVigilance = " + traits[traitName.vigilance.index].getValue());
		System.out.println("\tAbstractedness = " + traits[traitName.abstractedness.index].getValue());
		System.out.println("\tPrivateness = " + traits[traitName.privateness.index].getValue());
		System.out.println("\tApprehensivness = " + traits[traitName.apprehensivness.index].getValue());
		System.out.println("\tOpenness to Change = " + traits[traitName.opennessToChange.index].getValue());
		System.out.println("\tSelf-Reliance = " + traits[traitName.selfReliance.index].getValue());
		System.out.println("\tPerfectionism = " + traits[traitName.perfectionism.index].getValue());
		System.out.println("\tTension = " + traits[traitName.tension.index].getValue());
		
		/*********************************
		 * Edited 10/18/13 by Mark
		 *********************************/
		System.out.println("Needs: ");
		for (Need n : Needs){
			System.out.println("\t" + n.getNeedName() + " = " + n.getNeedLevel());
		}
		
		/*********************************
		 * Edited 11/5/13 by Luke
		 *********************************/
		System.out.println("");
		
	}
	
	public void give(String item){
		itemType itemName = itemType.valueOf(item.toUpperCase());
		inventory.create(itemName);
	}
	
	/*******************************
	 * Tells the crust to use the item that is passed in
	 * @param item - The string containing the name of the item
	 * @throws IOException if the action can't be logged
	 */
	public int use(String item){
		
		//Grab the name of the object to be created
		itemType itemName = itemType.valueOf(item.toUpperCase());

		//Check if item exists
		if( !inventory.has(itemName) ){
			return NO_ITEM_AVAILABLE;
		}
		
		//Apply item to crust
		for( String need : inventory.getItem(itemName).getNeeds() ){
			incrementNeed(need, inventory.getItem(itemName).getValue(need));
		}
		
		//Check if item is consumable
		for( String need : inventory.getItem(itemName).getNeeds() ){
			if( need=="Hunger" )
				break;
			else{
				//if not, do not destroy
				history.logAction("Crust has used "+itemName.name());
				return ITEM_USED;
			}
		}
		inventory.destroy(itemName);
		history.logAction("Crust has consumed "+itemName.name());
		return ITEM_USED;
	}
	
	/******************************
	 * Prints out all of the relationships that this crust has
	 * @author Michael
	 ******************************/
	public void printRelationships(){
		System.out.println("Relationships:");
		for(Relationship r : relationships)
			System.out.println("\t"+r.toString());
	}
	
	/******************************
	 * Adds a relationship to the crust's list of relationships
	 * @param other - The crust that this crust will have a relationship with
	 * @param value - The initial value of that relationship
	 * @author Michael
	 ******************************/
	public void addRelationship(Crust other, int value){
		relationships.add(new Relationship(this, other, value));
	}
	
	/******************************
	 * Returns the relationship list
	 * @return The linked list of relationships this crust has
	 * @author Michael
	 ******************************/
	public LinkedList<Relationship> getRelationships(){
		return relationships;
	}
	
	public LinkedList<Interest> getInterests() {
		return interests;
	}
	
	/******************************
	 * Sets the trait's base value to whatever is passed in
	 * @param trait - The name of the trait
	 * @param value - The value to be given, this is a parsed string
	 * @author Anthony and Michael
	 ******************************/
	public void set(String trait, String value){
		
		switch(trait){
			case "firstName":
				first_name = value;
				break;
			case "middleName":
				middle_name = value;
				break;
			case "lastName":
				last_name = value;
				break;
			case "age":
				age = Integer.parseInt(value);
				break;
			default:
				try{
					traits[traitName.valueOf(trait).index].setBase(Integer.parseInt(value));
				}catch(Exception e){ }
				break;
		}
	}
	
	/******************************
	 * Sets the trait's adjusted value to whatever is passed in
	 * @param trait - The name of the trait
	 * @param value - The value to be given, this is a parsed string
	 * @author Michael
	 ******************************/
	public void setTraitAdj(String trait, String value){
		
		//Try to set the adjusted value
		try{
			traits[traitName.valueOf(trait).index].setAdj(Integer.parseInt(value));
		}catch(Exception e){ }
	}
	
	/******************************
	 * Sets the trait's modified value to whatever is passed in
	 * @param trait - The name of the trait
	 * @param value - The value to be given, this is a parsed string
	 * @author Michael
	 ******************************/
	public void setTraitMod(String trait, String value){
		
		//Try to set the modified value
		try{
			traits[traitName.valueOf(trait).index].setMod(Integer.parseInt(value));
		}catch(Exception e){ }
	}
	
	/******************************
	 * Returns the value of the selected trait in string form
	 * @param trait - The trait to have it's value returned
	 * @return The value parsed into string form.
	 * @author Anthony and Michael
	 ******************************/
	public String get(String trait){
		
		switch(trait){
			case "firstName":
				return first_name;
			case "middleName":
				return middle_name;
			case "lastName":
				return last_name;
			case "fullName":
				return first_name+" "+middle_name+" "+last_name;
			case "age":
				return String.valueOf(age);
			default:
				try{
					return String.valueOf(traits[traitName.valueOf(trait).index].getValue());
				}catch(Exception e){ return "Unknown"; }
		}
	}
}


