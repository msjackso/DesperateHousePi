package desperatehousepi.Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import desperatehousepi.Crust.Crust;

public class TestServer {
	
	Crust michael, brad;
	
	@Before
	public void initialize(){
		
		//Create first crust
		michael = new Crust(9999);
		michael.set("firstName","Michael");
		michael.set("middleName", "Jacob");
		michael.set("lastName","Jackson");
		
		brad = new Crust(9998);
		brad.set("firstName", "Brad");
		brad.set("middleName", "Jacob");
		brad.set("lastName", "Brauner");
		
	}
	
	@Test
	public void testServer() {
		
		//TODO remove
		System.out.println("Clear realationships");
		
		//Re-establish relationships to blank
		michael.getRelationships().clear();
		brad.getRelationships().clear();
		
		//TODO remove
		System.out.println("Add brad to relationships");
		
		//Add relationships
		michael.addRelationship("Brad Jacob Brauner", "127.0.0.1", 0);
		
		//TODO remove
		System.out.println("Call brad");
		
		//Call relationship
		michael.call("Brad Jacob Brauner", 9998);
		
		//TODO remove
		System.out.println("Brad's relationships");
		
		brad.printRelationships();
		
		//Ensure that relationship was made and other server was proper
		assertEquals(brad.getRelationships().size(), 1);
		
		//TODO remove
		System.out.println("Call michael");
		
		//Call relationship
		brad.call("Michael Jacob Jackson", 9999);
		
		//Ensure that relationship was made and other server was proper
		assertEquals(michael.getRelationships().size(), 1);
		
	}
	
}
