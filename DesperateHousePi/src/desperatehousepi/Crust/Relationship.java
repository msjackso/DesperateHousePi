package desperatehousepi.Crust;

public class Relationship {
	
	Crust owner, other;
	int value;
	
	/******************************
	 * A relationship is a set of contacts that the owner has
	 * @param new_owner - The person who has this relationship
	 * @param new_other - The person who this relationship is to
	 * @param new_value - The inital value of the relationship
	 * @author Michael
	 ******************************/
	public Relationship(Crust new_owner, Crust new_other, int new_value){
		owner = new_owner;
		other = new_other;
		value = new_value;
	}
	
	/******************************
	 * A relationship is a set of contacts that the owner has
	 * @author Michael
	 ******************************/
	public Relationship(){
		owner = null;
		other = null;
		value = 0;
	}
	
	/*****************************
	 * Returns the value of the relationship
	 * @return The value of this relationship
	 * @author Michael
	 */
	public int getValue(){ return value; }
	
	/*****************************
	 * Returns the owner of the relationship
	 * @return The owner crust object of this relationship
	 * @author Michael
	 */
	public Crust getOwner(){ return owner; }
	
	/*****************************
	 * Returns the other of the relationship
	 * @return The other crust object of this relationship
	 * @author Michael
	 */
	public Crust getOther(){ return other; }
	
	public String toString(){
		return (value+":"+owner.first_name+" "+owner.last_name+"->"+other.first_name+" "+other.last_name);
	}
	
}
