package spaceshapes;

import java.awt.Color;

/**
 * Implementation of the Painter interface that does not actually do any
 * painting. A MockPainter implementation responds to Painter requests by
 * logging simply logging them. The contents of a MockPainter object's
 * log can be retrieved by a call to toString() on the MockPainter.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public class MockPainter implements Painter {
	
	protected String _shapeColorStr;
	
	private Color _shapeColor;
	// Internal log.
	private StringBuffer _log = new StringBuffer();

	/**
	 * Returns the contents of this MockPainter's log.
	 */
	public String toString() {
		return _log.toString();
	}

	/**
	 * Logs the drawRect call.
	 */
	public void drawRect(int x, int y, int width, int height) {
		_log.append("(rectangle " + x + "," + y + "," + width + "," + height + ")");
	}
	
	/**
	 * Logs the drawOval call.
	 */
	public void drawOval(int x, int y, int width, int height) {
		_log.append("(oval " + x + "," + y + "," + width + "," + height + ")");
	}

	/**
	 * Logs the drawLine call.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_log.append("(line " + x1 + "," + y1 + "," + x2 + "," + y2 + ")");
	}

	/**
	 * Logs the fillRect call.
	 */
	public void fillRect(int x, int y, int width, int height) {
		_log.append("(filled rectangle " + x + "," + y + "," + width + "," + height + ")");
		
	}

	/**
	 * Set the color for this painter.
	 */
	public void setColor(Color c) {
		_shapeColorStr = c.toString();
		_shapeColor = c;
	}


	/**
	 * Get the color for this painter.
	 */
	public Color getColor() {
		return _shapeColor;
	}
	/**
	 * An empty method for this painter.
	 * The original method is to translate the coordinate of the painter.
	 */
	public void translate(int x, int y) {
		
	}
	
	/**
	 * An empty method for this painter.
	 * The original method is to display the text of the shape.
	 */
	public void drawCentredText(String str, int x, int y) {
		
	}
}