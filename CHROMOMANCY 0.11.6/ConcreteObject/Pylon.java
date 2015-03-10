package ConcreteObject;

import java.awt.Graphics;

/**
* This class opens an action box when the player goes near.
*/
public class Pylon {

	/**
    * The JFrame that contains everything.
    */
    public DisplayObjects.Display D;
	/**
	* Whether or not this pylon is being used
	*/
	public boolean activated=false;
	/**
	* The JInternalFrame that corresponds to this Pylon
	*/
	public DisplayObjects.PylonScreen actionFrame=null;
	
	public Pylon() {}
	
	public void activate() {
		activated=true;
	}
	
	public void deactivate() {
		activated=false;
	}
	
	public void paint(Graphics g) {
		if (activated) {
			actionFrame.paint(g);
		}
	}
	
	public void init() {}

}