package test;

import static org.junit.jupiter.api.Assertions.*;
import main.StdDev;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StdDevTests {

	static StdDev sd;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sd = new StdDev();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculateSum() {
		double[] testArray = {1,2,3};
		double sum = sd.CalculateSum(testArray);
		assertEquals(6,sum);
	}
	
	@Test
	void testPower() {
		assertEquals(8,sd.power(2, 3));
	}
	
	@Test
	void testCalculateVariance() {
		double[] testArray = {1,2,3};
		double v = sd.calculateVariance(testArray, 2, 3);
		assertEquals(0.6666666666666666,v);
	}
	
	@Test
	void testCalculateVariancePopulation() {
		double[] testArray = {1,2,3};
		double v = sd.calculateVariance(testArray, 2, 2);
		assertEquals(1,v);
	}
	
	@Test
	void testSquareRoot() {
		assertEquals(2,sd.squareRoot(4));
	}
}
