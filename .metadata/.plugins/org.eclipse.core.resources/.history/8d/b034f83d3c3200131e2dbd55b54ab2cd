package desperatehousepi;

//Base class for Personality Traits
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
	 * @return Total of the value
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
}
