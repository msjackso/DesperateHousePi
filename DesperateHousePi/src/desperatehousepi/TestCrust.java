package desperatehousepi;

import static org.junit.Assert.*;

import org.junit.Test;

import desperatehousepi.Crust.Crust;

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
		Crust tCrust = new Crust();
		assertNotNull(tCrust);
	}

	@Test
	public void testCrustStringArray() {
		Crust tCrust = new Crust("John");
		assertNotNull(tCrust);
		
		assertTrue(tCrust.get("firstName").equals("John"));
		
		tCrust = new Crust("John", "Jacob");
		assertNotNull(tCrust);
		
		assertTrue(tCrust.get("firstName").equals("John"));
		assertTrue(tCrust.get("middleName").equals("Jacob"));
		
		tCrust = new Crust("John", "Jacob", "Smith", "");
		assertNotNull(tCrust);
		
		assertTrue(tCrust.get("firstName").equals("John"));
		assertTrue(tCrust.get("middleName").equals("Jacob"));
		assertTrue(tCrust.get("lastName").equals("Smith"));
	}

	@Test
	public void testCrustIntArray() {
		
		Crust tCrust = new Crust(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		
		assertNotNull(tCrust);
		
		for(String s:traitStrings)
			assertTrue(tCrust.get(s).equals("0"));
	}

	@Test
	public void testSet() {

		Crust tCrust = new Crust();
		
		assertNotNull(tCrust);
		
		tCrust.set("warmth", "-100");
		assertTrue(tCrust.get("warmth").equals("-100"));
		
		tCrust.set("warmth", "100");
		assertTrue(tCrust.get("warmth").equals("100"));
		
		tCrust.set("tension", "-100");
		assertTrue(tCrust.get("tension").equals("-100"));
		
		tCrust.set("tension", "100");
		assertTrue(tCrust.get("tension").equals("100"));
	}

	@Test
	public void testGet() {
		testSet();
	}

}
