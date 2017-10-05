/**
 * 
 */
package test.fr.ut2j.m1ice.ootesting;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import main.fr.ut2j.m1ice.ootesting.ITranslation;
import main.fr.ut2j.m1ice.ootesting.MyPoint;

/**
 * @author Mathilde LANNES
 * @author Emmanuel CHEBBI
 */
@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyPointTest {
	
	@Parameters
	public static List<Double[]> points() {
		return Arrays.asList( new Double[][] {
				{0d, 0d}, 
				{-6.21, 4.12}, {5.873, -3.8764},
				{12d,34.4d}, {-7d, -5.24}
		});
	}
	
	private MyPoint ORIGIN;
	private MyPoint point;
	private final Double[] coordinates;
	
	@Mock
	private Random rand1Mock;
	
	@Mock
	private Random rand2Mock;
	
	@Mock
	private ITranslation translation;
	
	public MyPointTest(double x, double y) {
		this.coordinates = new Double[] {x, y};
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ORIGIN = new MyPoint(0,0);
		point = new MyPoint(coordinates[0], coordinates[1]);
		
		// Init mocks
		MockitoAnnotations.initMocks(this);
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
		Random r = new Random();
		
		for( int i = 0 ; i < 50 ; ++i ) {
			double x = r.nextDouble() * (r.nextBoolean() ? 1 : -1);
			double y = r.nextDouble() * (r.nextBoolean() ? 1 : -1);
			
			MyPoint point = new MyPoint(x,y);
			assertEquals(x, point.getX(), 0.0001);
			assertEquals(y, point.getY(), 0.0001);
		}
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
	public void horizontalSymmetry_throws_exception_on_null() {
		point.horizontalSymmetry(null);
	}
	
	
	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#horizontalSymmetry(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test
	public void horizontalSymmetry() {
		MyPoint origin = new MyPoint(2d, 5d);
		assertEquals(new MyPoint(-2d, 5d), origin.horizontalSymmetry(ORIGIN));
		
		for( double i = -10 ; i < 10 ; ++i ) {
			MyPoint symmetry = point.horizontalSymmetry(new MyPoint(i, 5.356));
			MyPoint expected = new MyPoint(2d * i - point.getX(), point.getY());
					
			assertThat(symmetry, is(expected));
		}
	}
	
	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#computeAngle(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test
	public void computeAngle_does_not_alter_point() {
		MyPoint previous = point;
		point.computeAngle(new MyPoint(4,5));
		assertThat(previous, is(point));
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#computeAngle(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test
	public void computeAngle_returns_NaN_on_null() {
		assertThat(point.computeAngle(null), is(Double.NaN));
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#computeAngle(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test
	public void computeAngle() {
		MyPoint onTop = new MyPoint(point.getX(), point.getY() + 50);
		MyPoint onRight = new MyPoint(point.getX() + 12, point.getY());
		MyPoint onBottom = new MyPoint(point.getX(), point.getY() - 12);
		MyPoint onLeft = new MyPoint(point.getX() - 50, point.getY());

		assertEquals(Math.PI / 2, point.computeAngle(onTop), 0.0001);
		assertEquals(0, point.computeAngle(onRight), 0.0001);
		assertEquals(Math.PI / -2, point.computeAngle(onBottom), 0.0001);
		assertEquals(Math.PI, point.computeAngle(onLeft), 0.0001);
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#rotatePoint(main.fr.ut2j.m1ice.ootesting.MyPoint, double)}.
	 */
	@Test
	public void rotatePoint_returns_null_on_null() {
		assertEquals(point.rotatePoint(null, 0d), null);
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#rotatePoint(main.fr.ut2j.m1ice.ootesting.MyPoint, double)}.
	 */
	@Test
	public void rotatePoint_by_0_returns_points() {
		assertEquals(point, point.rotatePoint(ORIGIN, 0d));
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#rotatePoint(main.fr.ut2j.m1ice.ootesting.MyPoint, double)}.
	 */
	@Test
	public void rotatePoint_by_PI() {
		assertEquals(new MyPoint(-point.getX(), -point.getY()), point.rotatePoint(ORIGIN, Math.PI));
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#rotatePoint(main.fr.ut2j.m1ice.ootesting.MyPoint, double)}.
	 */
	@Test
	public void rotatePoint_by_neg_PI() {
		assertEquals(new MyPoint(-point.getX(), -point.getY()), point.rotatePoint(ORIGIN, -Math.PI));
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#rotatePoint(main.fr.ut2j.m1ice.ootesting.MyPoint, double)}.
	 */
	@Test
	public void rotatePoint_by_PI_on_2() {
		assertEquals(new MyPoint(-point.getY(), point.getX()), point.rotatePoint(ORIGIN, Math.PI/2));
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#rotatePoint(main.fr.ut2j.m1ice.ootesting.MyPoint, double)}.
	 */
	@Test
	public void rotatePoint_by_3PI_on_2() {
		assertEquals(new MyPoint(point.getY(), -point.getX()), point.rotatePoint(ORIGIN, (3 * Math.PI)/2));
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#rotatePoint(main.fr.ut2j.m1ice.ootesting.MyPoint, double)}.
	 *
	 * TODO Formula taken from Wikipedia. Test various values should be better, but ....
	 */
	@Test
	public void rotatePoint_by_random_angle() {
		final double angle = 1.72;
		MyPoint expected = new MyPoint(
			point.getX() * cos(angle) - point.getY() * sin(angle),
			point.getX() * sin(angle) + point.getY() * cos(angle));
		assertEquals(expected, point.rotatePoint(ORIGIN, angle));
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#centralSymmetry(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 *
	 * TODO Tests should be performed with different origins...
	 */
	@Test
	public void centralSymmetry_against_origin_returns_opposite_point() {
		MyPoint expected = point.rotatePoint(ORIGIN, Math.PI);
		assertEquals(expected, point.centralSymmetry(ORIGIN));
	}
	
	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#centralSymmetry(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void centralSymmetry_throws_on_null() {
		point.centralSymmetry(null);
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#getMiddlePoint(main.fr.ut2j.m1ice.ootesting.MyPoint)}.
	 */
	@Test
	public void middlePoint() {
		MyPoint otherPoint = new MyPoint(6d, 8.45646);
		MyPoint expected = new MyPoint((point.getX() + otherPoint.getX()) / 2d, (point.getY() + otherPoint.getY()) / 2d);
		assertEquals(expected, point.getMiddlePoint(otherPoint));
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#translate(double, double)}.
	 */
	@Test
	public void translate_works_on_doubles() {
		final double xTranslation = -5;
		final double yTranslation = 53;
		
		MyPoint expected = new MyPoint(point.getX() + xTranslation, 
									   point.getY() + yTranslation);
		
		point.translate(xTranslation, yTranslation);
		assertEquals(expected, point);
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#setPoint(java.util.Random, java.util.Random)}.
	 */
	@Test
	public void setPoint_uses_given_objects() {
		MyPoint expected = new MyPoint(12,-5);
		
		when(rand1Mock.nextInt()).thenReturn((int) expected.getX());
		when(rand2Mock.nextInt()).thenReturn((int) expected.getY());
		
		point.setPoint(rand1Mock, rand2Mock);
		assertEquals(expected, point);
	}

	/**
	 * Test method for {@link main.fr.ut2j.m1ice.ootesting.MyPoint#translate(main.fr.ut2j.m1ice.ootesting.ITranslation)}.
	 */
	@Test
	public void translate_works_on_translations() {
		when(translation.getTx()).thenReturn(5);
		when(translation.getTy()).thenReturn(10);
		
		MyPoint expected = new MyPoint(point.getX() + 5, point.getY() + 10);
		point.translate(translation);
		assertEquals(expected, point);
	}

}
