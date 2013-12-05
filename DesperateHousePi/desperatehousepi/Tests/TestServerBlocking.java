package desperatehousepi.Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import desperatehousepi.Crust.Crust;

public class TestServerBlocking {

	Crust michael, brad;
	
	@Before
	public void initialize(){
		
		//Create first crust
		michael = new Crust(9999);
		michael.set("firstName","Michael");
		michael.set("lastName","Jackson");
		
		brad = new Crust(9998);
		brad.set("firstName", "Brad");
		brad.set("lastName", "Brauner");
		
	}
	
	@Test
	public void testBlocking(){
		
		//TODO remove
		System.out.println("Clear relationships");
		
		//Re-set relationships
		brad.getRelationships().clear();
		michael.getRelationships().clear();
		
		//TODO remove
		System.out.println("Block relationships");
		
		//Set brad to block any incoming calls
		brad.stopServer();
		
		//TODO remove
		System.out.println("Add brad to relatiobships");
		
		//Add relationships
		michael.addRelationship("Brad Jacob Brauner", "127.0.0.1", 0);
		
		//TODO remove
		System.out.println("Call brad");
		
		//Call relationship
		michael.call("Brad Jacob Brauner", 9998);
		
		//Ensure that relationship was made and other server was proper
		assertEquals(brad.getRelationships().size(), 0);
		
		//TODO remove
		System.out.println("Re-start server");
		
		//Re-start the server
		brad.startServer();
		
		//TODO remove
		System.out.println("Re-call brad");
		
		//Call relationship
		michael.call("Brad Jacob Brauner", 9998);
		
		//Ensure that relationship was made and other server was proper
		assertEquals(brad.getRelationships().size(), 1);
		
	}

}
