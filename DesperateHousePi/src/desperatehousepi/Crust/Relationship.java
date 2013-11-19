package desperatehousepi.Crust;

import java.util.Date;
import java.util.LinkedList;

public class Relationship {
	
	Crust owner;
	String nameOfContact;
	String addressOfContact;
	Date firstMet;
	Date lastMeeting;
	LinkedList<String> log;
	
	int chemistry;
	
	/******************************
	 * A relationship is a set of contacts that the owner has
	 * @param new_owner - The person who has this relationship
	 * @param new_other - The person who this relationship is to
	 * @param new_value - The inital value of the relationship
	 * @author Michael
	 ******************************/
	public Relationship(Crust new_owner, Crust new_other, int new_value){
		owner = new_owner;
		chemistry = new_value;
	}
	
	/******************************
	 * A relationship is a set of contacts that the owner has
	 * @author Michael
	 ******************************/
	public Relationship(){
		owner = null;
		chemistry = 0;
	}
	
	/*****************************
	 * Returns the value of the relationship
	 * @return The value of this relationship
	 * @author Michael
	 */
	public int getChemistry(){ return chemistry; }
	
	/*****************************
	 * Sets the value of the relationship
	 * @author Michael
	 */
	public void setChemistry(int c){ chemistry = c; }
	
	/*****************************
	 * Returns the owner of the relationship
	 * @return The owner crust object of this relationship
	 * @author Michael
	 */
	public Crust getOwner(){ return owner; }
	
	public String toString(){
		return (chemistry+":"+owner.first_name+" "+owner.last_name);
	}
	
	/*****************************
	 * Returns the owner of the relationship
	 * @return The owner crust object of this relationship
	 * @author Michael
	 */
	public void write(){
		
	}
	
}
