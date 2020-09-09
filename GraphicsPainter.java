package spaceshapes;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public class GraphicsPainter implements Painter {
	// Delegate object.
	private Graphics _g;

	/**
	 * Creates a GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this._g = g;
		_g.setColor(new Color(212, 212, 212));
	}

	/**
	 * @see spaceshapes.Painter.drawRect
	 */
	public void drawRect(int x, int y, int width, int height) {
		_g.drawRect(x, y, width, height);
	}

	/**
	 * @see spaceshapes.Painter.drawOval
	 */
	public void drawOval(int x, int y, int width, int height) {
		_g.drawOval(x, y, width, height);
	}

	/**
	 * @see spaeshapes.Painter.drawLine.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_g.drawLine(x1, y1, x2, y2);
	}
	
	/**
	 * @see spaeshapes.Painter.fillRect.
	 */
	public void fillRect(int x, int y, int width, int height) {
		_g.fillRect(x, y, width, height);
	}
	
	/**
	 * @see spaeshapes.Painter.setColor.
	 */
	public void setColor(Color c) {
		_g.setColor(c);
	}
	
	/**
	 * @see spaeshapes.Painter.getColor.
	 */
	public Color getColor() {
		return _g.getColor();
	}
	
	/**
	 * @see spaeshapes.Painter.translate.
	 */
	public void translate (int x, int y) {
		_g.translate(x, y);
	}
	
	/**
	 * @see spaeshapes.Painter.drawCentredText.
	 */
	public void drawCentredText(String Text, int shapeWidth, int shapeHeight) {
		FontMetrics m =_g.getFontMetrics();
		int width = m.stringWidth(Text);
		int height = m.getHeight();
		int y = 0;
		if (m.getAscent()>m.getDescent()) {
			y = (m.getAscent()-m.getDescent())/2;
		}else if(m.getAscent()<m.getDescent()) {
			y = -(m.getDescent()-m.getAscent())/2;
		}
		_g.drawString(Text, (shapeWidth/2)-(width/2), (shapeHeight/2)+(height/2)+y);
	}
}
