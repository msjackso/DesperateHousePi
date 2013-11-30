package desperatehousepi.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import desperatehousepi.Crust.Crust;

public class TestServer {

	@Test
	public void test() {

		//Create first crust
		Crust michael = new Crust(9999);
		michael.set("firstName","Michael");
		michael.set("lastName","Jackson");
		
		Crust brad = new Crust(9998);
		brad.set("firstName", "Brad");
		brad.set("lastName", "Brauner");
		
		//Add relationships
		michael.addRelationship("Brad Brauner", "127.0.0.1", 0);
		
		//Call relationship
		michael.call("Brad Brauner", 9998);
		
		System.out.println("Michael -> Brad successful.");
		
		//Add relationships
		brad.addRelationship("Michael Jackson", "127.0.0.1", 0);
		
		//Call relationship
		brad.call("Michael Jackson", 9999);
		
		System.out.println("Brad -> Michael successful.");
		
	}

}
