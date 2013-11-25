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
	
	String name;
	String address;
	PTrait[] traits = new PTrait[16];
	LinkedList<Integer> interests;
	
	public Package(String n, String a){
		name = n;
		address = a;
	}
	
	public void setTraits(PTrait[] newTraits){
		for(int i = 0; i<16; i++){
			traits[i] = newTraits[i];
		}
	}
	
	public void setInterests(LinkedList<Interest> ints){
		for(Interest i : ints){
			interests.add(Interests.getInterestVal(i.getName()));
		}
	}
	
	public String toString(){
		return name+": "+address;
	}
	
}
