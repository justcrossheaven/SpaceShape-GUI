package spaceshapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



/**
 * Simple GUI program to show an animation of shapes in a confined space. Class AnimationViewer is
 * a special kind of GUI component (JPanel), and as such an instance of 
 * AnimationViewer can be added to a JFrame object. A JFrame object is a 
 * window that can be closed, minimised, and maximised. The state of an
 * AnimationViewer object comprises a list of Shapes and a Timer object. An
 * AnimationViewer instance subscribes to events that are published by a Timer.
 * In response to receiving an event from the Timer, the AnimationViewer iterates 
 * through a list of Shapes requesting that each Shape paints and moves itself.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
@SuppressWarnings("serial")
public class AnimationViewer extends JPanel implements ActionListener {
	// Frequency in milliseconds for the Timer to generate events.
	private static final int DELAY = 5;

	// Collection of Shapes to animate.
	private List<Shape> _shapes;

	private Timer _timer = new Timer(DELAY, this);

	/**
	 * Creates an AnimationViewer instance with a list of Shape objects and 
	 * starts the animation.
	 */
	public AnimationViewer() {
		this.setBackground(Color.BLACK);
		_shapes = new ArrayList<Shape>();
	
		// Populate the list of Shapes.
		//_shapes.add(new RectangleShape(0, 0, 0, 0, 100, 100));
		//_shapes.add(new RectangleShape(0, 0, 1, 1, 70, 70));
		//_shapes.add(new OvalShape(0,50, 0,0, 300, 300));
		//_shapes.add(new HexagonShape(0,0,1,1,100,100));
		//_shapes.add(new HexagonShape(100,200,4,7,300,200));
		//_shapes.add(new HexagonShape(400,120,3,5,39,20));
		//_shapes.add(new OvalShape(0,0,1, 1));
		//_shapes.add(new RectangleShape(0, 0, 1, 1));
		//_shapes.add(new DynamicShape(300,300,3,1,100,100,Color.YELLOW));
		//_shapes.add(new DynamicShape(400,600,2,1,150,140,Color.GREEN));
		//_shapes.add(new DynamicShape(400,800,2,2,150,140,new Color(153)));
		
		
		Shape shape1 = new OvalShape(40,30,1,1,30,30);
		Shape shape2 = new RectangleShape(10,10,3,2,20,20);
		//Shape shape3 = new RectangleShape(20,0,2,1,60,60);
		Shape shape4 = new DynamicShape(50,50,2,1,50,50, Color.GREEN);
		CarrierShape CS = new CarrierShape(500,500,1,1,100,100);
		CarrierShape CS2 = new CarrierShape(0,0,2,1,300,300);
		Shape shape5 = new RectangleShape(20,20,1,2,70,70);
		CS2.add(shape5);
		CS.add(shape1);
		CS.add(shape2);
		//shape2.add(shape3);
		//CS.add(shape3);
		CS.add(shape4);
		_shapes.add(CS);
		_shapes.add(CS2);
		int k = (Integer) null;
		CarrierShape CCC = new CarrierShape(k, k);
		_shapes.add(CCC);
		//shape1.parent();*/
		
		/*CarrierShape _topLevelNest = new CarrierShape(100, 100, 1, 1, 500, 500);
		CarrierShape _midLevelNest = new CarrierShape(0, 0, 1, 1, 250, 250);
		CarrierShape _bottomLevelNest = new CarrierShape(10, 10, 1, 1, 50, 50);
		Shape _simpleShape1 = new HexagonShape(0,0,1,1,30,30);
		Shape _simpleShape = new DynamicShape(0, 0, 2, 1, 20, 20, Color.WHITE);
		_bottomLevelNest.add(_simpleShape1);
		_midLevelNest.add(_bottomLevelNest);
		_midLevelNest.add(_simpleShape);
		_topLevelNest.add(_midLevelNest);
		_shapes.add(_topLevelNest);*/
		
		//TEXT
		Shape shape = new RectangleShape(100,100,1,1,100,100);
		shape.setText("Congrats");
		_shapes.add(shape);
		
		// Start the animation.
		_timer.start();
	}

	/**
	 * Called by the Swing framework whenever this AnimationViewer object
	 * should be repainted. This can happen, for example, after an explicit 
	 * repaint() call or after the window that contains this AnimationViewer 
	 * object has been opened, exposed or moved.
	 * 
	 */
	public void paintComponent(Graphics g) {
		// Call inherited implementation to handle background painting.
		super.paintComponent(g);
		
		// Calculate bounds of animation screen area.
		int width = getSize().width;
		int height = getSize().height;
		
		// Create a GraphicsPainter that Shape objects will use for drawing.
		// The GraphicsPainter delegates painting to a basic Graphics object.
		Painter painter = new GraphicsPainter(g);
		// Progress the animation.
		for(Shape s : _shapes) {
			s.paint(painter);
			s.move(width, height);
			s.displayText(painter);
		}
	}

	/**
	 * Notifies this AnimationViewer object of an ActionEvent. ActionEvents are
	 * received by the Timer.
	 */
	public void actionPerformed(ActionEvent e) {
		// Request that the AnimationViewer repaints itself. The call to 
		// repaint() will cause the AnimationViewer's paintComponent() method 
		// to be called.
		repaint();
	}
	
	
	/**
	 * Main program method to create an AnimationViewer object and display this
	 * within a JFrame window.
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Animation viewer");
				frame.add(new AnimationViewer());
		
				// Set window properties.
				frame.setSize(1200, 800);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
}
