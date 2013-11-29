package desperatehousepi.Server;

import java.util.LinkedList;

import desperatehousepi.Crust.Interest;
import desperatehousepi.Crust.Interests;
import desperatehousepi.Crust.PTrait;

public class Package implements java.io.Serializable{
	
	/**
	 * ID for purposes of serialization
	 */
	private static final long serialVersionUID = 2254804390984390543L;
	
	public String name;
	public PTrait[] traits = new PTrait[16];
	public LinkedList<Integer> interests;
	public LinkedList<Integer> interestLevel;
	public int hunger, energy, entertainment;
	
	public Package(String n){
		name = n;
	}
	
	public void setTraits(PTrait[] newTraits){
		for(int i = 0; i<16; i++){
			traits[i] = newTraits[i];
		}
	}
	
	public void setInterests(LinkedList<Interest> ints){
		
		interests = new LinkedList<Integer>();
		
		for(Interest i : ints){
			interests.add(Interests.getInterestVal(i.getName()));
			interestLevel.add(i.getImportance());
		}
	}
	
	public void setNeeds(int h, int ene, int ent){
		hunger = h;
		energy = ene;
		entertainment = ent;
	}
	
	public String toString(){
		return name+" is awesome!";
	}
	
}
