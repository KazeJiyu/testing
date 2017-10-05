/**
 * 
 */
package test.fr.ut2j.m1ice.ootesting;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import main.fr.ut2j.m1ice.ootesting.MyPoint;

/**
 * @author Mathilde LANNES
 * @author Emmanuel CHEBBI
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
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#MyPoint(double, double)}.
	 */
	@Test
	public void testMyPointDoubleDouble() {
		fail("Not yet implemented");
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
	public void point_x_can_be_set_and_get() {
		for( int x = -50 ; x < 50 ; ++x ) {
			point.setX(x);
			assertThat(point.getX(), is(x));
		}
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#setY(double)}.
	 */
	@Test
	public void point_y_can_be_set_and_get() {
		for( int x = - 50 ; x < 50 ; ++x ) {
			point.setX(x);
			assertThat(point.getX(), is(x));
		}
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#getX()}.
	 */
	@Test
	public void point_x_cannot_be_NaN() {
		double previous = point.getX();
		point.setX(Double.NaN);
		assertEquals(previous, point.getX(), 0.0001);
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#getY()}.
	 */
	@Test
	public void point_y_cannot_be_NaN() {
		double previous = point.getY();
		point.setY(Double.NaN);
		assertEquals(previous, point.getY(), 0.0001);
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
