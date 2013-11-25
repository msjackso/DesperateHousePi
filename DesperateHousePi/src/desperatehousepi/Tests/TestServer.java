package desperatehousepi.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import desperatehousepi.Crust.Crust;

public class TestServer {

	@Test
	public void test() {

		//Create first crust
		Crust c1 = new Crust(9999);
		c1.set("firstName","Michael");
		c1.set("lastName","Jackson");
		
		//Add relationships
		c1.addRelationship("Michael Jackson", "127.0.0.1", 0);
		
		//Call relationship
		c1.call("Michael Jackson", 9999);
		
	}

}
