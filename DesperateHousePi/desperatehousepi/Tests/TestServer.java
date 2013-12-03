package desperatehousepi.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import desperatehousepi.Crust.Crust;

@SuppressWarnings("unused")
public class TestServer {
	
	@Test
	public void testServer() {
		
		//Create first crust
		Crust michael = new Crust(9999);
		michael.set("firstName","Michael");
		michael.set("lastName","Jackson");
		
		Crust brad = new Crust(9998);
		brad.set("firstName", "Brad");
		brad.set("lastName", "Brauner");
		
		//Add relationships
		michael.addRelationship("Brad Jacob Brauner", "127.0.0.1", 0);
		
		//Call relationship
		michael.call("Brad Jacob Brauner", 9998);
		
		System.out.println("Michael -> Brad successful.");
		
		System.out.println("\nMichael");
		michael.printRelationships();
		System.out.println("Brad");
		brad.printRelationships();
		System.out.println();
		
		//Call relationship
		for(int i = 0; i<500; i++)
			brad.call("Michael Jacob Jackson", 9999);
		
		System.out.println("Brad -> Michael successful.");
		
		System.out.println("\nBrad");
		brad.printRelationships();
		System.out.println("Michael");
		michael.printRelationships();
	}
	
}
