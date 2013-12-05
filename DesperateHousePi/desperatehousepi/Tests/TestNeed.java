package desperatehousepi.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import desperatehousepi.Crust.Crust;
import desperatehousepi.Crust.Need;
import desperatehousepi.Items.ItemSet;

/*
 * A test for the Need.java module and related functions.
 * @Author Luke
 */

public class TestNeed {
	
	Need TestNeed;
	
	@Test
	public void testNeed() {
		Need tNeed = new Need("Test", 1);
		assertNotNull(tNeed); 
	}
	
	/*
	 * Testing setNeed function inside Need.java module
	 * Input: int amount
	 * Output: none
	 * Equivalence classes: 1. Amount sets needLevel to be 0<x<100
	 * 						2. Amount sets needLevel to be x>100
	 * 						3  Amount sets needLevel to be x<0
	 */
	void setNeed(int amount) {
		TestNeed.setNeed(50);
		assertEquals(TestNeed.getNeedLevel(), 50); //E.C., 1
		TestNeed.setNeed(200);
		assertEquals(TestNeed.getNeedLevel(), 100); //E.C., 2
		TestNeed.setNeed(-200);
		assertEquals(TestNeed.getNeedLevel(), 0); //E.C., 2
		
	}
	
	/*
	 * Testing incrementNeed function inside Need.java module
	 * Input: int amount
	 * Output: none
	 * Equivalence classes: 1. Amount causes needLevel to be 0<x<100
	 * 						2. Amount causes needLevel to be x>100
	 * 						3  Amount causes needLevel to be x<0
	 * 						4. Amount is a positive number
	 * 						5. Amount is a negative number
	 */
	@Test
	public void incrementNeed(int amount) {
		TestNeed.setNeed(50);
		TestNeed.incrementNeed(25);
		assertEquals(TestNeed.getNeedLevel(), 75); //E.C., 1, 4
		TestNeed.setNeed(50);
		TestNeed.incrementNeed(100);
		assertEquals(TestNeed.getNeedLevel(), 100); //E.C., 2, 4
		TestNeed.setNeed(50);
		TestNeed.incrementNeed(-100);
		assertEquals(TestNeed.getNeedLevel(), 75); //E.C., 3, 5
	}

	/*
	 * Testing decrementNeed function inside Need.java module
	 * Input: int amount
	 * Output: none
	 * Equivalence classes: 1. Amount causes needLevel to be 0<x<100
	 * 						2. Amount causes needLevel to be x>100
	 * 						3  Amount causes needLevel to be x<0
	 * 						4. Amount is a positive number
	 * 						5. Amount is a negative number
	 */
	void decrementNeed(int amount)  {
		TestNeed.setNeed(50);
		TestNeed.decrementNeed(25);
		assertEquals(TestNeed.getNeedLevel(), 25); //E.C., 1, 4
		TestNeed.setNeed(50);
		TestNeed.decrementNeed(100);
		assertEquals(TestNeed.getNeedLevel(), 0); //E.C., 3, 4
		TestNeed.setNeed(50);
		TestNeed.decrementNeed(-100);
		assertEquals(TestNeed.getNeedLevel(), 75); //E.C., 2, 5
	}
}