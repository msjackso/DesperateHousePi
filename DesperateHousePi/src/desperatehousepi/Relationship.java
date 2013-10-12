package desperatehousepi;

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
	
	public String toString(){
		return (value+":"+owner.first_name+" "+owner.last_name+"->"+other.first_name+" "+other.last_name);
	}
	
}
