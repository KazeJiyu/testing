/**
 * 
 */
package test.fr.ut2j.m1ice.ootesting;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import main.fr.ut2j.m1ice.ootesting.MyPoint;

/**
 * @author Kaze
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyPointTest {
	MyPoint point;
	MyPoint point2;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		point = new MyPoint();
		point2 = new MyPoint(3, 4);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#MyPoint()}.
	 */
	@Test
	public void testMyPoint() {
		MyPoint testPoint = new MyPoint();
		assertEquals(0d, testPoint.getX(), 0.0001);
		assertEquals(0d, testPoint.getY(), 0.0001);
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#MyPoint(double, double)}.
	 */
	@Test
	public void testMyPointDoubleDouble() {
		MyPoint testPointDouble = new MyPoint(2d, 5.8754);
		assertEquals(2d, testPointDouble.getX(), 0.0001);
		assertEquals(5.8754, testPointDouble.getY(), 0.0001);
		
		MyPoint testPointDouble2 = new MyPoint(-0.34567, Double.NaN);
		assertEquals(-0.34567, testPointDouble2.getX(), 0.0001);
		assertEquals(Double.NaN, testPointDouble2.getY(), 0.0001);
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#MyPoint(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test
	public void testMyPointMyPoint() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#setX(double)}.
	 */
	@Test
	public void testSetX() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#setY(double)}.
	 */
	@Test
	public void testSetY() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#getX()}.
	 */
	@Test
	public void testGetX() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#getY()}.
	 */
	@Test
	public void testGetY() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#scale(double)}.
	 */
	@Test
	public void testScale() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#horizontalSymmetry(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test
	public void testHorizontalSymmetry() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#computeAngle(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test
	public void testComputeAngle() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#rotatePoint(main.fr.ut2j.m1ice.ootesting.MyPoint, double)}.
	 */
	@Test
	public void testRotatePoint() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#centralSymmetry(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test
	public void testCentralSymmetry() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#getMiddlePoint(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test
	public void testGetMiddlePoint() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#translate(double, double)}.
	 */
	@Test
	public void testTranslateDoubleDouble() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#setPoint(java.util.Random, java.util.Random)}.
	 */
	@Test
	public void testSetPoint() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#translate(main.fr.ut2j.m1ice.ootesting.ITranslation)}.
	 */
	@Test
	public void testTranslateITranslation() {
		fail("Not yet implemented");
	}

}
