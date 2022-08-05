
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import main.StdDev;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This is a test class for Standard Deviation
 * @author Aniket Tailor
 */
class StdDevTests {

	static StdDev sd;

	/**
	 * @author Aniket Tailor
	 * @throws Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sd = new StdDev();
	}

	/**
	 * This method tests the sum method
	 * @author Aniket Tailor
	 */
	@Test
	void testCalculateSum() {
		double[] testArray = {1,2,3};
		double sum = sd.calculateSum(testArray);
		assertEquals(6,sum);
	}

	/**
	 * This method tests the power method
	 * @author Aniket Tailor
	 */
	@Test
	void testPower() {
		assertEquals(8,sd.power(2, 3));
	}

	/**
	 * This method tests the CalculateVariance class
	 * @author Aniket Tailor
	 */
	@Test
	void testCalculateVariance() {
		double[] testArray = {1,2,3};
		double v = sd.calculateVariance(testArray, 2, 3);
		assertEquals(0.6666666666666666,v);
	}

	/**
	 * This method tests the CalculateVariance class for Population Standard Deviation
	 * @author Aniket Tailor
	 */
	@Test
	void testCalculateVariancePopulation() {
		double[] testArray = {1,2,3};
		double v = sd.calculateVariance(testArray, 2, 2);
		assertEquals(1,v);
	}

	/**
	 * This method tests the square root method.
	 * @author Aniket Tailor
	 */
	@Test
	void testSquareRoot() {
		assertEquals(2,sd.squareRoot(4));
	}
	
	/**
	 * This method tests the driver function (Main) with all possible combinations.
	 * @author Aniket Tailor
	 */
	@Test
	void testMain() {
		System.setIn(new ByteArrayInputStream("0 1 asd 4 12 asd xc 45 7 8".getBytes()));
		StdDev.main(null);
	}
	
	/**
	 * This method tests the driver function (Main) with same input values.
	 * @author Aniket Tailor
	 */
	@Test
	void testMainSameValues() {
		System.setIn(new ByteArrayInputStream("3 3 3 3".getBytes()));
		StdDev.main(null);
	}
}
