package spaceshapes;

import java.awt.Color;

/** 
 * Interface to represent a type that offers primitive drawing methods.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public interface Painter {
	/**
	 * Draws a rectangle. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawRect(int x, int y, int width, int height);
	
	/**
	 * Draws an oval. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawOval(int x, int y, int width, int height);
	
	/**
	 * Draws a line. Parameters x1 and y1 specify the starting point of the 
	 * line, parameters x2 and y2 the ending point.
	 */
	public void drawLine(int x1, int y1, int x2, int y2);
	
	/**
	 * Fills a rectangle for DynamicShape class.
	 * @param x x-value of the top left corner point
	 * @param y y-value of the top left corner point
	 * @param width Width of the rectangle
	 * @param height Height of the rectangle
	 */
	
	public void fillRect(int x, int y, int width, int height);
	
	/**
	 * Set color of the painter
	 * @param c the color wants to be set
	 */
	
	public void setColor(Color c);
	
	/**
	 * Get the setted color of the painter
	 * @return the Color 
	 */
	
	public Color getColor();
	
	/**
	 * Translate the current coordinate system to (x,y) coordinate system
	 * @param x The x-value of the point.
	 * @param y The y-value of the point.
	 */
	
	public void translate(int x, int y);
	
	/**
	 * Draw the centred text of a shape
	 * @param str The text that wants to be drawn.
	 * @param width The width of the shape.
	 * @param height The height of the shape
	 */
	
	public void drawCentredText(String str, int width, int height);
}
