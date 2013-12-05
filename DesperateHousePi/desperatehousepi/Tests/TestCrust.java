package desperatehousepi.Tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import desperatehousepi.Crust.Crust;
import desperatehousepi.Crust.Interests;
import desperatehousepi.Items.ItemSet;

public class TestCrust {
	
	//Constant declarations
	public static final int UNKNOWN = -1000;
	public static final int OK = 0;
	public static final int FILE_NOT_FOUND = 1;
	public static final int FILE_BAD_FORMAT = 2;
	public static final String[] traitStrings = {
		"warmth", "reasoning", "emotionalStability", "dominance", "liveliness", "ruleConsciousness", "socialBoldness",
		"sensitivity", "vigilance", "abstractedness", "privateness", "apprehensivness", "opennessToChange", "selfReliance",
		"perfectionism", "tension"
	};
	
	//Object Declarations
	public enum traitName{
		warmth(0), reasoning(1), emotionalStability(2), dominance(3), liveliness(4), ruleConsciousness(5), socialBoldness(6), sensitivity(7),
		vigilance(8), abstractedness(9), privateness(10), apprehensivness(11), opennessToChange(12), selfReliance(13), perfectionism(14), tension(15);
		
		public int index;
		traitName(int i){
			index = i;
		}
	}
	
	@Test
	public void testCrust() {
		
		//Test the empty constructor
		Crust tCrust = new Crust();
		assertNotNull(tCrust);
	}

	@Test
	public void testCrustStringArray() {
		
		//Test the single string constructor
		Crust tCrust = new Crust("John");
		assertNotNull(tCrust);
		tCrust.stopServer();
		
		assertTrue(tCrust.get("firstName").equals("John"));
		
		//Test the multiple string constructor
		tCrust = new Crust("John", "Jacob");
		assertNotNull(tCrust);
		
		assertTrue(tCrust.get("firstName").equals("John"));
		assertTrue(tCrust.get("middleName").equals("Jacob"));
		
		//Test with too many strings to check if they are disregarded
		tCrust = new Crust("John", "Jacob", "Smith", "");
		assertNotNull(tCrust);
		
		assertTrue(tCrust.get("firstName").equals("John"));
		assertTrue(tCrust.get("middleName").equals("Jacob"));
		assertTrue(tCrust.get("lastName").equals("Smith"));
	}

	@Test
	public void testCrustIntArray() {
		
		//Test the constructor where crusts have their traits set manually
		Crust tCrust = new Crust(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		
		assertNotNull(tCrust);
		
		for(String s:traitStrings)
			assertTrue(tCrust.get(s).equals("0"));
	}

	@Test
	public void testSet() {
		
		//Create an empty crust
		Crust tCrust = new Crust();
		
		assertNotNull(tCrust);
		
		//Test the bounds on warmth
		tCrust.set("warmth", "-100");
		assertTrue(tCrust.get("warmth").equals("-100"));
		
		tCrust.set("warmth", "-101");
		assertTrue(tCrust.get("warmth").equals("-100"));
		
		tCrust.set("warmth", "100");
		assertTrue(tCrust.get("warmth").equals("100"));
		
		tCrust.set("warmth", "101");
		assertTrue(tCrust.get("warmth").equals("100"));
		
		//Test the bounds on tension
		tCrust.set("tension", "-100");
		assertTrue(tCrust.get("tension").equals("-100"));
		
		tCrust.set("tension", "-101");
		assertTrue(tCrust.get("tension").equals("-100"));
		
		tCrust.set("tension", "100");
		assertTrue(tCrust.get("tension").equals("100"));
		
		tCrust.set("tension", "101");
		assertTrue(tCrust.get("tension").equals("100"));
	}

	@Test
	public void testGet() {
		
		//Relies on whether or not sets work, both tests
		//should work, if one fails then they both failed
		testSet();
	}
	
	@Test
	public void testAddInterest(){
		
		//Create a crust
		Crust tCrust = new Crust();
		assertNotNull(tCrust);
		
		//Clear the crusts pre-added interests
		tCrust.getInterests().clear();
		
		//Add an interest
		assertNotEquals(tCrust.addInterest(Interests.ART_VAL),-1);
		
		//Make sure the newest interest is what was added
		assertEquals(Interests.getInterestVal(tCrust.getInterests().get(0).getName()), Interests.ART_VAL);
	}
	
	@Test
	public void testAddRelationship(){
		
		//Create a crust
		Crust tCrust = new Crust();
		assertNotNull(tCrust);
		
		//Add a relationship
		tCrust.addRelationship("John Jacob Smith", "127.0.0.1", 0);
		
		//Assert that the values added into the relationship actually are what they should be
		assertEquals(tCrust.getRelationships().get(0).getChemistry(), 0, 0.05);
		assertEquals(tCrust.getRelationships().get(0).getContactAddress(), "127.0.0.1");
		assertEquals(tCrust.getRelationships().get(0).getContactName(), "John Jacob Smith");
		
		//Remove the relationship
		tCrust.removeRelationship("John Jacob Smith");
		
		//Ensure that the right relationship was removed.
		assertEquals(tCrust.getRelationships().size(), 0);
		
	}
	
	@Test
	public void testTime(){
		Crust tCrust = new Crust("John","Jacob","Smith",10,20);
		assertNotNull(tCrust);
		assertTrue(tCrust.getbdaymonth()==10);
		assertTrue(tCrust.getbirthday()==20);
	}
	
	@Test
	public void testInventory(){
		
		//Create a crust
		Crust tCrust = new Crust();
		assertNotNull(tCrust);
		
		//Make note of current hunger
		int prevHunger = tCrust.getNeed("Hunger");
		
		//Give the crust an apple
		tCrust.give("APPLE");
		assertEquals(tCrust.inventory.has(ItemSet.itemType.APPLE), true);
		
		//Have the crust eat an apple
		tCrust.use("APPLE");
		assertTrue(prevHunger<tCrust.getNeed("Hunger"));
		assertEquals(tCrust.inventory.has(ItemSet.itemType.APPLE), false);
	}
	
	@Test
	public void testSaveLoad(){
		
		//Create first crust
		Crust saveCrust = new Crust("John","Hamilton","Smith", 12, 2, 100, 100);
		assertNotNull(saveCrust);
		
		saveCrust.addRelationship("Bob Munden", "127.0.0.1", -10);
		saveCrust.getInterests().clear();
		saveCrust.addInterest(Interests.ART_VAL);
		
		//Create second crust
		Crust loadCrust = new Crust("NotJohn", "NotJacob", "NotSmith", 12, 2, -100, -100);
		assertNotNull(loadCrust);
		
		//Save the first crust
		try{
			saveCrust.save();
		}catch(IOException e){
			
			//If the file can't be saved auto-fail the test
			assertTrue(false);
		}
		
		//Load the first crust into the second crust
		try {
			assertEquals(loadCrust.load(saveCrust.get("fullName").replace(" ", "_")),Crust.OK);
		} catch (IOException e) {
			
			//If the file can't be saved auto-fail the test
			assertTrue(false);
		}
		
		//Make sure important data is the same
		assertEquals(saveCrust.get("fullName"), loadCrust.get("fullName"));
		assertEquals(saveCrust.get("warmth"), loadCrust.get("warmth"));
		assertEquals(saveCrust.get("tension"), loadCrust.get("tension"));
		
		//Make sure that interests and relationships are the same
		assertEquals(saveCrust.getInterests().get(0).getName(), loadCrust.getInterests().get(0).getName());
		assertEquals(saveCrust.getRelationships().get(0).getChemistry(), loadCrust.getRelationships().get(0).getChemistry(), 0.05);
		assertEquals(saveCrust.getRelationships().get(0).getContactAddress(), loadCrust.getRelationships().get(0).getContactAddress());
		assertEquals(saveCrust.getRelationships().get(0).getContactName(), loadCrust.getRelationships().get(0).getContactName());
		
	}
	
}
