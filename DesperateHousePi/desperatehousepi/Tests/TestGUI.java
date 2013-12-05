package desperatehousepi.Tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;





import desperatehousepi.Crust.Crust;
import desperatehousepi.Crust.Crust.CrustType;
import desperatehousepi.GUI.AncientPie;
import desperatehousepi.GUI.HelpWindow;
import desperatehousepi.GUI.MainWindow;
import desperatehousepi.GUI.OptionWindow;
import desperatehousepi.GUI.PersonalityTestWindow;
import desperatehousepi.GUI.CreationWindow;
import desperatehousepi.GUI.Intro;

/***********************************
 * Tests all the GUI windows and their associated public functions
 * @author Tony
 ***********************************/
public class TestGUI {

	Crust testCrust = new Crust();
	
	//Test intro window
	@Test
	public void testIntro(){
		//test constructor
		Intro newIntro = new Intro();
		assertNotNull(newIntro);
	}
	
	//test creation window
	@Test
	public void testCreation(){
		//test first constructor
		CreationWindow cw1 = new CreationWindow();
		assertNotNull(cw1);
		
		//test second constructor
		CreationWindow cw2 = new CreationWindow(testCrust);
		assertNotNull(cw2);
		
		//test trait value function
		int randomInt = cw2.getRandomTraitValue();
		assertNotNull(randomInt);
		assertTrue(randomInt >= -100 && randomInt <= 100);
		
		//test good format checker
		assertTrue(cw2.goodFormat("0"));
		assertTrue(cw2.goodFormat("53"));
		assertTrue(cw2.goodFormat("-89"));
		assertFalse(cw2.goodFormat("-101"));
		assertFalse(cw2.goodFormat("101"));
		assertFalse(cw2.goodFormat("AppleSauce"));
	}
	
	//test Personality Test Window
	@Test
	public void testTest(){
		//test constructor
		PersonalityTestWindow pt = new PersonalityTestWindow(testCrust);
		assertNotNull(pt);
		
		//test button setting function
		pt.setFromTest(testCrust, "warmth", 5);
		assertTrue(testCrust.get("warmth").equals("100"));
		pt.setFromTest(testCrust, "perfectionism", -2);
		assertTrue(testCrust.get("perfectionism").equals("-40"));
		pt.setFromTest(testCrust, "perfectionism", -6);
		assertTrue(testCrust.get("perfectionism").equals("-100"));
		pt.setFromTest(testCrust, "warminess", 3);
		assertTrue(testCrust.get("warmth").equals("100"));
	}
	
	//Test Ancient Pie window
	@Test
	public void testAP(){
		try {
			//test constructor
			testCrust.typeOfPie = CrustType.BLUEBERRYPIE;
			AncientPie ap = new AncientPie(testCrust);
			assertNotNull(ap);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//test help window
	@Test
	public void testHelp(){
		//test constructor
		HelpWindow hp = new HelpWindow();
		assertNotNull(hp);
	}
	
	//test Option Window
	@Test 
	public void testOption(){
		//test constructor
		OptionWindow ow = new OptionWindow();
		assertNotNull(ow);
		
		
	}
	
	//test Main window
	@Test
	public void testMain(){
		//test constructor
		try {
			testCrust.typeOfPie = CrustType.BLUEBERRYPIE;
			MainWindow mw = new MainWindow(testCrust);
			assertNotNull(mw);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
