package desperatehousepi.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import desperatehousepi.Crust.Crust;
import desperatehousepi.GUI.CreationWindow;

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
		tCrust.stopServer();
		
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
	
	@Test
	public void testAddInterest(){
		
	}
	
	
	/*
	 * Testing goodDate module inside CreationWindow.java
	 * Input:String str_month,String str_day
	 * Output: boolean
	 * Equivalence classes: 1. month not an Integer sent as String
	 * 						2. day not an Integer sent as String
	 * 						3. month is Feb
	 * 						4. 31 days months (1,3,5,7,8,10,12)
	 * 						5. 30 days months (4,6,9,11)
	 * 						6. month < 1 or month > 12
	 * 						7. 0 < day < 30
	 * 						8. day = 30
	 * 						9. day = 31
	 * 						10. day < 1 or day > 31
	 */
	@Test
	public void testgoodDate(){
		CreationWindow twindow = new CreationWindow();
		assertFalse(twindow.goodDate("asd", "20"));// EC 1,7
		assertFalse(twindow.goodDate("2", "qwe")); // EC 2,3
		assertFalse(twindow.goodDate("14", "20")); // EC 6,7
		assertFalse(twindow.goodDate("9", "400")); // EC 5,10
		assertFalse(twindow.goodDate("2", "30"));  // EC 3,8
		assertFalse(twindow.goodDate("6", "31"));  // EC 5,9
		assertTrue(twindow.goodDate("1", "31"));   // EC 4,9
		assertTrue(twindow.goodDate("4", "30"));   // EC 5,8
		assertTrue(twindow.goodDate("2", "29"));   // EC 3,7
	}
	
}
