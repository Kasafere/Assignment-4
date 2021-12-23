import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestSTUDENT {

	ManagementCompany newManagement;

	Property prop1, prop2, prop3;

	private String propertyName = "Union Lot", city = "Jett City", owner = "Mocha";
	private double rentAmount = 5060.50;
	private int x = 5, y = 5, depth = 2, width = 2;

	@Before
	public void setUp() throws Exception {

		newManagement = new ManagementCompany("Kidus's Company", "826390263", 3);

		prop1 = new Property("Annapolis", "Maryland", 4844.00, "Derrick Taylor", 3, 4, 2, 2);
		prop2 = new Property("New York", "New York", 4114, "Cedar Mcneil", 6, 8, 2, 2);
		prop3 = new Property("La Mesa", "San Diego", 4905, "Ryan Nelson", 2, 1, 2, 2);
	}

	@After
	public void tearDown() {
		newManagement = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		prop1 = new Property(propertyName, city, rentAmount, owner, 0, 0, 1, 1);
		prop2 = new Property(propertyName, city, rentAmount, owner, x, y, depth, width);
		prop3 = new Property(propertyName, city, rentAmount, owner, 0, 0, 15, 15);
	}

	@Test
	public void testMaxRentProp() {
		assertEquals(newManagement.maxRentProp(), 0, 0);
	}

	@Test
	public void testTotalRent() {
		assertEquals(newManagement.totalRent(), 0, 0);
	}

}