package desperatehousepi.Crust;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class Relationship implements java.io.Serializable{
	
	/**
	 * ID for purposes of serialization
	 */
	private static final long serialVersionUID = -2250117320520854955L;
	String owner;
	String nameOfContact;
	String addressOfContact;
	Date firstMet;
	Date lastMeeting;
	public LinkedList<String> log;
	
	double chemistry;
	
	/******************************
	 * A relationship is a set of contacts that the owner has
	 * @param new_owner - The person who has this relationship
	 * @param contactName - The name of the person to contact
	 * @param address - The address of the person to contact
	 * @param new_value - The inital value of the relationship
	 * @author Michael
	 ******************************/
	public Relationship(String new_owner, String contactName, String address, double new_value){
		owner = new_owner;
		nameOfContact = contactName;
		addressOfContact = address;
		chemistry = new_value;
		firstMet = new Date();
		lastMeeting = new Date();
		log = new LinkedList<String>();
	}
	
	/******************************
	 * A relationship is a set of contacts that the owner has
	 * @author Michael
	 ******************************/
	public Relationship(){
		owner = null;
		chemistry = 0;
		log = new LinkedList<String>();
	}
	
	public void setOwner(String s){ owner = s; }
	
	/*****************************
	 * Returns the value of the relationship
	 * @return The value of this relationship
	 * @author Michael
	 */
	public double getChemistry(){ return chemistry; }
	
	/*****************************
	 * Sets the value of the relationship, this is bounded by 100 and -100
	 * @author Brad and Michael
	 * @Edited 11/24/13
	 *****************************/
	public void setChemistry(double c){
		if(c>100)
			chemistry = 100;
		else if(c<-100)
			chemistry = -100;
		else
			chemistry = c;
	}
	
	/*****************************
	 * Returns the name of the contact
	 * @return The name of the contact
	 * @author Michael
	 */
	public String getContactName(){ return nameOfContact; }
	
	/*****************************
	 * Sets the name of the contact
	 * @author Michael
	 */
	public void setContactName(String s){ nameOfContact = s; }
	
	/*****************************
	 * Returns the address of the contact
	 * @return The address of the contact
	 * @author Michael
	 */
	public String getContactAddress(){ return addressOfContact; }
	
	/*****************************
	 * Sets the address of the contact
	 * @author Michael
	 */
	public void setContactAddress(String s){ addressOfContact = s; }
	
	/*****************************
	 * Returns the date of first contact
	 * @return The date of first contact
	 * @author Michael
	 */
	public Date getFirstMet(){ return firstMet; }
	
	/*****************************
	 * Sets the date of first contact
	 * @author Michael
	 */
	public void setFirstMet(String s){
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		try {
			firstMet = df.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	/*****************************
	 * Returns the date of last contact
	 * @return The date of last contact
	 * @author Michael
	 */
	public Date getLastMeeting(){ return lastMeeting; }
	
	/*****************************
	 * Sets the date of last contact
	 * @author Michael
	 */
	public void setLastMeeting(String s){

		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		try {
			lastMeeting = df.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	public String toString(){
		return (chemistry+":"+owner+ "->"+nameOfContact);
	}
	
	/*****************************
	 * Returns the owner of the relationship
	 * @return The owner crust object of this relationship
	 * @author Michael
	 */
	public void write(){
		
	}
	
}
