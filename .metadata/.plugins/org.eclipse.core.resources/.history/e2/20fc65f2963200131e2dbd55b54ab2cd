package desperatehousepi;

/***************************************
 * Personality Trait base class
 * 
 * @author Anthony and Michael
 ***************************************/


public class PTrait {
	int baseVal;
	int modVal;
	int adjVal;
	
	//PTrait Constructor
	PTrait(int base){
		baseVal = base;	
		modVal = 0;
		adjVal = 0;
	}
	
	/************************************
	 * @author Anthony and Michael
 	 * @param  Nothing
	 * @return Total of the value for this Personality Trait
	 ***********************************/
	public int getValue(){
		
		//Calculate total for value
		int x = modVal+adjVal+baseVal;
		
		//Bound the total by -100 and 100
		if(x>100)x=100;
		if(x<100)x=-100;
		
		//Return to caller with calculated total
		return x;
	}
	/***************************************
	 * Setter for Base Value
	 * @author Anthony and Michael
	 * @param value
	 ***************************************/
	public void setBase(int value){ this.baseVal = value; }
	public void setMod(int value){ this.modVal = value; }
	public void setAdj(int value){ this.adjVal = value; }
}
