package desperatehousepi;

import java.util.Random;

/***************************************
 * Personality Trait base class
 * 
 * @author Anthony and Michael
 ***************************************/


public class PTrait {
	
	//Declare base values
	private int baseVal;
	private int modVal;
	private int adjVal;
	
	/************************************
	 * A generic trait object
	 * @param  base - The base value of the trait
	 * @author Anthony and Michael
	 ***********************************/
	PTrait(int base){
		baseVal = base;	
		modVal = 0;
		adjVal = 0;
	}
	
	/************************************
	 * @author Anthony and Michael
 	 * @param  Nothing
	 * @return Total of the value for this Personality Trait; 
	 * should be an integer between -100 and 100
	 ***********************************/
	public int getValue(){
		
		//Calculate total for value
		int x = modVal+adjVal+baseVal;
		
		//Bound the total by -100 and 100
		if(x >  100) x = 100;
		if(x < -100) x = -100;
		
		//Return to caller with calculated total
		return x;
	}
	
	/***************************************
	 * Setter for Trait Base Value
	 * @author Anthony and Michael
	 * @param value
	 ***************************************/
	public void setBase(int value){ baseVal = value; }
	/***************************************
	 * Setter for Trait Modifier Value
	 * @author Anthony and Michael
	 * @param value
	 ***************************************/
	public void setMod(int value){ modVal = value; }
	/***************************************
	 * Setter for temporary Adjusted Trait Value
	 * @author Anthony and Michael
	 * @param value - Amount of adjustment
	 * @param decay - Amount of decrement each time
	 * @param time  - time in milliseconds of each decay, -1 for infinity
	 ***************************************/
	public void setAdj(int value){ adjVal = value; }
	
	/************************************************
	 * Function creates random base value between -100 and 100 for PTrait
	 * @author Anthony and Michael
	 * @return PTrait with base value randomly set
	 ************************************************/
	public void setRandomTrait(){
		
		//Create random object
		Random rand = new Random();
		
		//Generate a bell curve average value
		this.baseVal = Math.round((rand.nextInt(201)+rand.nextInt(201)+rand.nextInt(201)-300)/3);
	}
}
