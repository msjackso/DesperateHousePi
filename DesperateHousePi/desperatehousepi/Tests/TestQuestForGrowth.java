package desperatehousepi.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import desperatehousepi.Crust.Crust;

public class TestQuestForGrowth {

	Crust testCrust;
	String status;
	
	@Test
	public void testVerifyConstructor() {

		testCrust = new Crust();
		
		// Check if testCrust has a destiny
		assertNotNull(testCrust.destiny);
	}

	@Test
	public void testAssign() {
		
		testCrust = new Crust();
		
		// By default no Quest assigned
		assertFalse(testCrust.destiny.quest1enabled);
		assertFalse(testCrust.destiny.quest2enabled);
		assertNotEquals(status, "Congratulations!");
		
		// Child should receive Quest 1
		testCrust.destiny.assign("Child");
		assertTrue(testCrust.destiny.quest1enabled);
		assertFalse(testCrust.destiny.quest2enabled);
		assertNotEquals(status, "Congratulations!");
		
		// Teen should receive Quest 2
		testCrust.destiny.quest1completed = true;
		testCrust.destiny.assign("Teen");
		assertTrue(testCrust.destiny.quest1enabled);
		assertTrue(testCrust.destiny.quest2enabled);
		assertNotEquals(status, "Congratulations!");
		
		// Adult should not receive any further quests
		testCrust.destiny.quest2completed = true;
		status = testCrust.destiny.assign("Adult");
		assertTrue(testCrust.destiny.quest1enabled);
		assertTrue(testCrust.destiny.quest2enabled);
		assertEquals(status, "Congratulations!");
		
	}
	
	@Test
	public void testReceive() {
		
		testCrust = new Crust();
		testCrust.destiny.assign("Child");
		
		// Lid entered
		status = testCrust.destiny.receive("LID");
		assertEquals(status.substring(status.lastIndexOf(' ')), " accepted!");
		
		// Signature entered
		status = testCrust.destiny.receive("SIGNATURE");
		assertEquals(status.substring(status.lastIndexOf(' ')), " accepted!");

	}
	
	@Test
	public void testUpdateJourney() {
		
		testCrust = new Crust();
		
		// Quest 1
		testCrust.destiny.assign("Child");
		assertTrue(testCrust.destiny.quest1enabled);
		// Growth stage should be unchanged before update
		testCrust.destiny.receive("LID");
		testCrust.destiny.receive("JAR");
		testCrust.destiny.receive("SIGNATURE");
		testCrust.destiny.receive("SIGNATURE");
		testCrust.destiny.receive("SIGNATURE");
		assertFalse(testCrust.destiny.quest1completed);
		
		// Growth stage should be changed after update
		testCrust.destiny.updateJourney();
		assertTrue(testCrust.destiny.quest1completed);
		
		
		// Quest 2
		testCrust.destiny.assign("Teen");
		assertTrue(testCrust.destiny.quest2enabled);
		// Growth stage should be unchanged before update
		testCrust.destiny.receive("RECIPIE");
		testCrust.destiny.receive("FLOUR");
		testCrust.destiny.receive("SALT");
		testCrust.destiny.receive("SUGAR");
		testCrust.destiny.receive("BUTTER");
		testCrust.destiny.receive("WATER");
		testCrust.destiny.receive("ROLLINGPIN");
		testCrust.destiny.receive("PAN");
		assertFalse(testCrust.destiny.quest2completed);
		
		// Growth stage should be changed after update
		testCrust.destiny.updateJourney();
		assertTrue(testCrust.destiny.quest2completed);
		
	}
	
	@Test
	public void testVerifyCurrentQuest() {
		testCrust = new Crust();

		// No Quest taken
		status = testCrust.destiny.verifyCurrentQuest();
		assertEquals(status, "Do you seek growth?");
		
		// Quest 1 Not Completed
		testCrust.destiny.assign("Child");
		assertEquals(testCrust.getStage(), "Child");
		
		// Quest 1 Completed
		testCrust.destiny.receive("LID");
		testCrust.destiny.receive("JAR");
		testCrust.destiny.receive("SIGNATURE");
		testCrust.destiny.receive("SIGNATURE");
		testCrust.destiny.receive("SIGNATURE");
		testCrust.destiny.verifyCurrentQuest();
		assertEquals(testCrust.getStage(), "Teen");

		// Quest 2 Not Completed
		testCrust.destiny.assign("Teen");
		assertEquals(testCrust.getStage(), "Teen");
		
		// Quest 2 Completed
		testCrust.destiny.receive("RECIPIE");
		testCrust.destiny.receive("FLOUR");
		testCrust.destiny.receive("SALT");
		testCrust.destiny.receive("SUGAR");
		testCrust.destiny.receive("BUTTER");
		testCrust.destiny.receive("WATER");
		testCrust.destiny.receive("ROLLINGPIN");
		testCrust.destiny.receive("PAN");
		testCrust.destiny.verifyCurrentQuest();
		assertEquals(testCrust.getStage(), "Adult");

	}
	
	@Test
	public void testGetGrowthStage() {
		
		testCrust = new Crust();
		
		// Child
		assertEquals(testCrust.destiny.getGrowthStage(), "Child");
		
		// Teen
		testCrust.destiny.quest1completed = true;
		testCrust.destiny.verifyCurrentQuest();
		assertEquals(testCrust.destiny.getGrowthStage(), "Teen");
		
		// Adult
		testCrust.destiny.quest2completed = true;
		testCrust.destiny.verifyCurrentQuest();
		assertEquals(testCrust.destiny.getGrowthStage(), "Adult");
		
	}
	
	@Test
	public void getGrowthStageAsNum() {		testCrust = new Crust();
	
	// Child=="1"
	assertEquals(testCrust.destiny.getGrowthStageAsNum(), "1");
	
	// Teen=="2'
	testCrust.destiny.quest1completed = true;
	testCrust.destiny.verifyCurrentQuest();
	assertEquals(testCrust.destiny.getGrowthStageAsNum(), "2");
	
	// Adult=="3"
	testCrust.destiny.quest2completed = true;
	testCrust.destiny.verifyCurrentQuest();
	assertEquals(testCrust.destiny.getGrowthStageAsNum(), "3");
	
		
	}
}
