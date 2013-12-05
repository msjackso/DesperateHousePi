package desperatehousepi.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import desperatehousepi.Crust.Crust;
import desperatehousepi.Crust.Need;

public class TestNeed {
	
	@Test
	public void testNeed() {
		Need tNeed = new Need("Test", 1);
		assertNotNull(tNeed);
	}

}
