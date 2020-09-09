package spaceshapes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Task 2
 * 
 * 
 * A class that implements test cases aimed at identifying bugs in the 
 * implementations of classes HexagonShape.
 * @author chenh
 *
 */
public class TestHexagonShape {
	// Fixture object that is used by the tests.
		private MockPainter _painter;
		
		
	/**
	 * This method is called automatically by the JUnit test-runner immediately
	 * before each @Test method is executed. setUp() recreates the fixture so 
	 * that there no side effects from running individual tests.
	 * @throws Exception
	 */
	@Before
	public void setUp(){
		_painter = new MockPainter();
	}
	
	/**
	 * Test to perform a simple normal (non-bouncing) movement, and to ensure that a
	 * Shape's position after the movement is correct.
	 */
	@Test
	public void testSimpleMoveWithNormalHexagon() {
		HexagonShape shape = new HexagonShape(100, 20, 12, 15, 60, 60);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(line 100,50,120,20)(line 120,20,140,20)(line 140,20,160,50)(line 160,50,140,80)(line 140,80,120,80)(line 120,80,100,50)"
				+ "(line 112,65,132,35)(line 132,35,152,35)(line 152,35,172,65)(line 172,65,152,95)(line 152,95,132,95)(line 132,95,112,65)", 
				_painter.toString());
	}
	
	/**
	 * Test to perform a simple small (non-bouncing) movement, and to ensure that a
	 * Shape's position after the movement is correct.
	 */
	@Test
	public void testSimpleMoveWithSmallHexagon() {
		HexagonShape shape = new HexagonShape(100, 20, 12, 15, 30, 30);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(line 100,35,115,20)(line 115,20,130,35)(line 130,35,115,50)(line 115,50,100,35)"
				+ "(line 112,50,127,35)(line 127,35,142,50)(line 142,50,127,65)(line 127,65,112,50)", 
				_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the right-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 * (In order to simplify the test, use small hexagons.)
	 */
	@Test
	public void testShapeMoveWithBounceOffRight() {
		HexagonShape shape = new HexagonShape(100, 20, 100, 0, 30, 30);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		assertEquals("(line 100,35,115,20)(line 115,20,130,35)(line 130,35,115,50)(line 115,50,100,35)"
				+ "(line 105,35,120,20)(line 120,20,135,35)(line 135,35,120,50)(line 120,50,105,35)"
				+ "(line 5,35,20,20)(line 20,20,35,35)(line 35,35,20,50)(line 20,50,5,35)", _painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the left-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 * (In order to simplify the test, use small hexagons.)
	 */
	@Test
	public void testShapeMoveWithBounceOffLeft() {
		HexagonShape shape = new HexagonShape(100, 20, -100, 0, 30, 30);
		shape.paint(_painter);
		shape.move(150, 10000);
		shape.paint(_painter);
		shape.move(150, 10000);
		shape.paint(_painter);
		assertEquals("(line 100,35,115,20)(line 115,20,130,35)(line 130,35,115,50)(line 115,50,100,35)"
				+ "(line 0,35,15,20)(line 15,20,30,35)(line 30,35,15,50)(line 15,50,0,35)"
				+ "(line 100,35,115,20)(line 115,20,130,35)(line 130,35,115,50)(line 115,50,100,35)", _painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the bottom right corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffBottomAndRight() {
		HexagonShape shape = new HexagonShape(80, 80, -100, 100, 30, 30);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		assertEquals("(line 80,95,95,80)(line 95,80,110,95)(line 110,95,95,110)(line 95,110,80,95)"
				+ "(line 0,120,15,105)(line 15,105,30,120)(line 30,120,15,135)(line 15,135,0,120)"
				+ "(line 95,20,110,5)(line 110,5,125,20)(line 125,20,110,35)(line 110,35,95,20)", _painter.toString());
	}
}
