package fr.xebia.mowitnow.model.test;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.xebia.mowitnow.model.Area;
import fr.xebia.mowitnow.model.Direction;
import fr.xebia.mowitnow.model.Position;


/**
 * 
 */

/**
 * @author TIFAKAM
 * 
 */
public class AreaTest {

	private Area area;



	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		area = new Area(5, 5);
	}



	/**
	 * Test method for
	 * {@link fr.xebia.mowitnow.model.Area#containsPosition(fr.xebia.mowitnow.model.Position)}.
	 */
	@Test
	public void testContainsPosition() {



		Position position = new Position(5, 5, Direction.NORTH);
		assertEquals(true, area.containsPosition(position));

		position.setX(6);
		assertEquals(false, area.containsPosition(position));


		position.setX(-1);
		assertEquals(false, area.containsPosition(position));

	}



	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {

		area = null;
	}

}
