package spaceshapes;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

/**
 * Task 3
 * 
 * A class that implements test cases aimed at identifying bugs in the 
 * implementations of class DynamicShape.
 * 
 * @author chenh
 *
 */
public class TestDynamicShape {

	// Fixture object that is used by the tests.
	private MockPainter _painter;
	/**
	 * This method is called automatically by the JUnit test-runner immediately
	 * before each @Test method is executed. setUp() recreates the fixture so 
	 * that there no side effects from running individual tests.
	 */
	@Before
	public void setUp() {
		_painter = new MockPainter();
	}
	
	/**
	 * Test to perform a simple (non-bouncing) movement, and to ensure that a
	 * Shape's position after the movement is correct.
	 */
	@Test
	public void testSimpleMove() {
		DynamicShape shape = new DynamicShape(100, 20, 12, 15, Color.black);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		assertEquals("(rectangle 100,20,25,35)(rectangle 112,35,25,35)", 
				_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the bottom boundary and to
	 * ensure that the Shape's position and state (whether is is filled) after the movement is correct.
	 */
	@Test
	public void testBouncingMoveBottom() {
		DynamicShape shape = new DynamicShape(100,200,0,200,Color.black);
		shape.paint(_painter);
		shape.move(300, 300);
		shape.paint(_painter);
		assertEquals("(rectangle 100,200,25,35)(rectangle 100,265,25,35)", 
				_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the top boundary and to
	 * ensure that the Shape's position and state (whether is is filled) after the movement is correct.
	 */
	@Test
	public void testBouncingMoveTop() {
		DynamicShape shape = new DynamicShape(100,200,0,-465,Color.black);
		shape.paint(_painter);
		shape.move(300, 300);
		shape.paint(_painter);
		shape.move(300, 300);
		shape.paint(_painter);
		assertEquals("(rectangle 100,200,25,35)(rectangle 100,0,25,35)(rectangle 100,265,25,35)", 
				_painter.toString());
	}
	
	/**
	 * Test to perform a bounce movement off the right-most boundary and to
	 * ensure that the Shape's position and state (whether is is filled) after the movement is correct.
	 */
	@Test
	public void testBouncingMoveRight() {
		DynamicShape shape = new DynamicShape(200,100,200,0,Color.black);
		shape.paint(_painter);
		shape.move(300, 300);
		shape.paint(_painter);
		assertEquals("(rectangle 200,100,25,35)(rectangle 275,100,25,35)(filled rectangle 275,100,25,35)", 
				_painter.toString());
		assertEquals(new Color(212,212,212), _painter.getColor());
		
		
	}
	
	/**
	 * Test to perform a bounce movement off the left-most boundary and to
	 * ensure that the Shape's position and state (whether is is filled) after the movement is correct.
	 */
	@Test
	public void testBouncingMoveLeft() {
		DynamicShape shape = new DynamicShape(200,100,-400,0,Color.black);
		shape.paint(_painter);
		shape.move(300, 300);
		shape.paint(_painter);
		assertEquals("(rectangle 200,100,25,35)(rectangle 0,100,25,35)(filled rectangle 0,100,25,35)", 
				_painter.toString());
		assertEquals(new Color(212,212,212), _painter.getColor());
	}
	
	/**
	 * Test to perform a bounce movement off the top-right corner and to
	 * ensure that the Shape's position and state (whether is is filled) after the movement is correct.
	 */
	@Test
	public void testBouncingMoveTopRight() {
		DynamicShape shape = new DynamicShape(200,200,400,-400,40,40,Color.black);
		shape.paint(_painter);
		shape.move(300, 300);
		shape.paint(_painter);
		shape.move(300, 300);
		shape.paint(_painter);
		assertEquals("(rectangle 200,200,40,40)(rectangle 260,0,40,40)(rectangle 0,260,40,40)", 
				_painter.toString());
		assertEquals(new Color(212,212,212), _painter.getColor());
	}
	
	/**
	 * Test to perform a bounce movement off the top-left corner and to
	 * ensure that the Shape's position and state (whether is is filled) after the movement is correct.
	 */
	@Test
	public void testBouncingMoveTopLeft() {
		DynamicShape shape = new DynamicShape(200,200,-400,-400,40,40,Color.black);
		shape.paint(_painter);
		shape.move(300, 300);
		shape.paint(_painter);
		shape.move(300, 300);
		shape.paint(_painter);
		assertEquals("(rectangle 200,200,40,40)(rectangle 0,0,40,40)(rectangle 260,260,40,40)", 
				_painter.toString());
		assertEquals(new Color(212,212,212), _painter.getColor());
	}
	
	/**
	 * Test to perform a bounce movement off the bottom-right corner and to
	 * ensure that the Shape's position and state (whether is is filled) after the movement is correct.
	 */
	@Test
	public void testBouncingMoveBottomRight() {
		DynamicShape shape = new DynamicShape(200,200,400,400,40,40,Color.black);
		shape.paint(_painter);
		shape.move(300, 300);
		shape.paint(_painter);
		shape.move(300, 300);
		shape.paint(_painter);
		assertEquals("(rectangle 200,200,40,40)(rectangle 260,260,40,40)(rectangle 0,0,40,40)", 
				_painter.toString());
		assertEquals(new Color(212,212,212), _painter.getColor());
	}
	
	/**
	 * Test to perform a bounce movement off the bottom-left corner and to
	 * ensure that the Shape's position and state (whether is is filled) after the movement is correct.
	 */
	@Test
	public void testBouncingMoveBottomLeft() {
		DynamicShape shape = new DynamicShape(200,200,-400,400,40,40,Color.black);
		shape.paint(_painter);
		shape.move(300, 300);
		shape.paint(_painter);
		shape.move(300, 300);
		shape.paint(_painter);
		assertEquals("(rectangle 200,200,40,40)(rectangle 0,260,40,40)(rectangle 260,0,40,40)", 
				_painter.toString());
		assertEquals(new Color(212,212,212), _painter.getColor());
	}


}
