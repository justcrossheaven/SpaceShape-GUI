package spaceshapes;

import java.util.ArrayList;

/**
 * Task 4
 * 
 * Class to represent a carrier space-shape that can carry several space-shapes.
 * 
 * Uses composite design pattern
 * @author chenh
 *
 */
public class CarrierShape extends Shape {
	
	// === Instance variables, accessible by subclasses.
	protected ArrayList<Shape> _shapeList = new ArrayList<Shape>();
	// ===
	
	/**
	 * Creates a CarrierShape object with default values for state.
	 */
	public CarrierShape() {
		super();
	}
	
	/**
	 * Creates a CarrierShape object with specified location values,
	 * default values for other state items.
	 */
	public CarrierShape(int x, int y) {
		super(x, y);
	}
	
	/**
	 * Creates a CarrierShape with specified values for location, velocity
	 * and direction. Nonspecified state items take on default values.
	 */
	public CarrierShape(int x, int y, int deltaX, int deltaY) {
		super(x, y, deltaX, deltaY);
	}
	
	/**
	 * Creates a CarrierShape with specified values for location, velocity,
	 * direction, width and height.
	 */
	public CarrierShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x, y, deltaX, deltaY, width, height);
	}
	
	/**
	 * Moves a CarrierShape object (including its children) within the bounds.
	 * specified by arguments width and height. 
	 */
	public void move(int width, int height) {
		int nextX = _x + _deltaX;
		int nextY = _y + _deltaY;

		if (nextX <= 0) {
			nextX = 0;
			_deltaX = -_deltaX;
		} else if (nextX + _width >= width) {
			nextX = width - _width;
			_deltaX = -_deltaX;
		}

		if (nextY <= 0) {
			nextY = 0;
			_deltaY = -_deltaY;
		} else if (nextY + _height >= height) {
			nextY = height - _height;
			_deltaY = -_deltaY;
		}

		_x = nextX;
		_y = nextY;
	}
	
	/**
	 * Paints a CarrierShape object by drawing a rectangle around the edge of
	 * its bounding box. The CarrierShape object's children are then painted.
	 */
	public void paint(Painter painter) {
		painter.drawRect(_x, _y, _width, _height);
		painter.translate(_x, _y);
		for (Shape s : _shapeList) {
			s.move(_width, _height);
			s.paint(painter);
		}
		painter.translate(-_x, -_y);
	}
	
	/**
	 * Attempts to add a Shape to a CarrierShape object . If successful, a
	 * two-way link is established between the CarrierShape and the newly
	 * added Shape. Note that this method has package visibility--for reasons
	 * that will become apparent in Space-Shape III 
	 * @param shape the shape to be added
	 * @throws IllegalArgumentException if an attempt is made to add a Shape
	 * to a CarrierShape instance where the Shape argument is already a child
	 * within a CarrierShape instance. An IllegalArgumentException is also
	 * thrown when an attempt is made to add a Shape that will not fit within
	 * the bounds of the proposed CarrierShape object. 
	 */
	void add(Shape shape) throws IllegalArgumentException {
		int xpos = shape.x();
		int ypos = shape.y();
		int swidth = shape.width();
		int sheight = shape.height();
		if((shape._parent!=null)||xpos<0||ypos<0||(xpos+swidth)>_width||(ypos+sheight)>_height) {
			throw new IllegalArgumentException();
		}
		_shapeList.add(shape);
		shape._parent = this;
	}
	
	/**
	 *Removes a particular Shape from a CarrierShape instance. Once removed,
	 *the two-way link between the CarrierShape and its former child is
	 *destroyed. This method has no effect if the Shape specified to remove
	 *is not a child of the CarrierShape. Note that this method has package
	 *visibility -- for reasons that will become apparent in Space-Shape III.
	 *@param shape th e shape to be removed.
	 */
	void remove(Shape shape) {
		_shapeList.remove(shape);
		shape._parent = null;
	}
	
	/**
	 * Returns the number of children contained within a CarrierShape object .
	 * Note this method is not recursive -- it simply returns the number of
	 * children at the top level within the called CarrierShape object.
	 */
	public int shapeCount(){
		return _shapeList.size();
	}
	
	/**
	 * Returns the Shape at a  specified position within a CarrierShape. If
	 * the position specified is less than zero or greater than the number of
	 * children stored in the CarrierShape less one  this method throws an
	 * IndexOutOfBoundsException
	 * @param index the specified index position.
	 */
	public Shape shapeAt(int index) throws IndexOutOfBoundsException {
		return _shapeList.get(index);
	}
	
	/**
	 * Returns the index of a specified child within a CarrierShape object.
	 * If the Shape specified is not actually a child of the CarrierShape
	 * this method returns -1; otherwise the value returned is in the range
	 * 0 ... shapeCount()-1.
	 * @param the shape whose index position within the CarrierShape is
	 * requested.
	 */
	public int indexOf(Shape shape) {
		return _shapeList.indexOf(shape);
	}
	
	/**
	 * Returns true if the Shape argument is a child of the CarrierShape
	 * object on which this method is called, false otherwise.
	 */
	public boolean contains(Shape shape) {
		return _shapeList.contains(shape);
	}

}
