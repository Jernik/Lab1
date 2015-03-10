package DisplayObjects;

import javax.swing.JInternalFrame;
import java.awt.*;
import java.awt.event.KeyEvent;

public class PylonScreen extends JInternalFrame {

	/**
	* The JFrame that contains everything.
	*/
	public DisplayObjects.Display D;
	/**
	* The Pylon that corresponds to this Frame
	*/
	public ConcreteObject.Pylon pylon=null;
	
	public PylonScreen() {
		setSize(600,600);
		setLocation(100,100);
		setVisible(false);
	}
	
	public void paint(Graphics g) {
		System.out.println("PAINTING");
		g.setColor(Color.RED);
		g.fillRect(100,100,600,600);
		g.setColor(Color.GREEN);
		g.drawRect(100,100,600,600);
	}
	
	public void keyReleased(KeyEvent e) {}

}