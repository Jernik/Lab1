package DisplayObjects;

import javax.swing.JFrame;
import java.lang.Runnable;
import java.awt.*;

/**
* This class is a blank JFrame that moves to the edge of the screen while
* shrinking in size to give the notion of falling.
*/
public class DeathPanel extends JFrame implements Runnable {

	/**
	* Velocity vector of the frame
	*/
	float xVel,yVel;
	/**
	* Constructor
	* @param x The x location of the frame
	* @param y The y location of the frame
	*/
	public DeathPanel(int x,int y) {
		setLocation(x,y);
		setSize(266,266);
		setUndecorated(true);
		setVisible(true);
		Graphics g=getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0,0,266,266);
	}
	/**
	* Method to begin falling animation
	*/
	public void fall() {
		try {Thread thread=new Thread(this);
		thread.start();} catch (Exception e) {}
	}
	/**
	* This method contains the while loop to shrink and move the frame
	*/
	public void run() {
		while(getLocation().getY()<1100) {
			try {Thread.sleep(10);}catch (Exception e) {}
			setLocation((int)(getLocation().getX()+xVel),(int)(getLocation().getY()+yVel));
			setSize((int)(getSize().width-yVel-2),(int)(getSize().width-yVel-2));
		}
	}
	/**
	* This method paints the frame completely black
	* @param g The Graphics object to draw to
	*/
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0,0,266,266);
	}

}