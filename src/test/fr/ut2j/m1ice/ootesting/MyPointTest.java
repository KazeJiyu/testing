/**
 * 
 */
package test.fr.ut2j.m1ice.ootesting;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import main.fr.ut2j.m1ice.ootesting.MyPoint;

/**
 * @author Mathilde LANNES
 * @author Emmanuel CHEBBI
 */
@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyPointTest {
	@Parameters
		public static List<MyPoint> points() {
			return Arrays.asList(new MyPoint(0d, 0d), new MyPoint(5.873, -3.8764));
			// return Arrays.asList(new Object[][] {
			// {0d, 0d}, {1d, 1d}, {2.4353, 1.2435}, {-3.654, Double.NaN}, null, {6d, 8d}});
	}
	
	MyPoint ORIGIN;
	MyPoint point;
	
	public MyPointTest(MyPoint newPoint) {
		this.point = newPoint;
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ORIGIN = new MyPoint();
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
	 * TODO for with random numbers
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
		assertEquals(point, new MyPoint(point));
	}
	
	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#MyPoint(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test(expected = NullPointerException.class)
	public void testMyPointMyPointWithNull() {
		new MyPoint(null);
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#setX(double)}.
	 */
	@Test
	public void point_x_can_be_set_and_get() {
		for( int x = -50 ; x < 50 ; ++x ) {
			point.setX(x);
			assertEquals(x, point.getX(), 0.0001);
		}
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#setY(double)}.
	 */
	@Test
	public void point_y_can_be_set_and_get() {
		for( int y = - 50 ; y < 50 ; ++y ) {
			point.setY(y);
			assertEquals(y, point.getY(), 0.0001);
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
	public void scale_does_not_alter_point() {
		MyPoint previous = new MyPoint(point);
		
		for( double i = -10 ; i < 10 ; ++i ) {
			point.scale(i);
			assertThat(previous, is(point));
		}
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#scale(double)}.
	 */
	@Test
	public void scale_returns_a_scaled_point() {
		for( double i = -10 ; i < 10 ; ++i ) {
			MyPoint scaled = point.scale(i);
			MyPoint expected = new MyPoint(point.getX() * i, point.getY() * i);
					
			assertThat(scaled, is(expected));
		}
	}
	
	
	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#horizontalSymmetry(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testHorizontalSymmetryThrowsException() {
		point.horizontalSymmetry(null);
	}
	
	
	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#horizontalSymmetry(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test
	public void testHorizontalSymmetry() {
		MyPoint origin = new MyPoint(2d, 5d);
		assertEquals(new MyPoint(-2d, 5d), origin.horizontalSymmetry(ORIGIN));
		
		for( double i = -10 ; i < 10 ; ++i ) {
			MyPoint symmetry = point.horizontalSymmetry(new MyPoint(i, 5.356));
			MyPoint expected = new MyPoint(2d * i - point.getX(), point.getY());
					
			assertThat(symmetry, is(expected));
		}
	}
	
	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#horizontalSymmetry(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test
	public void testHorizontalSymmetryIsntVerticalAsWell() {
		for( double i = -10 ; i < 10 ; ++i ) {
			MyPoint symmetry = point.horizontalSymmetry(new MyPoint(i, 5.356));
			assertEquals(symmetry.getY(), point.getY(), 0.0001);
		}
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#computeAngle(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test
	public void compute_angle_does_not_alter_point() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#computeAngle(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test
	public void compute_angle_returns_NaN_on_null() {
		assertThat(point.computeAngle(null), is(Double.NaN));
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#rotatePoint(main.fr.ut2j.m1ice.ootesting.MyPoint, double)}.
	 */
	@Test
	public void testRotatePointOnNull() {
		assertEquals(point.rotatePoint(null, 0d), null);
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#centralSymmetry(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test
	public void testCentralSymmetry() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#centralSymmetry(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCentralSymmetryThrowsException() {
		point.centralSymmetry(null);
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#centralSymmetry(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void central_symmetry_throws_on_null() {
		point.centralSymmetry(null);
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#getMiddlePoint(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test
	public void testGetMiddlePoint() {
		MyPoint otherPoint = new MyPoint(6d, 8.45646);
		MyPoint expected = new MyPoint((point.getX() + otherPoint.getX()) / 2d, (point.getY() + otherPoint.getY()) / 2d);
		assertEquals(expected, point.getMiddlePoint(otherPoint));
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
