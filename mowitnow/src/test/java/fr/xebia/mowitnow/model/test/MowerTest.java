/**
 * 
 */
package fr.xebia.mowitnow.model.test;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.xebia.mowitnow.model.Area;
import fr.xebia.mowitnow.model.Direction;
import fr.xebia.mowitnow.model.Mower;
import fr.xebia.mowitnow.model.Position;


/**
 * @author TIFAKAM
 * 
 */
public class MowerTest {


	private Mower mower;



	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		Area area = new Area(5, 5);
		Position position = new Position(1, 1, Direction.NORTH);
		mower = new Mower(area, position);

	}



	/**
	 * Test method for {@link fr.xebia.mowitnow.model.Mower#pivotToRight()}.
	 */
	@Test
	public void testPivotToRight() {

		mower.pivotToRight();
		assertEquals("1 1 E", mower.toString());

		mower.pivotToRight();
		assertEquals("1 1 S", mower.toString());


		mower.pivotToRight();
		assertEquals("1 1 W", mower.toString());

	}



	/**
	 * Test method for {@link fr.xebia.mowitnow.model.Mower#pivotToLeft()}.
	 */
	@Test
	public void testPivotToLeft() {

		mower.pivotToLeft();
		assertEquals("1 1 W", mower.toString());

		mower.pivotToLeft();
		assertEquals("1 1 S", mower.toString());


		mower.pivotToLeft();
		assertEquals("1 1 E", mower.toString());

	}



	/**
	 * Test method for {@link fr.xebia.mowitnow.model.Mower#goForward()}.
	 */
	@Test
	public void testGoForward() {


		mower.goForward();
		assertEquals("1 2 N", mower.toString());

		mower.goForward();
		assertEquals("1 3 N", mower.toString());

		mower.setPosition(new Position(5, 5, Direction.EAST));
		mower.goForward();
		assertEquals("5 5 E", mower.toString());
	}



	/**
	 * Test method for {@link fr.xebia.mowitnow.model.Mower#doAction(java.lang.String)}.
	 */
	@Test
	public void testDoAction() {

		mower.doAction("D");
		assertEquals("1 1 E", mower.toString());
		
		
		mower.doAction("G");
		assertEquals("1 1 N", mower.toString());
		
		
		mower.doAction("A");
		assertEquals("1 2 N", mower.toString());
		
		mower.doAction("X");
		assertEquals("1 2 N", mower.toString());
	}



	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {

		mower = null;
	}



}
