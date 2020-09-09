package spaceshapes;

import java.awt.Color;
/**
 * Task 3
 * 
 * Class to represent a simple rectangular dynamic space-shape.
 * 
 * Uses Template Method pattern.
 * @author chenh
 *
 */
public class DynamicShape extends Shape {
	
	protected static final Color DEFAULT_COLOR = Color.WHITE;
	private static final Color _c = new Color(212, 212, 212);
	private Color _constantColor;
	private boolean _ChangeColor;
	
	/**
	 * Default constructor that creates a DynamicShape instance whose instance
	 * variables are set to default values.
	 */
	public DynamicShape() {
		super();
		_constantColor = DEFAULT_COLOR;
	}
	
	/**
	 * Creates a DynamicShape object with a specified x and y position.
	 * @param x x position.
	 * @param y y position.
	 */
	public DynamicShape(int x, int y, Color c) {
		super(x,y);
	}
	/**
	 * Creates a DynamicShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed and direction for horizontal axis.
	 * @param deltaY speed and direction for vertical axis.
	 * @param c Color of the shape
	 */
	public DynamicShape(int x, int y, int deltaX, int deltaY, Color c) {
		super(x,y,deltaX,deltaY);
		_constantColor = c;
	}
	
	/**
	 * Creates a DynamicShape instance with specified values for instance 
	 * variables.
	 * @param x x position.
	 * @param y y position.
	 * @param deltaX speed (pixels per move call) and direction for horizontal 
	 *        axis.
	 * @param deltaY speed (pixels per move call) and direction for vertical 
	 *        axis.
	 * @param width width in pixels.
	 * @param height height in pixels.
	 * @param c Color of the shape
	 */
	public DynamicShape(int x, int y, int deltaX, int deltaY, int width, int height, Color c) {
		super(x,y,deltaX,deltaY,width,height);
		_constantColor = c;
	}
	
	/**
	 * Paints this DynamicShape object using the supplied Painter object.
	 */
	public void paint(Painter painter) {
		painter.drawRect(_x, _y, _width, _height);
		painter.setColor(_constantColor);
		if (_ChangeColor) {
			painter.fillRect(_x,_y,_width,_height);
		}
		painter.setColor(_c);
	}
	
	@Override
	/**
	 * Moves this DynamicShape object within the specified bounds. On hitting a 
	 * boundary the Shape instance bounces off and back into the two- 
	 * dimensional world. 
	 * The color of the shape will change once the it reaches the left or right wall.
	 * And will look like a normal rectangle shape when it hits top or bottom wall.
	 * 
	 * This method is overriden from the method in spaceshapes.Shape.move
	 * @param width - width of two-dimensional world.
	 * @param height - height of two-dimensional world.
	 */
	public void move(int width, int height) {
		int nextX = _x + _deltaX;
		int nextY = _y + _deltaY;

		if (nextX <= 0) {
			nextX = 0;
			_deltaX = -_deltaX;
			_ChangeColor = true;
			
		} else if (nextX + _width >= width) {
			nextX = width - _width;
			_deltaX = -_deltaX;
			_ChangeColor = true;
		}

		if (nextY <= 0) {
			nextY = 0;
			_deltaY = -_deltaY;
			_ChangeColor = false;
		} else if (nextY + _height >= height) {
			nextY = height - _height;
			_deltaY = -_deltaY;
			_ChangeColor = false;
		}

		_x = nextX;
		_y = nextY;
	}
}
