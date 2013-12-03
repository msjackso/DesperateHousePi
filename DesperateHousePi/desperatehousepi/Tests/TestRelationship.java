package desperatehousepi.Tests;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import desperatehousepi.Crust.Relationship;

public class TestRelationship {

	@SuppressWarnings("deprecation")
	@Test
	public void testConstructors() {
		
		//Test empty constructor
		Relationship r = new Relationship();
		assertNotNull(r);
		
		//Test full constructor
		r = new Relationship("Michael Jackson", "Brad Brauner", "127.0.0.1", 0);
		assertNotNull(r);
		
		//Test inputs
		assertEquals(r.getChemistry(), 0);
		assertEquals(r.getContactName(), "Brad Brauner");
		assertEquals(r.getContactAddress(), "127.0.0.1");
		
		r.setChemistry(10);
		assertEquals(r.getChemistry(), 10);
		
		r.setChemistry(10);
		assertEquals(r.getChemistry(), 10);
		
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testChemistry(){
		
		//Test full constructor
		Relationship r = new Relationship("Michael Jackson", "Brad Brauner", "127.0.0.1", 0);
		assertNotNull(r);
		
		//Test inputs
		r.setChemistry(10);
		assertEquals(r.getChemistry(), 10);
		
		r.setChemistry(-10);
		assertEquals(r.getChemistry(), -10);
		
		r.setChemistry(-101);
		assertEquals(r.getChemistry(), -100);
		
		r.setChemistry(101);
		assertEquals(r.getChemistry(), 100);
	}
	
	@Test
	public void testFirstMet(){
		
		//Test full constructor
		Relationship r = new Relationship("Michael Jackson", "Brad Brauner", "127.0.0.1", 0);
		assertNotNull(r);
		
		r.setFirstMet("10/02/1992 10:10:10");
		
		Date date = null;
		try {
			date = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("10/02/1992 10:10:10");
		} catch (ParseException e) { e.printStackTrace(); }
		
		assertEquals(r.getFirstMet(), date);
	}
	
	@Test
	public void testLastMeeting(){
		
		//Test full constructor
		Relationship r = new Relationship("Michael Jackson", "Brad Brauner", "127.0.0.1", 0);
		assertNotNull(r);
		
		r.setLastMeeting("10/02/1992 10:10:10");
		
		Date date = null;
		try {
			date = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("10/02/1992 10:10:10");
		} catch (ParseException e) { e.printStackTrace(); }
		
		assertEquals(r.getLastMeeting(), date);
	}
	
}
