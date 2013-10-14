package desperatehousepi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Crust extends Person {
	
	//Object Declarations
	private PTrait warmth = new PTrait(0);
	private PTrait reasoning = new PTrait(0);
	private PTrait emotionalStability = new PTrait(0);
	private PTrait dominance = new PTrait(0);
	private PTrait liveliness = new PTrait(0);
	private PTrait ruleConsciousness = new PTrait(0);
	private PTrait socialBoldness = new PTrait(0);
	private PTrait sensitivity = new PTrait(0);
	private PTrait vigilance = new PTrait(0);
	private PTrait abstractedness = new PTrait(0);
	private PTrait privateness = new PTrait(0);
	private PTrait apprehensivness = new PTrait(0);
	private PTrait opennessToChange = new PTrait(0);
	private PTrait selfReliance = new PTrait(0);
	private PTrait perfectionism = new PTrait(0);
	private PTrait tension = new PTrait(0);
	private LinkedList<Relationship> relationships = new LinkedList<Relationship>();
	
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
	Crust(){
		warmth.setRandomTrait();
		reasoning.setRandomTrait();
		emotionalStability.setRandomTrait();
		dominance.setRandomTrait();
		liveliness.setRandomTrait();
		ruleConsciousness.setRandomTrait();
		socialBoldness.setRandomTrait();
		sensitivity.setRandomTrait();
		vigilance.setRandomTrait();
		abstractedness.setRandomTrait();
		privateness.setRandomTrait();
		apprehensivness.setRandomTrait();
		opennessToChange.setRandomTrait();
		selfReliance.setRandomTrait();
		perfectionism.setRandomTrait();
		tension.setRandomTrait();
	}
	
	/******************************
	 * Saves the crust to a file to be imported later. Is saved as a .crust file
	 * @param filename - The profile name it will be stored under
	 * @author Michael
	 * @throws IOException 
	 ******************************/
	public void save(String filename) throws IOException{
		
		//Open saveFile
		File saveFile = new File(filename+".crust");
		
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
		File loadFile = new File(filename+".crust");
		
		//Check to see if file to be loaded exists, if it doesn't, return 1 to signify
		//'file not found'
		if(!loadFile.exists())
			return 1;
		
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
			return 0;
		}catch(Exception e){
			br.close();
			return 2;
		}
	}
	
	/******************************
	 * Returns all of the traits in format for being printed to file
	 * @author Michael
	 ******************************/
	public String getFormattedTraits(){
		
		String allTraits = "";
		
		allTraits+=warmth.getBase()+" "+warmth.getMod()+" "+warmth.getAdj()+" ";
		allTraits+=reasoning.getBase()+" "+reasoning.getMod()+" "+reasoning.getAdj()+" ";
		allTraits+=emotionalStability.getBase()+" "+emotionalStability.getMod()+" "+emotionalStability.getAdj()+" ";
		allTraits+=dominance.getBase()+" "+dominance.getMod()+" "+dominance.getAdj()+" ";
		allTraits+=liveliness.getBase()+" "+liveliness.getMod()+" "+liveliness.getAdj()+" ";
		allTraits+=ruleConsciousness.getBase()+" "+ruleConsciousness.getMod()+" "+ruleConsciousness.getAdj()+" ";
		allTraits+=socialBoldness.getBase()+" "+socialBoldness.getMod()+" "+socialBoldness.getAdj()+" ";
		allTraits+=sensitivity.getBase()+" "+sensitivity.getMod()+" "+sensitivity.getAdj()+" ";
		allTraits+=vigilance.getBase()+" "+vigilance.getMod()+" "+vigilance.getAdj()+" ";
		allTraits+=abstractedness.getBase()+" "+abstractedness.getMod()+" "+abstractedness.getAdj()+" ";
		allTraits+=privateness.getBase()+" "+privateness.getMod()+" "+privateness.getAdj()+" ";
		allTraits+=apprehensivness.getBase()+" "+apprehensivness.getMod()+" "+apprehensivness.getAdj()+" ";
		allTraits+=opennessToChange.getBase()+" "+opennessToChange.getMod()+" "+opennessToChange.getAdj()+" ";
		allTraits+=selfReliance.getBase()+" "+selfReliance.getMod()+" "+selfReliance.getAdj()+" ";
		allTraits+=perfectionism.getBase()+" "+perfectionism.getMod()+" "+perfectionism.getAdj()+" ";
		allTraits+=tension.getBase()+" "+tension.getMod()+" "+tension.getAdj()+" ";
		
		return allTraits;
	}
	
	/******************************
	 * Sets all of the traits from formatted file to this Crust
	 * @author Michael and Anthony
	 ******************************/
	public void setFormattedTraits(StringTokenizer tkn){
		
		first_name = tkn.nextToken();
		middle_name = tkn.nextToken();
		last_name = tkn.nextToken();
		warmth.setBase(Integer.parseInt(tkn.nextToken()));
		warmth.setMod(Integer.parseInt(tkn.nextToken()));
		warmth.setAdj(Integer.parseInt(tkn.nextToken()));
		reasoning.setBase(Integer.parseInt(tkn.nextToken()));
		reasoning.setMod(Integer.parseInt(tkn.nextToken()));
		reasoning.setAdj(Integer.parseInt(tkn.nextToken()));
		emotionalStability.setBase(Integer.parseInt(tkn.nextToken()));
		emotionalStability.setMod(Integer.parseInt(tkn.nextToken()));
		emotionalStability.setAdj(Integer.parseInt(tkn.nextToken()));
		dominance.setBase(Integer.parseInt(tkn.nextToken()));
		dominance.setMod(Integer.parseInt(tkn.nextToken()));
		dominance.setAdj(Integer.parseInt(tkn.nextToken()));
		liveliness.setBase(Integer.parseInt(tkn.nextToken()));
		liveliness.setMod(Integer.parseInt(tkn.nextToken()));
		liveliness.setAdj(Integer.parseInt(tkn.nextToken()));
		ruleConsciousness.setBase(Integer.parseInt(tkn.nextToken()));
		ruleConsciousness.setMod(Integer.parseInt(tkn.nextToken()));
		ruleConsciousness.setAdj(Integer.parseInt(tkn.nextToken()));
		socialBoldness.setBase(Integer.parseInt(tkn.nextToken()));
		socialBoldness.setMod(Integer.parseInt(tkn.nextToken()));
		socialBoldness.setAdj(Integer.parseInt(tkn.nextToken()));
		sensitivity.setBase(Integer.parseInt(tkn.nextToken()));
		sensitivity.setMod(Integer.parseInt(tkn.nextToken()));
		sensitivity.setAdj(Integer.parseInt(tkn.nextToken()));
		vigilance.setBase(Integer.parseInt(tkn.nextToken()));
		vigilance.setMod(Integer.parseInt(tkn.nextToken()));
		vigilance.setAdj(Integer.parseInt(tkn.nextToken()));
		abstractedness.setBase(Integer.parseInt(tkn.nextToken()));
		abstractedness.setMod(Integer.parseInt(tkn.nextToken()));
		abstractedness.setAdj(Integer.parseInt(tkn.nextToken()));
		privateness.setBase(Integer.parseInt(tkn.nextToken()));
		privateness.setMod(Integer.parseInt(tkn.nextToken()));
		privateness.setAdj(Integer.parseInt(tkn.nextToken()));
		apprehensivness.setBase(Integer.parseInt(tkn.nextToken()));
		apprehensivness.setMod(Integer.parseInt(tkn.nextToken()));
		apprehensivness.setAdj(Integer.parseInt(tkn.nextToken()));
		opennessToChange.setBase(Integer.parseInt(tkn.nextToken()));
		opennessToChange.setMod(Integer.parseInt(tkn.nextToken()));
		opennessToChange.setAdj(Integer.parseInt(tkn.nextToken()));
		selfReliance.setBase(Integer.parseInt(tkn.nextToken()));
		selfReliance.setMod(Integer.parseInt(tkn.nextToken()));
		selfReliance.setAdj(Integer.parseInt(tkn.nextToken()));
		perfectionism.setBase(Integer.parseInt(tkn.nextToken()));
		perfectionism.setMod(Integer.parseInt(tkn.nextToken()));
		perfectionism.setAdj(Integer.parseInt(tkn.nextToken()));
		tension.setBase(Integer.parseInt(tkn.nextToken()));
		tension.setMod(Integer.parseInt(tkn.nextToken()));
		tension.setAdj(Integer.parseInt(tkn.nextToken()));
	}
	
	/******************************
	 * Prints out all of the variables held in the Crust besides the relationships.
	 * @author Anthony and Michael
	 ******************************/
	public void print(){
		System.out.println("Name: " + first_name+" "+middle_name+" "+last_name);
		System.out.println("Age: " + age);
		System.out.println("Personality:");
		System.out.println("\tWarmth = " + warmth.getValue());
		System.out.println("\tReasoning = " + reasoning.getValue());
		System.out.println("\tEmotional Stability = " + emotionalStability.getValue());
		System.out.println("\tDominance = " + dominance.getValue());
		System.out.println("\tLiveliness = " + liveliness.getValue());
		System.out.println("\tRule Consciousness = " + ruleConsciousness.getValue());
		System.out.println("\tSocial Boldness = " + socialBoldness.getValue());
		System.out.println("\tSensitivity = " + sensitivity.getValue());
		System.out.println("\tVigilance = " + vigilance.getValue());
		System.out.println("\tAbstractedness = " + abstractedness.getValue());
		System.out.println("\tPrivateness = " + privateness.getValue());
		System.out.println("\tApprehensivness = " + apprehensivness.getValue());
		System.out.println("\tOpenness to Change = " + opennessToChange.getValue());
		System.out.println("\tSelf-Reliance = " + selfReliance.getValue());
		System.out.println("\tPerfectionism = " + perfectionism.getValue());
		System.out.println("\tTension = " + tension.getValue());
		
		System.out.println("Needs: ");
		System.out.println("\tHunger = " + hunger);
		System.out.println("\tEnergy = " + energy);
		System.out.println("\tEntertainment = " + entertainment);
		
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
	 * Sets the trait's base value to whatever is passed in
	 * @param trait - The name of the trait
	 * @param value - The value to be given, this is a parsed string
	 * @author Anthony and Michael
	 ******************************/
	public void set(String trait, String value){
		
		switch(trait){
			case "warmth":
				warmth.setBase(Integer.parseInt(value));
				break;
			case "reasoning":
				reasoning.setBase(Integer.parseInt(value));
				break;
			case "emotionalStability":
				emotionalStability.setBase(Integer.parseInt(value));
				break;
			case "dominance":
				dominance.setBase(Integer.parseInt(value));
				break;
			case "liveliness":
				liveliness.setBase(Integer.parseInt(value));
				break;
			case "ruleConsciousness":
				ruleConsciousness.setBase(Integer.parseInt(value));
				break;
			case "socialBoldness":
				socialBoldness.setBase(Integer.parseInt(value));
				break;
			case "sensitivity":
				sensitivity.setBase(Integer.parseInt(value));
				break;
			case "vigilance":
				vigilance.setBase(Integer.parseInt(value));
				break;
			case "abstractedness":
				abstractedness.setBase(Integer.parseInt(value));
				break;
			case "privateness":
				privateness.setBase(Integer.parseInt(value));
				break;
			case "apprehensivness":
				apprehensivness.setBase(Integer.parseInt(value));
				break;
			case "opennessToChange":
				opennessToChange.setBase(Integer.parseInt(value));
				break;
			case "selfReliance":
				selfReliance.setBase(Integer.parseInt(value));
				break;
			case "perfectionism":
				perfectionism.setBase(Integer.parseInt(value));
				break;
			case "tension":
				tension.setBase(Integer.parseInt(value));
				break;
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
				break;
		}
	}
	
	/******************************
	 * Returns the value of the selected trait in string form
	 * @param trait - The trait to have it's value returned
	 * @return The value parsed into string form.
	 * @author Anthony and Michael
	 ******************************/
	public String get(String trait){
		
		switch(trait){
			case "warmth":
				return String.valueOf(warmth.getValue());
			case "reasoning":
				return String.valueOf(reasoning.getValue());
			case "emotionalStability":
				return String.valueOf(emotionalStability.getValue());
			case "dominance":
				return String.valueOf(dominance.getValue());
			case "liveliness":
				return String.valueOf(liveliness.getValue());
			case "ruleConsciousness":
				return String.valueOf(ruleConsciousness.getValue());
			case "socialBoldness":
				return String.valueOf(socialBoldness.getValue());
			case "sensitivity":
				return String.valueOf(sensitivity.getValue());
			case "vigilance":
				return String.valueOf(vigilance.getValue());
			case "abstractedness":
				return String.valueOf(abstractedness.getValue());
			case "privateness":
				return String.valueOf(privateness.getValue());
			case "apprehensivness":
				return String.valueOf(apprehensivness.getValue());
			case "opennessToChange":
				return String.valueOf(opennessToChange.getValue());
			case "selfReliance":
				return String.valueOf(selfReliance.getValue());
			case "perfectionism":
				return String.valueOf(perfectionism.getValue());
			case "tension":
				return String.valueOf(tension.getValue());
			case "firstName":
				return first_name;
			case "middleName":
				return middle_name;
			case "lastName":
				return last_name;
			case "age":
				return String.valueOf(age);
			default:
				return "Unknown";
		}
	}
}


