package desperatehousepi.Crust;
import java.util.EnumMap;

public class QuestForGrowth {
	/**********************************
	 * QuestForGrowth is a module that handles all growth quest-related information
	 * @author Mark
	 *********************************/
	private boolean quest1enabled;
	private boolean quest1completed;
	
	private boolean quest2enabled;
	private boolean quest2completed;
	
	//edited 11/23/13 by Luke
	//traits that are reset every level
	private int[] posTraitsEncountered = new int [16];
	private int[] negTraitsEncountered = new int [16];
	int numInteractions = 0;
	
	public static enum quest1reqs{
		JAR("JAR"), LID("LID"), SIGNATURE("SIGNATURE");
		
		public String name;
		quest1reqs(String n){
			name = n;
		}
	}
	private EnumMap<quest1reqs, Requirement> quest1 = 
			new EnumMap<quest1reqs, Requirement>(quest1reqs.class);

	public static enum quest2reqs{
		RECIPIE("RECIPIE"),
		
		FLOUR("FLOUR"), SALT("SALT"), SUGAR("SUGAR"), BUTTER("BUTTER"), WATER("WATER"), 
		
		ROLLINGPIN("ROLLINGPIN"), PAN("PAN");
		
		public String name;
		quest2reqs(String n){
			name = n;
		}
	}
	private EnumMap<quest2reqs, Requirement> quest2 = 
			new EnumMap<quest2reqs, Requirement>(quest2reqs.class);
	
	QuestForGrowth() {
		
		// Quests should not be completed at creation
		quest1enabled = false;
		quest1completed = false;
		quest1reqs req1;
		
		req1 = quest1reqs.JAR;
		quest1.put(req1,  new Requirement( req1.name, 1 ));
		req1 = quest1reqs.LID;
		quest1.put(req1,  new Requirement( req1.name, 1 ));
		req1 = quest1reqs.SIGNATURE;
		quest1.put(req1,  new Requirement( req1.name, 3 ));
		
		quest2enabled = false;
		quest2completed = false;

		for(quest2reqs req2 : quest2reqs.values()){
			quest2.put(req2, new Requirement( req2.name, 1 ));
		}
		
	}
	
	public class Requirement {
		/**********************************
		 * A generic-item inner class containing information about an item and 
		 * the needs that it affects
		 * @author Mark
		 *********************************/

		//Initialize variables
		private String name;
		private int qty;
		private int qtyReq;
		boolean completed = false;	//Completed?
		
		//Constructor
		Requirement( String s, int req ){
			name = s;
			qty = 0;
			qtyReq = req;
		}
		
		public void incQty(){ this.qty++; }
		
		public void update(){
			if ( qty >= qtyReq )
				completed = true;
		}
	}
	
	////////////////////////Access Functions\\\\\\\\\\\\\\\\\\\\\\\\\\\
	/***************************************
	 * returns a Requirement object, given its enum name.
	 * @author Mark
	 ***************************************/
	private Requirement getReq(String name){
		if (quest2enabled)
			return quest2.get(quest2reqs.valueOf(name));
		else if (quest1enabled)
			return quest1.get(quest1reqs.valueOf(name));
		else
			return null;
	}
	
	public EnumMap getCurrentStatus(){
		if (quest2enabled)
			return quest2;
		else if (quest1enabled)
			return quest1;
		else
			return null;
	}
	
	public String verifyCurrentQuest(){
		updateJourney();
		if (quest2enabled){
			if (quest2completed)
				return "Congratulations! You have reached the end of your journey";
			else
				return "You are still lacking, young one";
		}
		else if (quest1enabled){
			if (quest1completed)
				return "Congratulations! You have proven yourself worthy to progress further";
			else
				return "You are still lacking, young one";
		}
		else
			return "Do you seek growth?";
		
	}
	
	public String getGrowthStage(){
		if (quest2completed)
			return "Adult";
		else if (quest1completed)
			return "Teen";
		else
			return "Child";	
	}
	///////////////////////Manipulation Functions\\\\\\\\\\\\\\\\\\\\\\\
	/***************************************
	 * given the stage of the crust, the appropriate quest will be enabled
	 * @author Mark
	 ***************************************/
	public String assign(String stage){
		switch( stage.toUpperCase() ){
			case "CHILD":
				quest1enabled = true;
				return "Crust has taken GROWTH QUEST 1";
			case "TEEN":
				if (quest1completed){
					quest2enabled = true;
					return "Crust has taken GROWTH QUEST 2";
				}
			default:
				return "Your journey is complete";
		}
	}
	
	/***************************************
	 * returns a Requirement object, given its String name.
	 * @author Mark
	 ***************************************/
	public String receive(String reqName){
		Requirement item = getReq(reqName);
		if (!item.completed){
			item.incQty();
			return reqName+" accepted!";
		}
		else
			return "Already have "+reqName;
	}
	
	
	public void updateJourney(){
		boolean epiphany;
		Requirement req;
		
		epiphany= true;
		
		if (quest2enabled){
			for (quest2reqs req2 : quest2reqs.values()){
				req = getReq(req2.name);
				req.update();
				if (!req.completed)
					epiphany = false;
			}
			quest2completed = epiphany;
			return;
		} 
		else if (quest1enabled){
			for (quest1reqs req1 : quest1reqs.values()){
				req = getReq(req1.name);
				req.update();
				if (!req.completed)
					epiphany = false;
			}
			quest1completed = epiphany;
			return;
		} 
		else
			return;
	}
	
	/***************************************
	 * returns the values of the list of traits that will be generated.
	 * @author Luke
	 ***************************************/
	int[] calculateTraits() {
		int[] newTraitVals = new int [16];
		int[] sums = new int [16];
		float[] percentages = new float [16];
		int totalTraitVals = 0;
		int numToDistribute;
		
		//Figure out raw counts for each trait based on interactions
		for (int i = 0; i < 16; i++) {
			newTraitVals[i] = posTraitsEncountered[i] - negTraitsEncountered[i];
			totalTraitVals += Math.abs(newTraitVals[i]);
		}
		
		//Assigns a number of points to distribute based on the number of interactions this level
		if (numInteractions <= 25) {
			numToDistribute = 30;
		}
		
		else {
			numToDistribute = 40;
		}
		
		//Calculates the percentage of points that should be assigned to each trait
		for (int i = 0; i < 16; i++) {
			percentages[i] = newTraitVals[i]/totalTraitVals;
			newTraitVals[i] = (int) percentages[i] * numToDistribute;
		}
		
		return newTraitVals;
		
	}
	
}
